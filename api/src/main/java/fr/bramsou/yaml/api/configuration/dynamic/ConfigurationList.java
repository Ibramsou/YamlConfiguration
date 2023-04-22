package fr.bramsou.yaml.api.configuration.dynamic;

import java.util.ArrayList;
import java.util.List;

public abstract class ConfigurationList<V extends ConfigurationPart> extends ArrayList<V> {

    public abstract ConfigurationPart create(String key);

    public ConfigurationList(List<V> defaults) {
        super(defaults);
    }
}
