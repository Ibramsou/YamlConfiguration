import fr.bramsou.yaml.api.YamlAPI;
import fr.bramsou.yaml.api.configuration.ConfigurationType;
import fr.bramsou.yaml.api.configuration.YamlConfiguration;
import fr.bramsou.yaml.api.configuration.dynamic.annotation.ConfigurationPath;

import java.io.File;

public class Main {

    @ConfigurationPath(value = "example-integer", comments = "Here is an example configurable integer")
    public int exampleInteger = 40;
    @ConfigurationPath(value = "example-boolean", comments = "Here is an example configurable boolean")
    public boolean exampleBoolean = false;

    public Main() {
        YamlConfiguration configuration = YamlAPI.INSTANCE.getConfigurationManager().loadConfiguration(
                this,
                new File("example.yml"),
                ConfigurationType.DYNAMIC
        );
        configuration.load();
        configuration.save();
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("Example Integer: " + main.exampleInteger);
        System.out.println("Example Boolean: " + main.exampleBoolean);
    }
}
