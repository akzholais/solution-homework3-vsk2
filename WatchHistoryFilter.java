package src;

import java.util.Iterator;
import java.util.Set;

class WatchHistoryFilter implements Iterator<Episode> {
    private Iterator<Episode> iterator;
    private Set<Episode> watchedEpisodes;

    public WatchHistoryFilter(Iterator<Episode> iterator, Set<Episode> watchedEpisodes) {
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
        Episode episode = iterator.next();
        while (watchedEpisodes.contains(episode)) {
            episode = iterator.next();
        }
        return episode;
    }
}
