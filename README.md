# Description
You need yaml configuration api with comments and with easy use ?

This API is for you !

Dynamic-Yaml-Configuration works with runtime annotations, it permit to create configuration values with a great ease.

Extremly modulable, and useful, but not optimized (due to comments and lot of reflection uses with annotations)

You should use it only for low-storage configurations
# Implementation
### Gradle
```gradle
repositories {
    mavenCentral()
}

dependencies {
    implementation 'io.github.ibramsou:dynamic-yaml-configuration-api:1.3.0'
    implementation 'io.github.ibramsou:dynamic-yaml-configuration-core:1.3.0'
}
```
### Maven
```xml
<dependencies>
    <dependency>
        <groupId>io.github.ibramsou</groupId>
        <artifactId>dynamic-yaml-configuration-api</artifactId>
        <version>1.3.0</version>
    </dependency>
        <dependency>
        <groupId>io.github.ibramsou</groupId>
        <artifactId>dynamic-yaml-configuration-core</artifactId>
        <version>1.3.0</version>
    </dependency>
</dependencies>
```
# How to use
### Annotated Configuration Values
```java
public class MyDynamicConfiguration {

    @ConfigurationPath(value = "example-value", comments = "Here is an example value :)")
    public String exampleValue = "Hi !";
    @ConfigurationPath("test.size")
    public int exampleSize = 451;

    public MyDynamicConfiguration() {
        final File configFile = new File("config.yml"); // file will be automatically created if not exists
        final YamlConfiguration configuration = YamlAPI.INSTANCE.getConfigurationManager()
                .loadConfiguration(this, configFile, ConfigurationType.DYNAMIC);
        // You always need to load & save for dynamic config types
        configuration.load();
        configuration.save();
    }
}
```
### Automatic Config Translation
```java
@ConfigurationPath("replaced-value")
@ConfigurationReplacement(values = "$", replacements = "S")
// If you using bukkit / bungee, color codes will be translated with configuration replacement
public String replacedValue = "&cHi ! $$$"; 
```
*Note: You can create your packet handler interface in relation with your own custom packets*
### Dynamic Sections
You can also seperate your configuration sections with ``ConfigurationPart`` objects
```java
@ConfigurationPath(value = "sub-section", comments = "Here is my sub config section ! :)")
@ConfigurationReplacement
public MyConfigurationSection subSection = new MyConfigurationSection();
    
private static class MyConfigurationSection extends ConfigurationPart {
    @ConfigurationPath("enabled")
    public boolean enabled = true;
    @ConfigurationPath("players")
    public List<String> players = new ArrayList<>(Arrays.asList("Bramsou", "Ibrahim"));
    @ConfigurationPath("message")
    public String message = "&aHi :)";
}
```

*Note: If a section is anotated by ``@ConfigurationReplacement`` every values of the section will be replaced*
