package IteratorPattern.models;

public class Episode {
    public String title;
    public int runtimeSec;
    public Episode(String title, int runtimeSec) {
        this.title = title;
        this.runtimeSec = runtimeSec;
    }


    public String getTitle() {
        return title;
    }

    public int getRuntimeSec() {
        return runtimeSec;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRuntimeSec(int runtimeSec) {
        this.runtimeSec = runtimeSec;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "title='" + title + '\'' +
                ", runtimeSec=" + runtimeSec +
                '}';
    }
}
