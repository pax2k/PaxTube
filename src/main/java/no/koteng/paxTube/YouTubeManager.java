package no.koteng.paxTube;

import com.google.gdata.client.youtube.YouTubeQuery;
import com.google.gdata.client.youtube.YouTubeService;
import com.google.gdata.data.youtube.VideoEntry;
import com.google.gdata.data.youtube.VideoFeed;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class YouTubeManager {
    private static Logger logger = Logger.getLogger(YouTubeManager.class.getName());
    private static final String YOUTUBE_URL = "http://gdata.youtube.com/feeds/api/videos";

    public static List<YouTubeMovie> doSearch(String textQuery) throws Exception {
        logger.info("New search:'" + textQuery + "'");

        YouTubeService service = new YouTubeService("akkTube");
        service.setConnectTimeout(5000); // millis
        YouTubeQuery query = new YouTubeQuery(new URL(YOUTUBE_URL));

        query.setOrderBy(YouTubeQuery.OrderBy.RELEVANCE);
        query.setFullTextQuery(textQuery);
        query.setSafeSearch(YouTubeQuery.SafeSearch.NONE);
        query.setMaxResults(8);

        VideoFeed videoFeed = service.query(query, VideoFeed.class);
        List<VideoEntry> videos = videoFeed.getEntries();

        return parseResult(videos);
    }

    private static List<YouTubeMovie> parseResult(List<VideoEntry> videos) {

        List<YouTubeMovie> youtubeVideosList = new ArrayList<YouTubeMovie>();

        for (VideoEntry videoEntry : videos) {
            final String id = videoEntry.getMediaGroup().getVideoId();
            final String title = videoEntry.getTitle().getPlainText();
            final String thumbnail = videoEntry.getMediaGroup().getThumbnails().get(0).getUrl();
            final String nameUploader = videoEntry.getAuthors().get(0).getName();
            final String viewCount = String.valueOf(videoEntry.getStatistics().getViewCount());

            YouTubeMovie currentMovie = new YouTubeMovie(id, title, thumbnail, nameUploader, viewCount);

            youtubeVideosList.add(currentMovie);
        }

        return youtubeVideosList;
    }

}
