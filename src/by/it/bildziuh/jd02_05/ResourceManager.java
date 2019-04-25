package by.it.bildziuh.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;

    private ResourceBundle resourceBundle;
    private String baseName = "by.it.bildziuh.jd02_05.res.messages";
    private Locale locale;

    ResourceManager() {
        locale=Locale.getDefault();
        setLocale(locale);
    }

    String getString(String key){
        return resourceBundle.getString(key);
    }

    void setLocale(Locale locale){
        this.resourceBundle = ResourceBundle.getBundle(baseName, locale);
    }

    void switchLocale(Locale locale){
        this.resourceBundle = ResourceBundle.getBundle(baseName, locale);
    }
}
