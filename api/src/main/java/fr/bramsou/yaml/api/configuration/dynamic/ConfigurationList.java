package fr.bramsou.yaml.api.configuration.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a list of sub configuration parts in the configuration
 * Every field of this type can be annotated by @ConfigurationKeys to set the default keys names and comments
 *
 * @param <V> The type of the configuration part
 */
public abstract class ConfigurationList<V extends ConfigurationPart> extends ArrayList<V> {

    /**
     * Default section created while configuration is loading
     *
     * @param key the path of the configuration part
     * @return
     */
    public abstract ConfigurationPart create(String key);

    public ConfigurationList(List<V> defaults) {
        super(defaults);
    }
}
