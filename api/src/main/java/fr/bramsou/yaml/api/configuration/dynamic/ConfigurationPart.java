package fr.bramsou.yaml.api.configuration.dynamic;

public abstract class ConfigurationPart {

    private String name;

    public void loaded() {}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
