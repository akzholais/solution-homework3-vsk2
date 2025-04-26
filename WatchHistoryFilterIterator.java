package src;

import java.util.List;

public class WatchHistoryFilterIterator implements EpisodeIterator {
    private EpisodeIterator iterator;
    private List<Episode> watchedEpisodes;

    public WatchHistoryFilterIterator(EpisodeIterator iterator, List<Episode> watchedEpisodes) {
        this.iterator = iterator;
        this.watchedEpisodes = watchedEpisodes;
    }

    @Override
    public boolean hasNext() {
        while (iterator.hasNext()) {
            Episode episode = iterator.next();
            if (!watchedEpisodes.contains(episode)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Episode next() {
        return iterator.next();
    }
}
