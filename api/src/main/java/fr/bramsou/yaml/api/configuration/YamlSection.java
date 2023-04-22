package fr.bramsou.yaml.api.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface YamlSection {

    /**
     * Set value in configuration path
     *
     * @param path Selected path
     * @param value Generic typed value you want to put
     * @param <T> Generic type
     */
    <T> void set(String path, T value);

    /**
     * Get a generic typed value
     *
     * @param path Selected path
     * @param defaultValue Value loaded by default in the config
     * @return the generic value identified by "T"
     * @param <T> Generic type
     */
    <T> T get(String path, T defaultValue);

    /**
     * Get an instance of YamlSection at the selected path
     * Info: every YamlSection can have subsections
     *
     * @param path Selected path
     * @return an instance of YamlSection
     */
    YamlSection getSection(String path);

    /**
     * Get a String at selected path
     *
     * @param path Selected path
     * @param defaultValue Value loaded by default in the config
     * @return the string returned by the config path
     */
    default String getString(String path, String defaultValue) {
        return get(path, defaultValue);
    }

    /**
     * Get a boolean at selected path
     *
     * @param path Selected path
     * @param defaultValue Value loaded by default in the config
     * @return the boolean returned by the config path
     */
    default boolean getBoolean(String path, boolean defaultValue) {
        return get(path, defaultValue);
    }

    /**
     * Get an integer at selected path
     *
     * @param path Selected path
     * @param defaultValue Value loaded by default in the config
     * @return the int returned by the config path
     */
    default int getInteger(String path, int defaultValue) {
        return get(path, defaultValue);
    }

    /**
     * Get a double at selected path
     *
     * @param path Selected path
     * @param defaultValue Value loaded by default in the config
     * @return the double returned by the config path
     */
    default double getDouble(String path, double defaultValue) {
        return get(path, defaultValue);
    }

    /**
     * Get a float at selected path
     *
     * @param path Selected path
     * @param defaultValue Value loaded by default in the config
     * @return the float returned by the config path
     */
    default float getFloat(String path, float defaultValue) {
        return get(path, defaultValue);
    }

    /**
     * Get a list of generic typed values
     *
     * @param path Selected path
     * @param defaultValue Value loaded by default in the config
     * @return an ArrayList of "T" returned by the config path
     * @param <T> Generic type
     */
    default <T> List<T> getList(String path, List<T> defaultValue) {
        return get(path, defaultValue);
    }

    /**
     * Get a list of string in the section
     *
     * @param path Selected path
     * @param defaultValue Value loaded by default in the config
     * @return an ArrayList of String returned by the config path
     */
    default List<String> getStringList(String path, List<String> defaultValue) {
        return get(path, defaultValue);
    }

    default List<String> getColoredList(String path, List<String> defaultValue) {
        List<String> list = getStringList(path, defaultValue);
        List<String> coloredList = new ArrayList<>(list.size());
        for (String value : list) {
            coloredList.add(value.replaceAll("&", "§"));
        }

        return coloredList;
    }

    Set<String> getKeys();

    Map<String, Object> getEntries();
}
