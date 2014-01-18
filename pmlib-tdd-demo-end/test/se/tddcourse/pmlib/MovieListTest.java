package se.tddcourse.pmlib;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MovieListTest {

    @Test
    public void emptyCollectionHasSizeOfZero() throws Exception {
        MovieList collection = new MovieList();
        assertEquals(0, collection.size());
    }

    @Test
    public void oneItemCollectionHasSizeOfOne() {
        MovieList collection = new MovieList("Alien");
        assertEquals(1, collection.size());
    }

    @Test
    public void smallCollectionHasSizeEqualToNumberOfItems() throws Exception {
        List<String> initial = Arrays.asList(new String[] {"Alien", "Jaws", "Deliverance"});
        MovieList collection = new MovieList(initial);
        assertEquals(3, collection.size());
    }
}
