package src;

import java.util.ArrayList;
import java.util.List;

public class Season implements Iterable<Episode> {
    private final List<Episode> episodes;

    public Season() {
        episodes = new ArrayList<>();
    }

    public void addEpisode(Episode e) {
        episodes.add(e);
    }

    @Override
    public EpisodeIterator iterator() {
        return new SeasonIterator(this);  // Возвращаем SeasonIterator, который реализует EpisodeIterator
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }
}
