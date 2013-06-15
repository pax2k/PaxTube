package no.koteng.paxTube;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * Created by pax2k on 15.06.13.
 */
public class ThumbnailImage extends Panel {

    public ThumbnailImage(String id, String imageUrl, String imageText) {
        super(id);

        final Label label = new Label("imageText", "&nbsp;&nbsp;" + imageText);
        label.setEscapeModelStrings(false);

        add(new Image("image", imageUrl));
        add(label);
    }
}
