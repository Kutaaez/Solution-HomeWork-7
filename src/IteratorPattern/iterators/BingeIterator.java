package IteratorPattern.iterators;

import IteratorPattern.models.Episode;
import IteratorPattern.models.Season;

import java.util.Iterator;
import java.util.List;
//why we need this?
//for binge all season from series .. it's 4 task.

public class BingeIterator implements EpisodeIterator {
    private Iterator<Episode> currentSeasonIterator;
    private List<Season> seasons;
    private int currentSeasonIndex = 0;


    public BingeIterator(List<Season> seasons) {
        this.seasons = seasons;
        moveToNextSeasonIterator();
    }

    private void moveToNextSeasonIterator() {
        if (currentSeasonIndex < seasons.size()) {
            Season currentSeason = seasons.get(currentSeasonIndex);
            currentSeasonIterator = currentSeason.iterator();
        }
    }

    @Override
    public boolean hasNext() {
        if (currentSeasonIterator != null && currentSeasonIterator.hasNext()) {
            return true;
        }
        if (currentSeasonIndex < seasons.size() - 1) {
            currentSeasonIndex++;
            moveToNextSeasonIterator();
            return hasNext();
        }
        return false;
    }

    @Override
    public Episode next() {
        if (hasNext()) {
            return currentSeasonIterator.next();
        }
        return null;  // Return null if there's no next element
    }
}
