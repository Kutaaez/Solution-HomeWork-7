package IteratorPattern;

import IteratorPattern.iterators.EpisodeIterator;
import IteratorPattern.iterators.ReverseSeasonIterator;
import IteratorPattern.iterators.SeasonIterator;
import IteratorPattern.iterators.ShuffleSeasonIterator;
import IteratorPattern.models.Season;
import IteratorPattern.models.Series;
import IteratorPattern.models.Episode;

public class PerfomanceTest {
    public static void main(String[] args) {
        //creating series.
        Series onePiece = new Series("One Piece");
        Season season = new Season(1);
        for (int i = 1; i <= 100000; i++) {
            season.addEpisode(new Episode("One Piece Episode " + i, 24 * 60)); // 24 минуты
        }
        onePiece.addSeason(season);

        //let's go to perfomance iterators!!!
        System.out.println("Performance Test for 10,000 Episodes:");
        System.out.println("--------------------------------------");
        SeasonIterator normalIterator = new SeasonIterator(season);
        ReverseSeasonIterator reverseIterator = new ReverseSeasonIterator(season);
        ShuffleSeasonIterator shuffleIterator = new ShuffleSeasonIterator(season);

        testIterator("Normal Order", normalIterator);
        testIterator("Reverse Order", reverseIterator);
        testIterator("Shuffle Order", shuffleIterator);
    }

    public static void testIterator(String modeName, EpisodeIterator iterator) {
        long start = System.currentTimeMillis();

        int count = 0;
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }

        long end = System.currentTimeMillis();
        long duration = end - start;

        printBar(modeName, duration);
    }

    private static void printBar(String name, long ms) {
        System.out.printf("%s: %4d ms ", name, ms);

        int bars = (int) ms / 5;
        for (int i = 0; i < bars; i++) {
            System.out.print("|");
        }
        System.out.println();
    }

}
