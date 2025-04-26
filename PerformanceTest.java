package src;

import java.util.ArrayList;
import java.util.List;

public class PerformanceTest {
    public static void main(String[] args) {
        List<Episode> fakeEpisodes = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            fakeEpisodes.add(new Episode("Episode " + i, 3600));
        }

        // Normal Iterator
        long startTime = System.nanoTime();
        EpisodeIterator normalIterator = new SeasonIterator(new Season() {{
            fakeEpisodes.forEach(this::addEpisode);
        }});
        while (normalIterator.hasNext()) normalIterator.next();
        long duration = System.nanoTime() - startTime;
        System.out.println("Normal Iterator Duration: " + duration + " ns");

        // Reverse Iterator
        startTime = System.nanoTime();
        EpisodeIterator reverseIterator = new ReverseSeasonIterator(new Season() {{
            fakeEpisodes.forEach(this::addEpisode);
        }});
        while (reverseIterator.hasNext()) reverseIterator.next();
        duration = System.nanoTime() - startTime;
        System.out.println("Reverse Iterator Duration: " + duration + " ns");

        // Shuffle Iterator
        startTime = System.nanoTime();
        EpisodeIterator shuffleIterator = new ShuffleSeasonIterator(new Season() {{
            fakeEpisodes.forEach(this::addEpisode);
        }}, 123);  // Using a fixed seed for repeatability
        while (shuffleIterator.hasNext()) shuffleIterator.next();
        duration = System.nanoTime() - startTime;
        System.out.println("Shuffle Iterator Duration: " + duration + " ns");
    }
}
