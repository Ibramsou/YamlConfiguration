package fr.bramsou.yaml.api.configuration.dynamic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Usable on classes
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ConfigurationHeader {

    /**
     * Define the header comment of the configuration
     * @return an array of string
     */
    String[] value();
}
