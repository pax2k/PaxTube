package no.koteng.paxTube;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class ThumbnailImage extends Panel {

    public ThumbnailImage(String id, String imageUrl, String imageText, String infoText, String duration) {
        super(id);

        add(new Image("image", imageUrl));
        add(new Label("imageText", imageText));
        add(new Label("infoText", infoText));
        add(new Label("duration", "Duration: " + duration));
    }
}
