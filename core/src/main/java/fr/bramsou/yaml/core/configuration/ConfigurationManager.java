package fr.bramsou.yaml.core.configuration;

import fr.bramsou.yaml.api.configuration.ConfigurationType;
import fr.bramsou.yaml.api.configuration.YamlConfiguration;
import fr.bramsou.yaml.api.configuration.YamlConfigurationManager;
import org.apache.commons.lang.Validate;

import java.io.File;

public class ConfigurationManager implements YamlConfigurationManager {

    @Override
    public YamlConfiguration loadConfiguration(Object instance, File file, ConfigurationType type) {
        Validate.notNull(instance, "Instance cannot be null");
        Validate.notNull(file, "File cannot be null");
        Validate.notNull(type, "Configuration type cannot be null");
        if (type == ConfigurationType.SIMPLE) {
            return new SimpleConfiguration(file);
        } else {
            return new DynamicConfiguration(instance, file);
        }
    }
}
