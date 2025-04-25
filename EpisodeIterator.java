package src;

import java.util.Iterator;

interface EpisodeIterator extends Iterator<Episode> {
    boolean hasNext();
    Episode next();
}
    