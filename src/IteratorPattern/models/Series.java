package IteratorPattern.models;

import java.util.ArrayList;

public class Series {
    public String seriesTittle;
    public ArrayList<Season> seriesSeason;

    public Series(String title) {
        this.seriesTittle = title;
        seriesSeason = new ArrayList<>();
    }
    public void addSeason(Season s){
        seriesSeason.add(s);
    }
}
