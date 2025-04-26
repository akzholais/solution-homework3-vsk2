package src;


import java.util.Iterator;

public interface EpisodeIterator extends Iterator<Episode> {
    boolean hasNext();
    Episode next();

    @Override
    default void remove() {
        Iterator.super.remove();
    }
}
