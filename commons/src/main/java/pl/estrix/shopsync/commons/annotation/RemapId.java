package pl.estrix.shopsync.commons.annotation;

import org.codehaus.jackson.annotate.JacksonAnnotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Bean attribute annotated with this Annotation should be remapped to session's scope id
 * <p>
 * Creation Date: 2015-11-30
 *
 * @author Tomasz Chorwat
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@JacksonAnnotation
public @interface RemapId {

    String AUTHORIZATION_ORDER_ID_REMAP_NAME = "authOrderId";

    int MAX_LENGTH = 800;

    /**
     * @return name of session's scope id
     */
    String value();

    /**
     * If set this value should be used as key for crypto instead of sessionId
     *
     *
     */
    String keyValue() default "";

    /**
     * If this value is true salt should be used for crypto
     *
     *
     */
    boolean useSalt() default true;


    /**
     * List of supported remap id's. Dynamically value evaluated is validated against this list, if not found exception is thrown
     *
     *
     */
    String[] supportedValues() default {};


}