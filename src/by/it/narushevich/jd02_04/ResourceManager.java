package by.it.narushevich.jd02_04;

import java.util.Locale;
import java.util.ResourceBundle;

enum ResourceManager {
    INSTANCE;

    private ResourceBundle resourceBundle;
    private String name = "by.it.narushevich.jd02_04.res.message";

    ResourceManager() {
        this.resourceBundle = ResourceBundle.getBundle(name, Locale.getDefault());
    }

    public void changeLocale(Locale locale){
        resourceBundle = ResourceBundle.getBundle(name, locale);
    }

    public String getString (String key) {
        return resourceBundle.getString(key);
    }
}
