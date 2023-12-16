import java.util.HashMap;
import java.util.Map;

// Singleton Class
public class AppSettingsSingleton {
    private static AppSettingsSingleton instance = new AppSettingsSingleton();

    // Configuration settings can be stored in a HashMap
    private Map<String, String> settings;

    // Private constructor to prevent instantiation from outside
    private AppSettingsSingleton() {
        settings = new HashMap<>();
        // Load settings from a file, database, or hardcoded values
        settings.put("theme", "Light");
        settings.put("language", "English");
    }

    public static AppSettingsSingleton getInstance() {
        return instance;
    }

    public String getSetting(String key) {
        return settings.getOrDefault(key, "Not Found");
    }

    public void setSetting(String key, String value) {
        settings.put(key, value);
    }
}
