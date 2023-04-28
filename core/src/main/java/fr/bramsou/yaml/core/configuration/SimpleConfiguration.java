package fr.bramsou.yaml.core.configuration;

import fr.bramsou.yaml.api.configuration.ConfigurationException;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class SimpleConfiguration extends Configuration {

    public SimpleConfiguration(File file) {
        super(file);
    }

    @Override
    public void save() {
        try (OutputStreamWriter writer = new OutputStreamWriter(Files.newOutputStream(this.file.toPath()), StandardCharsets.UTF_8)) {
            writer.write(this.yaml.dump(this.entries));
        } catch (IOException e) {
            throw new ConfigurationException("Cannot save configuration file (" + this.file.getPath() + ")", e);
        }
    }
}
