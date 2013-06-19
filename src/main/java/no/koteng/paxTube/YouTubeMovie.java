package no.koteng.paxTube;

import java.io.Serializable;

public class YouTubeMovie implements Serializable {

    private String id;
    private String title;
    private String thumbnail;
    private String uploaderName;
    private String viewCount;

    public YouTubeMovie(String id, String title, String thumbnail, String uploaderName, String viewCount) {
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.uploaderName = uploaderName;
        this.viewCount = viewCount;
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

    public String getUploaderName() {
        return uploaderName;
    }

    public String getViewCount() {
        return viewCount;
    }

}
