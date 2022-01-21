package fr.pearl.core.common;

import fr.pearl.api.common.PearlAPI;
import fr.pearl.api.common.configuration.PearlConfigurationManager;
import fr.pearl.core.common.configuration.ConfigurationManager;

public class CoreAPI extends PearlAPI {

    private final ConfigurationManager configurationManager;

    public CoreAPI() {
        setInstance(this);
        this.configurationManager = new ConfigurationManager();
    }

    @Override
    public PearlConfigurationManager getConfigurationManager() {
        return this.configurationManager;
    }
}
