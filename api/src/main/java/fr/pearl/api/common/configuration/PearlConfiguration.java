package fr.pearl.api.common.configuration;

import java.io.File;

public interface PearlConfiguration extends PearlSection {

    void load();

    void save();

    File getFile();
}
