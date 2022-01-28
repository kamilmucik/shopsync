package pl.estrix.shopsync.commons.mock;


import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional({ OnSubstituteNotExistsCondition.class, OnSubstituteMethodNotExistsCondition.class, OnForceApiMockCondition.class})
public @interface ReplaceableComponent {

    String packageName() default "pl.estrix.shopsync";
}