package se.tddcourse.pmlib;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;


public class MovieListWhenSavingMovie {

    private MovieDao movieDao;
    private final Movie movie = new Movie("Jaws");
    private MovieList movieList;

    @Before
    public void setupMockedMovieList() {
        movieDao = mock(MovieDao.class);
        movieList = new MovieList(movieDao);        
    }
    
    @Test
    public void shouldPersistNewMovie() throws Exception {
        movieList.add(movie);
        verify(movieDao).save(movie);
    }

    @Test
    public void shouldRejectExistingMovie() throws Exception {
        when(movieDao.exists(movie)).thenReturn(true);        
        movieList.add(movie);
        verify(movieDao).exists(movie);
        verifyNoMoreInteractions(movieDao);
    }
}
