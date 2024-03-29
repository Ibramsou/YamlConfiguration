package fr.bramsou.yaml.api.configuration.dynamic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Perform an automatic string replacement in the configuration load
 * Usable on String and List of string fields
 * Also usable on configuration part field, will perform a replacement for every string in the section
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ConfigurationReplacement {

    /**
     * Define the values you need to replace
     * @return an array of string
     */
    String[] values() default {};

    /**
     * Define the replacements, order must match with strings defined in ConfigurationReplacement#values()
     * @return an array of string
     */
    String[] replacements() default {};

    /**
     * Enable automatic color code translation (useful for bukkit and bungee chat colors)
     * @return true if translating color codes
     */
    boolean translateColorCodes() default true;

    /**
     * Color code char to translate
     * @return the code to translate
     */
    char colorCode() default '&';

    /**
     * Define the translation code
     * @return the translation code
     */
    char translateCode() default '\u00A7';
}
