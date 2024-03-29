package fr.bramsou.yaml.core.configuration;

import fr.bramsou.yaml.api.configuration.ConfigurationException;
import fr.bramsou.yaml.api.configuration.YamlConfiguration;
import fr.bramsou.yaml.api.configuration.YamlSection;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.representer.Representer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

public abstract class Configuration extends ConfigurationSection implements YamlConfiguration {

    protected final File file;
    protected final Yaml yaml;

    public Configuration(File file) {
        this.file = file;
        DumperOptions options = new DumperOptions();
        options.setIndent(2);
        options.setAllowUnicode(true);
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        Representer representer = new Representer(options) {{
            this.representers.put(ConfigurationSection.class, data -> represent(((YamlSection) data).getEntries()));
        }};
        representer.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);

        this.yaml = new Yaml(new Constructor(new LoaderOptions()), representer, options);
        if (!this.file.exists()) {
            if (this.file.getParentFile() != null && !this.file.getParentFile().exists()) this.file.getParentFile().mkdirs();
            try {
                this.file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void load() {
        try (BufferedInputStream input = new BufferedInputStream(Files.newInputStream(this.file.toPath()))) {
            Map<String, Object> map = this.yaml.load(input);
            if (map == null) return;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String path = entry.getKey();
                Object value = entry.getValue();

                if (value instanceof Map) {
                    ConfigurationSection section = new ConfigurationSection();
                    section.loadFromMap((Map<String, Object>) value);
                    this.entries.put(path, section);
                    continue;
                }

                this.entries.put(path, value);
            }
        } catch (IOException e) {
            throw new ConfigurationException("Cannot load configuration file (" + this.file.getPath() + ")", e);
        }
    }

    @Override
    public File getFile() {
        return this.file;
    }

}
