Part 1 – Iterator Pattern
“Streaming‑Service Binge Mode”


Problem setting
You’re building the episode player for a tiny Netflix‑like platform. A TV series contains 
several seasons; each season stores its episodes in its own way (an ArrayList, a LinkedList, 
or even a lazy file loader). The UI team needs a uniform iterator so it can loop through 
episodes without caring how they’re stored.

Learning goals
Hide collection internals and expose hasNext() / next() only.
Support multiple traversal orders (normal, reverse, shuffle).
Experience external vs. internal iterators (using Java’s Iterable).

Starter code (skeleton)
    class Episode { String title; int runtimeSec; /* getters… */ }
    class Season   { void addEpisode(Episode e); /* storage of your choice */ }
    class Series   { void addSeason(Season s); }

Tasks
    1.Define an interface EpisodeIterator with boolean hasNext() and Episode next().
2.Implement three concrete iterators for a single season:
    SeasonIterator – normal order.
    ReverseSeasonIterator – reverse order.
    ShuffleSeasonIterator – random order but with a fixed seed so results are repeatable.

3.Make Season implement Iterable<Episode> by returning the normal iterator; 
  this lets clients write for (Episode e : season) { … }.
4.Create BingeIterator that chains seasons together so the user can watch from 
  Season 1 Episode 1 straight through to the series finale without manual jumps.

Engagement extras (optional)
 * Implement a “Skip Intro” wrapper iterator that starts each episode at n seconds and 
   yields an EpisodeView object with play() starting at the right offset.

 * Implement a watch‑history filter that wraps another iterator and yields 
   only unseen episodes. (Demonstrates Decorator + Iterator.)

Deliverables
 * Source code for all classes and iterators.
 * Main demo that prints episode titles in each traversal mode.
 * A short README explaining why Iterator is preferable to simply exposing List<Episode>.

Stretch goal for honors credit 
 * Generate 10 000 fake episodes, time each iterator type, 
   and print a mini performance report (ASCII bar chart or numbers).

Suggested flow
 * Correct iterator interface and normal traversal
 * Reverse and shuffle iterators work
 * Season is Iterable and works with for‑each
 * Clean code with comments / Javadoc
 * README insight

 