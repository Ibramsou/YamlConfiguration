package fr.bramsou.yaml.api;

import java.util.Iterator;
import java.util.ServiceLoader;

public class YamlApiService {

    private static final YamlAPI api;

    static {
        ServiceLoader<YamlAPI> loader = ServiceLoader.load(YamlAPI.class, YamlApiService.class.getClassLoader());
        Iterator<YamlAPI> iterator = loader.iterator();
        if (iterator.hasNext()) {
            api = iterator.next();
        } else {
            throw new IllegalStateException(String.format("No %s implementation found ! ", YamlAPI.class.getSimpleName()));
        }
    }

    public static YamlAPI getApi() {
        return api;
    }
}
