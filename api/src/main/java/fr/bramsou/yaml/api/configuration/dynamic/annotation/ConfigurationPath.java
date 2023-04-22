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
public @interface ConfigurationPath {

    /**
     * The configuration path of the value
     *
     * @return the path
     */
    String value();

    /**
     * An array of comments you want to add above the configuration path
     *
     * @return an array of string
     */
    String[] comments() default {};

    /**
     * The path of your comments
     * You can define a specific path for your comments
     * If not, the path returned by value() will be used
     *
     * @return comment path
     */
    String commentPath() default "";
}
