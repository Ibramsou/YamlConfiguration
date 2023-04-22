package fr.bramsou.yaml.api.configuration;

import java.io.File;

/**
 * This class can contain subsections
 */
public interface YamlConfiguration extends YamlSection {

    /**
     * Load your configuration from the local file
     */
    void load();

    /**
     * Save your configuration file after modifications, or a simple load
     */
    void save();

    /**
     * Get the local file of your configuration
     *
     * @return the File
     */
    File getFile();
}
