package src;

public class SeasonIterator implements EpisodeIterator {
    private Season season;
    private int index = 0;

    public SeasonIterator(Season season) {
        this.season = season;
    }

    @Override
    public boolean hasNext() {
        return index < season.getEpisodes().size();
    }

    @Override
    public Episode next() {
        if (!hasNext()) throw new IllegalStateException("No more episodes");
        return season.getEpisodes().get(index++);
    }
}
