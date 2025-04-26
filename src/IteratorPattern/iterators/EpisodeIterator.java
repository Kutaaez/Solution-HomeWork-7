package IteratorPattern.iterators;

import IteratorPattern.models.Episode;

public interface EpisodeIterator {
    boolean hasNext();
    Episode next();
}
