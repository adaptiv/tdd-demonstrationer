package se.tddcourse.pmlib;

import java.util.ArrayList;
import java.util.List;

/**
 * Collection of movies.
 */
public class MovieList {

    private List<String> titles = new ArrayList<String>();

    /**
     * Creates an empty movie collection.
     */
    public MovieList() {}

    MovieList(String title) {
        titles.add(title);
    }

    MovieList(List<String> initial) {
        titles.addAll(initial);
    }

    /**
     * Determines the number of movies in the collection.
     *
     * @return number of registered movies
     */
    public int size() {
        return titles.size();
    }
}
