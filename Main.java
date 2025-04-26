package src;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Season season1 = new Season();
        season1.addEpisode(new Episode("Episode 1", 3600));
        season1.addEpisode(new Episode("Episode 2", 3500));
        season1.addEpisode(new Episode("Episode 3", 3700));

        Season season2 = new Season();
        season2.addEpisode(new Episode("Episode 1", 3600));
        season2.addEpisode(new Episode("Episode 2", 3500));

        List<Season> seasons = new ArrayList<>();
        seasons.add(season1);
        seasons.add(season2);

        // Binge Iterator Demo
        EpisodeIterator bingeIterator = new BingeIterator(seasons);
        while (bingeIterator.hasNext()) {
            Episode episode = bingeIterator.next();
            System.out.println("Watching: " + episode.getTitle());
        }

        // Reverse Iterator Demo
        EpisodeIterator reverseIterator = new ReverseSeasonIterator(season1);
        while (reverseIterator.hasNext()) {
            Episode episode = reverseIterator.next();
            System.out.println("Reverse watching: " + episode.getTitle());
        }

        // Shuffle Iterator Demo
        EpisodeIterator shuffleIterator = new ShuffleSeasonIterator(season1, 123);
        while (shuffleIterator.hasNext()) {
            Episode episode = shuffleIterator.next();
            System.out.println("Shuffle watching: " + episode.getTitle());
        }

        // Skip Intro Iterator Demo
        EpisodeIterator skipIntroIterator = new SkipIntroIterator(bingeIterator, 30);
        while (skipIntroIterator.hasNext()) {
            Episode episode = skipIntroIterator.next();
            System.out.println("Watching with skip intro: " + episode.getTitle());
        }
    }
}
