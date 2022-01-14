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
 * {@link ReplacingComponent} {@link ReplaceableComponent}.
 */
@NoArgsConstructor
public class OnForceApiMockCondition extends SpringBootCondition {

    private final Log logger = LogFactory.getLog(this.getClass());

    private static volatile Set<Class<?>> replacingMockComponentAnnotatedClasses;

    @Override
    public ConditionOutcome getMatchOutcome(final ConditionContext conditionContext, final AnnotatedTypeMetadata annotatedTypeMetadata) {
        if (!(annotatedTypeMetadata instanceof AnnotationMetadataReadingVisitor)){
            return ConditionOutcome.match("No replacement found. Bean will be created");
        }
        final boolean isForce = isForceReplace(conditionContext);
        synchronized (OnSubstituteNotExistsCondition.class) {
            if (replacingMockComponentAnnotatedClasses == null) {
                replacingMockComponentAnnotatedClasses = new HashSet<>();
                Reflections r = new Reflections(getPackage(annotatedTypeMetadata));
                replacingMockComponentAnnotatedClasses.addAll(r.getTypesAnnotatedWith(ReplacingMockComponent.class));
            }
        }
        final Optional mockRes = replacingMockComponentAnnotatedClasses.stream().filter(c -> {
            Annotation annotation = c.getAnnotation(ReplacingMockComponent.class);
            ReplacingMockComponent rc = (ReplacingMockComponent) annotation;
            Class rcClazz = rc.clazz();
            return className(annotatedTypeMetadata).equals(rcClazz.getName()) && isForce;
        }).findAny();
        if (mockRes.isPresent()) {
            logger.info(String.format("Mock replacement found for %s. Bean will not be created", className(annotatedTypeMetadata)));
            return ConditionOutcome.noMatch("Mock replacement found. Bean will not be created");
        }
        logger.info(String.format("No mock replacement found for %s. Bean will be created", className(annotatedTypeMetadata)));
        return ConditionOutcome.match("No mock replacement found. Bean will be created");
    }

    private String className(final AnnotatedTypeMetadata metadata) {
        return ((AnnotationMetadata) metadata).getClassName();
    }

    private String getPackage(final AnnotatedTypeMetadata metadata) {
        MultiValueMap<String, Object> objectList = metadata.getAllAnnotationAttributes(ReplaceableComponent.class.getName());
        if (objectList!= null ){
            return (String) objectList.get("packageName").get(0);
        }
        return "OnForceApiMockCondition::getPackage::error";
    }

    private boolean isForceReplace(final ConditionContext conditionContext) {
        String forceApiMock = conditionContext.getEnvironment().getProperty("forceApiMock");
        return "true".equals(forceApiMock);
    }
}