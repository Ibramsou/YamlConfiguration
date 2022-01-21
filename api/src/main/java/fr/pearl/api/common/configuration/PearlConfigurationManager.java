package fr.pearl.api.common.configuration;

import java.io.File;

public interface PearlConfigurationManager {

    PearlConfiguration loadConfiguration(Object instance, File file, ConfigurationType type);
}
