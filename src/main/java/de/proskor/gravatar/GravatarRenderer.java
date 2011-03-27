package de.proskor.gravatar;

import java.io.IOException;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

public class GravatarRenderer extends Renderer {
	@Override
	public boolean getRendersChildren() {
		return true;
	}

	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		Gravatar gravatar = (Gravatar) component;
		String url = Gravatar.BASE_URL + gravatar.getHash() + "?d=" + gravatar.getDefault();
		int size = gravatar.getSize();
		if (size != Gravatar.DEFAULT_SIZE) {
			 url += "&s=" + size;
		}
		writer.startElement("img", component);
		Map<String,Object> attributes = component.getAttributes();
		String klass = (String) attributes.get("styleClass");
		if (klass != null) {
			writer.writeAttribute("class", klass, "class");
		}
		writer.writeAttribute("id", gravatar.getClientId(), "id");
		writer.writeURIAttribute("src", url, null);
		writer.writeAttribute("width", size, null);
		writer.writeAttribute("height", size, null);
		writer.endElement("img");
	}
}
