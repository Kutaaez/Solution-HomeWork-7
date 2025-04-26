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
}
