package src;

import java.util.*;

class Season implements Iterable<Episode> {
    private List<Episode> episodes;

    public Season() {
        this.episodes = new ArrayList<>();
    }

    public void addEpisode(Episode e) {
        episodes.add(e);
    }

    @Override
    public Iterator<Episode> iterator() {
        return new SeasonIterator(episodes);  // Возвращаем обычный итератор
    }

    // Методы для получения итераторов по обратному порядку и случайному порядку
    public Iterator<Episode> reverseIterator() {
        return new ReverseSeasonIterator(episodes);
    }

    public Iterator<Episode> shuffleIterator(long seed) {
        return new ShuffleSeasonIterator(episodes, seed);
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }
}
