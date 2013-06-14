package no.koteng.paxTube;

import java.io.Serializable;

public class YouTubeMovie implements Serializable {

    private String id;
    private String title;
    private String thumbnail;

    public YouTubeMovie(String id, String title, String thumbnail) {
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
