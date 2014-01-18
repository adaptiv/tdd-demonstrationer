package se.tddcourse.pmlib;

import static org.junit.Assert.*;

import org.junit.Test;

public class MovieListTest {

    @Test
    public void emptyCollectionShouldHaveSizeZero() throws Exception {
        MovieList library = new MovieList();
        assertEquals(0, library.size());
    }

    @Test
    public void smallCollectionShouldCountNumberOfMovies() throws Exception {
        MovieList library = new MovieList();
        library.add("Alien");
        library.add("Jaws");
        library.add("Deliverance");
        assertEquals(3, library.size());
    }
}
