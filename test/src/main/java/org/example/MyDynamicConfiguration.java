package org.example;

import fr.bramsou.yaml.api.YamlAPI;
import fr.bramsou.yaml.api.configuration.ConfigurationType;
import fr.bramsou.yaml.api.configuration.YamlConfiguration;
import fr.bramsou.yaml.api.configuration.dynamic.ConfigurationPart;
import fr.bramsou.yaml.api.configuration.dynamic.annotation.ConfigurationPath;
import fr.bramsou.yaml.api.configuration.dynamic.annotation.ConfigurationReplacement;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyDynamicConfiguration {

    @ConfigurationPath(value = "example-value", comments = "Here is an example value :)")
    public String exampleValue = "Hi !";
    @ConfigurationPath("example-size")
    public int exampleSize = 451;
    @ConfigurationPath("replaced-value")
    @ConfigurationReplacement(values = "$", replacements = "S")
    public String replacedValue = "&cHi ! $$$"; // If you using bukkit / bungee, color codes will be translated by default with configuration replacement
    @ConfigurationPath(value = "sub-section", comments = "Here is my sub config section ! :)")
    @ConfigurationReplacement
    public MyConfigurationSection subSection = new MyConfigurationSection();
    @ConfigurationPath(value = "siann", comments = "Here is an example value :)")
    public String siann = "Bg";

    private static class MyConfigurationSection extends ConfigurationPart {
        @ConfigurationPath("enabled")
        public boolean enabled = true;
        @ConfigurationPath("players")
        public List<String> players = new ArrayList<>(Arrays.asList("Bramsou", "Ibrahim"));
    }

    public MyDynamicConfiguration() {
        final File configFile = new File("config.yml"); // file will be automatically created if not exists
        final YamlConfiguration configuration = YamlAPI.INSTANCE.getConfigurationManager()
                .loadConfiguration(this, configFile, ConfigurationType.DYNAMIC);
        // You always need to load & save for dynamic config types
        configuration.load();
        configuration.save();
    }

    public static void main(String[] args) {
        MyDynamicConfiguration configuration = new MyDynamicConfiguration();
        System.out.println(configuration.exampleSize);
    }
}
