package IteratorPattern.models;

import IteratorPattern.iterators.EpisodeIterator;
import IteratorPattern.iterators.SeasonIterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Season implements Iterable<Episode> {
    public int seasonNumber;
    public ArrayList<Episode> seasonEpisodes;

    public Season(int seasonNumber) {
        this.seasonNumber = seasonNumber;
        seasonEpisodes = new ArrayList<>();
    }

    public  void addEpisode(Episode e){
        seasonEpisodes.add(e);
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public ArrayList<Episode> getSeasonEpisodes() {
        return seasonEpisodes;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonNumber=" + seasonNumber +
                ", seasonEpisodes=" + seasonEpisodes +
                '}';
    }

    @Override
    public Iterator<Episode> iterator() {
        return new SeasonIterator(this);
    }

    public EpisodeIterator createSeasonIterator() {
        return new SeasonIterator(this);
    }
}
