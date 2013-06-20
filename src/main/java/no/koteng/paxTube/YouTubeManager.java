package no.koteng.paxTube;

import com.google.gdata.client.youtube.YouTubeQuery;
import com.google.gdata.client.youtube.YouTubeService;
import com.google.gdata.data.youtube.VideoEntry;
import com.google.gdata.data.youtube.VideoFeed;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class YouTubeManager {
    private static Logger logger = Logger.getLogger(YouTubeManager.class.getName());
    private static final String YOUTUBE_URL = "http://gdata.youtube.com/feeds/api/videos";

    public static List<YouTubeMovie> doSearch(String textQuery) throws Exception {
        logger.info("New search:'" + textQuery + "'");

        final int ConnectionTimeout = 5000;
        final int maxSearchResults = 8;

        YouTubeService service = new YouTubeService("akkTube");
        service.setConnectTimeout(ConnectionTimeout);
        YouTubeQuery query = new YouTubeQuery(new URL(YOUTUBE_URL));

        query.setOrderBy(YouTubeQuery.OrderBy.RELEVANCE);
        query.setFullTextQuery(textQuery);
        query.setSafeSearch(YouTubeQuery.SafeSearch.NONE);
        query.setMaxResults(maxSearchResults);

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
            final String viewCount = videoEntry.getStatistics() != null ? String.valueOf(videoEntry.getStatistics().getViewCount()): "unknown";
            final String duration = convertDurationToString(videoEntry.getMediaGroup().getDuration().intValue());

            YouTubeMovie currentMovie = new YouTubeMovie(id, title, thumbnail, nameUploader, viewCount, duration);

            youtubeVideosList.add(currentMovie);
        }

        return youtubeVideosList;
    }

    private static String convertDurationToString(int secs){
        int hours = secs / 3600,
                remainder = secs % 3600,
                minutes = remainder / 60,
                seconds = remainder % 60;

        String disHour = (hours < 10 ? "0" : "") + hours,
                disMinu = (minutes < 10 ? "0" : "") + minutes ,
                disSec = (seconds < 10 ? "0" : "") + seconds ;

       return disHour +":"+ disMinu+":"+disSec;
    }

}
