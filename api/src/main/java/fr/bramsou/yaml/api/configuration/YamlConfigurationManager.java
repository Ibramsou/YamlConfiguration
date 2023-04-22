package fr.bramsou.yaml.api.configuration;

import java.io.File;

public interface YamlConfigurationManager {

    YamlConfiguration loadConfiguration(Object instance, File file, ConfigurationType type);
}
