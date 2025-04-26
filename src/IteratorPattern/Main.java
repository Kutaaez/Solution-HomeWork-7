package IteratorPattern;

import IteratorPattern.iterators.*;
import IteratorPattern.models.Episode;
import IteratorPattern.models.Season;
import IteratorPattern.models.Series;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Episode bbEpisode1 = new Episode("Pilot", 3000);
        Episode bbEpisode2 = new Episode("?TEART", 2500);
        Episode bbEpisode3 = new Episode("TREAT?", 3200);
        Episode bbEpisode4 = new Episode("Finale", 3200);

        Season bbSeason1 = new Season(1);
        bbSeason1.addEpisode(bbEpisode1);
        bbSeason1.addEpisode(bbEpisode2);

        Season bbSeason2 = new Season(2);
        bbSeason1.addEpisode(bbEpisode3);
        bbSeason1.addEpisode(bbEpisode4);

        Series BreakingBad = new Series("Breaking bad");
        BreakingBad.addSeason(bbSeason1);
        BreakingBad.addSeason(bbSeason2);


        //normalnyy poryadok
        System.out.println("Normal order:");
        EpisodeIterator seasonIterator = new SeasonIterator(bbSeason1);
        for (Episode e : bbSeason1) {
            System.out.print(seasonIterator.next().getTitle());
        }

        //reversyvnyy poryadok
        System.out.println("\nReverse order:");
        EpisodeIterator reverseIterator = new ReverseSeasonIterator(bbSeason1);
        while (reverseIterator.hasNext()) {
            System.out.println(reverseIterator.next().getTitle());
        }
        //razmezhanyy poryadon
        System.out.println("\nShuffle order:");
        EpisodeIterator shuffleIterator = new ShuffleSeasonIterator(bbSeason2);
        while (shuffleIterator.hasNext()) {
            System.out.println(shuffleIterator.next().getTitle());
        }

        //vse sezony poryadok
        System.out.println("\nBinge mode:");
        BingeIterator bingeIterator = new BingeIterator(BreakingBad.getSeriesSeason());
        while (bingeIterator.hasNext()) {
            System.out.println(bingeIterator.next().getTitle());
        }

    }
    }
