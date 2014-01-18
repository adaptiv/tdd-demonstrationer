
package se.tddcourse.pmlib;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * * List of movies.
 */
public class MovieList implements Iterable<Movie> {

    private List<Movie> movies = new ArrayList<Movie>();

    private MovieDao dao;

    public MovieList(MovieDao movieDao) {
        this.dao = movieDao;
    }

    /**
     * Determines the number of movies in the collection.
     *
     * @return number of registered movies
     */
    public int numberOfMovies() {
        return movies.size();
    }

    /**
     * Determines if movie list is empty.
     *
     * @return true if no movies in container, false otherwise
     */
    public boolean isEmpty() {
        return movies.isEmpty();
    }

    /**
     * Adds a new movies to the collection.
     *
     * @param movie a movie
     */
    public void add(Movie movie) {
        if (!dao.exists(movie)) {
            movies.add(movie);
            dao.save(movie);
        }
    }

    /**
     * Iterates over all movies.
     *
     * @return iterator over all movies
     */
    public Iterator<Movie> iterator() {
        return movies.iterator();
    }

    /**
     * Determines if movie is part of the movie list.
     *
     * @param movie movie to examine
     * @return true if movie in list
     */
    public boolean contains(Movie movie) {
        return movies.contains(movie);
    }

}
