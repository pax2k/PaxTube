package no.koteng.paxTube;

import java.io.Serializable;

public class YouTubeMovie implements Serializable {

    private String id;
    private String title;
    private String thumbnail;
    private String uploaderName;
    private String viewCount;
    private String duration;

    public YouTubeMovie(String id, String title, String thumbnail, String uploaderName, String viewCount, String duration) {
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.uploaderName = uploaderName;
        this.viewCount = viewCount;
        this.duration = duration;
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

    public String getDuration() {
        return duration;
    }
}
