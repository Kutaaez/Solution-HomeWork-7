package IteratorPattern.models;

import java.util.ArrayList;

public class Season {
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
}
