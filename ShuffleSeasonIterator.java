package src;

import java.util.*;

class ShuffleSeasonIterator implements Iterator<Episode> {
    private List<Episode> episodes;
    private List<Episode> shuffledEpisodes;
    private int currentIndex;

    public ShuffleSeasonIterator(List<Episode> episodes, long seed) {
        this.episodes = new ArrayList<>(episodes);
        this.shuffledEpisodes = new ArrayList<>(episodes);
        Collections.shuffle(this.shuffledEpisodes, new Random(seed));  // Перемешиваем с фиксированным seed
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < shuffledEpisodes.size();
    }

    @Override
    public Episode next() {
        return shuffledEpisodes.get(currentIndex++);
    }
}
