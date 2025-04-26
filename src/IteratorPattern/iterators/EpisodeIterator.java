package IteratorPattern.iterators;

public interface EpisodeIterator<T> {
    boolean hasNext();
    T next();
}
