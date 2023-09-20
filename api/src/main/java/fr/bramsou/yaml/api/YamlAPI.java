package fr.bramsou.yaml.api;

import fr.bramsou.yaml.api.configuration.YamlConfigurationManager;
import fr.bramsou.yaml.api.util.Reflection;

public interface YamlAPI {

    /**
     * Get the instance of the YamlAPI
     */
    YamlAPI INSTANCE = YamlApiService.getApi();

    /**
     * Get configuration manager
     * @return an instance of YamlConfigurationManager
     */
    YamlConfigurationManager getConfigurationManager();
}
