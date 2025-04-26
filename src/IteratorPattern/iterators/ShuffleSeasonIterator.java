package IteratorPattern.iterators;

import IteratorPattern.models.Episode;
import IteratorPattern.models.Season;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ShuffleSeasonIterator implements  EpisodeIterator {
    private List<Episode> shuffledEpisodes;
    private int position = 0;
    public ShuffleSeasonIterator(Season season) {
        this.shuffledEpisodes = new ArrayList<>(season.getSeasonEpisodes());
        Collections.shuffle(shuffledEpisodes, new Random(45));
    }

    @Override
    public boolean hasNext() {
        return position < shuffledEpisodes.size();
    }

    @Override
    public Episode next() {
        return shuffledEpisodes.get(position++);
    }
}
