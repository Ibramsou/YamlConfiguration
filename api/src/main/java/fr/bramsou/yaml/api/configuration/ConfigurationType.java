package fr.bramsou.yaml.api.configuration;

public enum ConfigurationType {
    /**
     * Create a basic configuration
     * Working with YamlSection methods
     */
    SIMPLE,
    /**
     * Create a dynamic configuration
     * Working with annotations (@ConfigurationHeader / @ConfigurationKeys / @ConfigurationPath)
     * And YamlSection methods
     */
    DYNAMIC
}
