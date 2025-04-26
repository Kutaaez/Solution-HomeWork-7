package IteratorPattern.models;

import java.util.ArrayList;

public class Season {
    public ArrayList<Episode> season;

    public  void addEpisode(Episode e){
        season.add(e);
    }
}
