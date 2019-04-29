package by.it.eslaikouskaya.jd02_05.TaskB;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
	INSTANCE;

	private ResourceBundle resourceBundle;
	private String baseName = "by.it.eslaikouskaya.jd02_05.TaskB.res.messages";
	private Locale locale;

	ResourceManager() {
		locale = Locale.getDefault();
		setLocale(locale);
	}

	public String getString(String key) {
		return resourceBundle.getString(key);
	}

	public void setLocale(Locale locale) {
		this.resourceBundle = ResourceBundle.getBundle(baseName, locale);
	}
}