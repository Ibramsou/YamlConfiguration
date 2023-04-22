package fr.bramsou.yaml.api.configuration;

import java.io.File;

public interface YamlConfigurationManager {

    /**
     * Load a new configuration
     *
     * @param instance Instance of your configuration (work with any object)
     * @param file The file you want to save your configuration
     * @param type The type of configuration (Simple or Dynamic)
     * @return an instance of YamlConfiguration
     */
    YamlConfiguration loadConfiguration(Object instance, File file, ConfigurationType type);
}
