package fr.bramsou.yaml.api.configuration.dynamic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Usable on fields
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ConfigurationKeys {

    /**
     * Default comments defined above every configuration key
     * @return an array of string
     */
    String[] keyComments() default {};

    /**
     * Default keys in the configuration section
     *
     * @return an array of string
     */
    String[] defaultKeys() default {};
}
