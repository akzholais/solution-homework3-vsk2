package src;

import java.util.Iterator;

class SkipIntroIterator implements Iterator<EpisodeView> {
    private Iterator<Episode> iterator;
    private int skipSeconds;

    public SkipIntroIterator(Iterator<Episode> iterator, int skipSeconds) {
        this.iterator = iterator;
        this.skipSeconds = skipSeconds;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public EpisodeView next() {
        Episode episode = iterator.next();
        return new EpisodeView(episode, skipSeconds);
    }
}
