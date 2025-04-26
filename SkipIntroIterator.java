package src;


public class SkipIntroIterator implements EpisodeIterator {
    private EpisodeIterator iterator;
    private int skipSeconds;

    public SkipIntroIterator(EpisodeIterator iterator, int skipSeconds) {
        this.iterator = iterator;
        this.skipSeconds = skipSeconds;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Episode next() {
        Episode episode = iterator.next();
        System.out.println("Skipping intro, starting at " + skipSeconds + " seconds in: " + episode.getTitle());
        return episode; // You can enhance this to wrap the episode in a custom view object
    }
}
