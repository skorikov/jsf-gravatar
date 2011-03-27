package de.proskor.gravatar;

import javax.faces.component.UIComponentBase;

public class Gravatar extends UIComponentBase {
	public static final String COMPONENT_FAMILY = "gravatar.components";
	public static final String BASE_URL = "http://www.gravatar.com/avatar/";
	public static final int DEFAULT_SIZE = 80;

	@Override
	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String getEmail() {
		return (String) getStateHelper().eval("email");
	}

	public void setEmail(String value) {
		getStateHelper().put("email", value);
	}

	public int getSize() {
		return (Integer) getStateHelper().eval("size", DEFAULT_SIZE);
	}

	public void setSize(int value) {
		getStateHelper().put("size", value);
	}

	public String getDefault() {
		return (String) getStateHelper().eval("default", "mm");
	}

	public void setDefault(String value) {
		getStateHelper().put("default", value);
	}

	public String getHash() {
		return GravatarUtils.getInstance().getHash(getEmail());
	}
}
