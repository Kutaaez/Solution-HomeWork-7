package IteratorPattern.iterators;

import IteratorPattern.models.Episode;
import IteratorPattern.models.Season;

import java.util.List;

public class ReverseSeasonIterator implements EpisodeIterator {
    private List<Episode> episodes;
    private int index ;
    public ReverseSeasonIterator(Season season) {
        this.episodes = season.getSeasonEpisodes();
        this.index = episodes.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    @Override
    public Object next() {
        return episodes.get(index--);
    }
}
