package by.it.narushevich.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

enum ResourceManager {
    INSTANCE;

    private ResourceBundle resourceBundle;
    private String baseName = "by.it.narushevich.jd02_05.res.message";

    ResourceManager() {
        this.resourceBundle = ResourceBundle.getBundle(baseName,Locale.getDefault());
    }

    public void changeLocale(Locale locale){
        resourceBundle = ResourceBundle.getBundle(baseName, locale);
    }

    public String getString (String key) {
        return resourceBundle.getString(key);
    }
}
