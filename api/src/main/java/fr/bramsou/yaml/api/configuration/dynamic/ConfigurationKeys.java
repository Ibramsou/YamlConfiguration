package fr.bramsou.yaml.api.configuration.dynamic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ConfigurationKeys {

    String[] keyComments() default {};

    String[] defaultKeys() default {};
}
