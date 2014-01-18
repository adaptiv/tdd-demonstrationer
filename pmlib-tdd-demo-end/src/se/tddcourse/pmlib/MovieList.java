package se.tddcourse.pmlib;

import java.util.ArrayList;
import java.util.List;

/**
 * Collection of movies.
 */
public class MovieList {

    private List<String> titles = new ArrayList<String>();

    /**
     * Determines the number of movies in the collection.
     *
     * @return number of registered movies
     */
    public int size() {
        return titles.size();
    }

    /**
     * Adds a movie title to library of titles.
     * 
     * @param title movie title to add
     */
    public void add(String title) {
        titles.add(title);
    }

}
