package by.it.eslaikouskaya.calc;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
	INSTANCE;

	private ResourceBundle resourceBundle;
	private String baseName = "by.it.eslaikouskaya.calc.i18n.res.errorMessages";
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