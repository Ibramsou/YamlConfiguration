package fr.pearl.api.common;

import fr.pearl.api.common.configuration.PearlConfigurationManager;

public abstract class PearlAPI {

    private static PearlAPI instance;

    public static PearlAPI getInstance() {
        return instance;
    }

    protected static void setInstance(PearlAPI instance) {
        PearlAPI.instance = instance;
    }

    public abstract PearlConfigurationManager getConfigurationManager();
}
