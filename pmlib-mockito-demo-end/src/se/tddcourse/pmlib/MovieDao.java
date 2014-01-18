package se.tddcourse.pmlib;


public interface MovieDao {

    void save(Movie movie);

    boolean exists(Movie movie);

}
