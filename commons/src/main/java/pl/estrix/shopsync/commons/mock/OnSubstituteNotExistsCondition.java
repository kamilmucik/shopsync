package pl.estrix.shopsync.commons.mock;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.reflections.Reflections;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.AnnotationMetadata;

import lombok.NoArgsConstructor;
import org.springframework.core.type.classreading.AnnotationMetadataReadingVisitor;
import org.springframework.util.MultiValueMap;

/**
 * Condition for replacing beans when substitution candidate exists.
 * Replacing component and replacement candidate are defined by annotations
 * {@link ReplacingComponent} {@link ReplaceableComponent}
 * Created by kamil.mucik on 2020-07-15
 */
@NoArgsConstructor
public class OnSubstituteNotExistsCondition extends SpringBootCondition {

    private final Log logger = LogFactory.getLog(this.getClass());

    private static volatile Set<Class<?>> replacingComponentAnnotatedClasses;

    @Override
    public ConditionOutcome getMatchOutcome(final ConditionContext conditionContext, final AnnotatedTypeMetadata annotatedTypeMetadata) {
        if (!(annotatedTypeMetadata instanceof AnnotationMetadataReadingVisitor)){
            return ConditionOutcome.match("No replacement found. Bean will be created");
        }
        synchronized (OnSubstituteNotExistsCondition.class) {
            if (replacingComponentAnnotatedClasses == null) {
                String packages = getPackage(annotatedTypeMetadata);

                Reflections r = new Reflections(packages);
                replacingComponentAnnotatedClasses = new HashSet<>();
                replacingComponentAnnotatedClasses.addAll(r.getTypesAnnotatedWith(ReplacingComponent.class));
            }
        }
        final Optional res = replacingComponentAnnotatedClasses.stream().filter(c -> {
            Annotation annotation = c.getAnnotation(ReplacingComponent.class);
            ReplacingComponent rc = (ReplacingComponent) annotation;
            Class rcClazz = rc.clazz();
            return className(annotatedTypeMetadata).equals(rcClazz.getName());
        }).findAny();
        if (res.isPresent()) {
            logger.info(String.format("Replacement found for %s. Bean will not be created", className(annotatedTypeMetadata)));
            return ConditionOutcome.noMatch("Replacement found. Bean will not be created");
        }
        logger.info(String.format("No replacement found for %s. Bean will be created", className(annotatedTypeMetadata)));
        return ConditionOutcome.match("No replacement found. Bean will be created");
    }

    private String className(final AnnotatedTypeMetadata metadata) {
        return ((AnnotationMetadata) metadata).getClassName();
    }

    private String getPackage(final AnnotatedTypeMetadata metadata) {
        MultiValueMap<String, Object> objectList = metadata.getAllAnnotationAttributes(ReplaceableComponent.class.getName());
        if (objectList!= null ){
            return (String) objectList.get("packageName").get(0);
        }
        return "OnSubstituteNotExistsCondition::getPackage::error";
    }
}