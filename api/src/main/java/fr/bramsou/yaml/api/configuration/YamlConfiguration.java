package fr.bramsou.yaml.api.configuration;

import java.io.File;

public interface YamlConfiguration extends YamlSection {

    void load();

    void save();

    File getFile();
}
