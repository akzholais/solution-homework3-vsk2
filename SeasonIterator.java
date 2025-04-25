package src;

import java.util.Iterator;
import java.util.List;

class SeasonIterator implements Iterator<Episode> {
    private List<Episode> episodes;
    private int currentIndex;

    public SeasonIterator(List<Episode> episodes) {
        this.episodes = episodes;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < episodes.size();
    }

    @Override
    public Episode next() {
        return episodes.get(currentIndex++);
    }
}
