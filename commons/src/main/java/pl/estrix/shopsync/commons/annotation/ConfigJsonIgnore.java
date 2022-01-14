package pl.estrix.shopsync.commons.annotation;

import org.codehaus.jackson.annotate.JacksonAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marker annotation that indicates that the annotated method or field is to be
 * ignored by introspection-based serialization and deserialization functionality
 * based on the property in configuration.
 *
 * Annotation is similar to {@link org.codehaus.jackson.annotate.JsonIgnore}
 *
 * Creation Date: 05.12.2016 11:14
 *
 * @author Marcin Slowik (masl)
 * @since 0.6.0.2
 */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotation
public @interface ConfigJsonIgnore {
    /**
     * Optional argument that defines whether this annotation is active
     * or not. The only use for value 'false' if for overriding purposes
     * (which is not needed often); most likely it is needed for use
     * with "mix-in annotations" (aka "annotation overrides").
     * For most cases, however, default value of "true" is just fine
     * and should be omitted.
     * @return
     */
    boolean value() default true;
}
