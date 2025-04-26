package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ShuffleSeasonIterator implements EpisodeIterator {
    private List<Episode> shuffledEpisodes;
    private int index = 0;

    public ShuffleSeasonIterator(Season season, long seed) {
        this.shuffledEpisodes = new ArrayList<>(season.getEpisodes());
        Collections.shuffle(shuffledEpisodes, new Random(seed));
    }

    @Override
    public boolean hasNext() {
        return index < shuffledEpisodes.size();
    }

    @Override
    public Episode next() {
        if (!hasNext()) throw new IllegalStateException("No more episodes");
        return shuffledEpisodes.get(index++);
    }
}
