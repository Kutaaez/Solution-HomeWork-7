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

    public String getSeriesTittle() {
        return seriesTittle;
    }

    public void setSeriesTittle(String seriesTittle) {
        this.seriesTittle = seriesTittle;
    }

    public ArrayList<Season> getSeriesSeason() {
        return seriesSeason;
    }

    @Override
    public String toString() {
        return "Series{" +
                "seriesTittle='" + seriesTittle + '\'' +
                ", seriesSeason=" + seriesSeason +
                '}';
    }
}
