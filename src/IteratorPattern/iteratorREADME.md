***Streaming-Service Iterator Mode***

  This project implements the Iterator pattern for a system for playing episodes in a KINOPOISK streaming service. 
  Using the Iterator pattern, the application provides a unified way to iterate through episodes in a series, 
  hiding the internal implementation details of collections and supporting different traversal modes (normal, reverse, random).
  
**Project structure**

  we have three module

 - class Episode have  (String title, int runtimeSec);
 - class Season  have (List of seasonEpisodes, int seasonNumber and method addEpisodes);
 - class Series  have (List of seriesSeasons, String tittle and method addSeason);

  all classes have getters and setters.

  so a *series* has *seasons*, a *season* has *episodes*.

 - *EpisodeIterator* – interface for defining the behavior of iterators for traversing episodes.

 - *SeasonIterator* – iterator for traversing normal position

 - *ReverseSeasonIterator* – iterator for traversing reverse  position.

 - *ShuffleSeasonIterator* – iterator for traversing shuffle position with fixed seed (is 45)


 - *BingeIterator* –  iterator for traversin all season and series without pauses.

**Tasks and functionality**
1. EpisodeIterator is an interface with hasNext() and next() methods.
2. Implementation of three iterators:
   - SeasonIterator - an iterator for traversing episodes in normal order.
   - ReverseSeasonIterator - an iterator for traversing episodes in reverse order.
   - ShuffleSeasonIterator - an iterator for randomly traversing episodes.
3. Season implements the Iterable<Episode> interface to support use in a for-each loop.
4. BingeIterator - An iterator for browsing all seasons in a row (first season 1, then season 2, and so on).


***Why Iterator is preferable to just exposing List<Episode>***
 -  Iterator supports different ways of traversing a collection, such as normal, reverse, and random, without requiring modification of the data structure. (in out case we use normal,reverse and shuffle.)
 -  Iterator allows you to easily change the order in which a collection is traversed without changing the code that uses the collection.
 -  Decouples traversal logic from collection, cleaner, standardized way to loop over items.

**Additional features (optional)**
 - Tested 100.000 episode series in class PerfomanceTest.
 - soon...

 - 
