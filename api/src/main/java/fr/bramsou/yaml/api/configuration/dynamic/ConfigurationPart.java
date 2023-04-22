package fr.bramsou.yaml.api.configuration.dynamic;

/**
 * Child classes of ConfigurationPart will be used as a sub configuration section
 */
public abstract class ConfigurationPart {

    private String name;

    /**
     * This method is called after the load of the configuration
     * After a configuration load, every field annotated by @ConfigurationPart can be changed in terms of the saved config
     * You can use this method as a parser, it allows you to parse the dynamic variables of the classes to another object
     */
    public void loaded() {}

    /**
     * Change the name of the section path
     *
     * @param name name to change
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the name of the section path
     *
     * @return name
     */
    public String getName() {
        return name;
    }
}
