package IteratorPattern.iterators;

import IteratorPattern.models.Episode;
import IteratorPattern.models.Season;

import java.util.ArrayList;
import java.util.List;

public class SeasonIterator implements EpisodeIterator {
    private ArrayList<Episode> episodes;
    private int index = 0;
    public SeasonIterator(Season season) {
        this.episodes = season.getSeasonEpisodes();
    }

    @Override
    public boolean hasNext() {
        return index < episodes.size();
    }

    @Override
    public Episode next() {
        return episodes.get(index++);
    }
}
