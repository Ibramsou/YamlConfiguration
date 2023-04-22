package fr.bramsou.yaml.core;

import fr.bramsou.yaml.api.YamlAPI;
import fr.bramsou.yaml.api.configuration.YamlConfigurationManager;
import fr.bramsou.yaml.core.configuration.ConfigurationManager;

public class YamlCoreAPI implements YamlAPI {

    private final ConfigurationManager configurationManager;

    public YamlCoreAPI() {
        this.configurationManager = new ConfigurationManager();
    }

    @Override
    public YamlConfigurationManager getConfigurationManager() {
        return this.configurationManager;
    }
}
