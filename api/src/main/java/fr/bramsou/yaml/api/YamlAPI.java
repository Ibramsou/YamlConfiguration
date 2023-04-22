package fr.bramsou.yaml.api;

import fr.bramsou.yaml.api.configuration.YamlConfigurationManager;
import fr.bramsou.yaml.api.util.Reflection;

public interface YamlAPI {

    YamlAPI INSTANCE = Reflection.newInstance(Reflection.forName("fr.pearl.core.YamlCoreAPI").asSubclass(YamlAPI.class));

    YamlConfigurationManager getConfigurationManager();
}