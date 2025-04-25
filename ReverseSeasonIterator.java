package src;

import java.util.Iterator;
import java.util.List;

class ReverseSeasonIterator implements Iterator<Episode> {
    private List<Episode> episodes;
    private int currentIndex;

    public ReverseSeasonIterator(List<Episode> episodes) {
        this.episodes = episodes;
        this.currentIndex = episodes.size() - 1;  // Начинаем с последнего эпизода
    }

    @Override
    public boolean hasNext() {
        return currentIndex >= 0;
    }

    @Override
    public Episode next() {
        return episodes.get(currentIndex--);
    }
}
