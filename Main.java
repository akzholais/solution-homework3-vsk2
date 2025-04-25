package src;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Создаем эпизоды
        Episode e1 = new Episode("src.Episode 1", 30);
        Episode e2 = new Episode("src.Episode 2", 45);
        Episode e3 = new Episode("src.Episode 3", 60);
        Episode e4 = new Episode("src.Episode 4", 50);
        Episode e5 = new Episode("src.Episode 5", 40);

        // Создаем сезоны и добавляем эпизоды
        Season season1 = new Season();
        season1.addEpisode(e1);
        season1.addEpisode(e2);

        Season season2 = new Season();
        season2.addEpisode(e3);
        season2.addEpisode(e4);

        Season season3 = new Season();
        season3.addEpisode(e5);

        // Составляем список сезонов
        List<Season> seasons = new ArrayList<>();
        seasons.add(season1);
        seasons.add(season2);
        seasons.add(season3);

        // Создаем src.BingeIterator
        BingeIterator bingeIterator = new BingeIterator(seasons);

        // Пропуск вступления, используя src.SkipIntroIterator
        SkipIntroIterator skipIntroIterator = new SkipIntroIterator(bingeIterator, 10);

        // История просмотров с динамическим изменением состояния
        Set<Episode> watchedEpisodes = new HashSet<>();
        watchedEpisodes.add(e1);  // Эпизод 1 уже просмотрен

        // Игнорируем повторный просмотр, пока эпизод не будет помечен как непросмотренный
        System.out.println("Simulating binge watch:");
        while (skipIntroIterator.hasNext()) {
            EpisodeView episodeView = skipIntroIterator.next();
            episodeView.play();

            // Случайно меняем состояние эпизодов
            if (Math.random() > 0.5) {
                watchedEpisodes.add(episodeView.getEpisode());
                System.out.println("You have watched: " + episodeView.getEpisode().getTitle());
            }
        }

        // Даем пользователю возможность "пересматривать" эпизоды случайным образом
        System.out.println("\nSome episodes will be marked as unwatched and revisited...");
        Set<Episode> revisitEpisodes = new HashSet<>();
        for (Episode episode : watchedEpisodes) {
            if (Math.random() > 0.3) {
                // Помечаем случайные эпизоды как непросмотренные
                revisitEpisodes.add(episode);
                System.out.println("src.Episode " + episode.getTitle() + " is now marked as unwatched!");
            }
        }

        // Применяем фильтр истории просмотра для непросмотренных эпизодов
        WatchHistoryFilter watchHistoryFilter = new WatchHistoryFilter(bingeIterator, revisitEpisodes);
        System.out.println("\nUnwatched Episodes (to revisit):");
        while (watchHistoryFilter.hasNext()) {
            Episode episode = watchHistoryFilter.next();
            System.out.println("Rewatch: " + episode.getTitle());
        }

        // Завершаем процесс
        System.out.println("\nBinge Watch Complete!");
    }
}
