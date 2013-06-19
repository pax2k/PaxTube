package no.koteng.paxTube;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class ThumbnailImage extends Panel {

    public ThumbnailImage(String id, String imageUrl, String imageText, String infoText) {
        super(id);

        Label title = new Label("imageText", imageText);
        Label infoTextLabel = new Label("infoText", infoText);

        add(new Image("image", imageUrl));
        add(title);
        add(infoTextLabel);
    }
}
