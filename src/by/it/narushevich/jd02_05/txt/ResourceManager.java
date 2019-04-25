package by.it.narushevich.jd02_05.txt;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;

    private ResourceBundle resourceBundle;
    private String baseName = "by.it.narushevich.jd02_05.message";
    private Locale locale;

    private ResourceManager() {
        locale = Locale.getDefault();
        this.resourceBundle = ResourceBundle.getBundle(baseName,locale);
    }
}
