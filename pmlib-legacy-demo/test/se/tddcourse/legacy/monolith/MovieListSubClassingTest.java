package se.tddcourse.legacy.monolith;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class MovieListSubClassingTest {

	@Test
	public void shouldSaveAddedMovie() {
		MovieListOverride movieList = new MovieListOverride();
		movieList.addMovie("Jaws");
		assertTrue(movieList.movieIsSaved);
	}
	
	private class MovieListOverride extends MovieList {
		private boolean movieIsSaved = false;
		@Override
		protected void saveMovie(Movie movie) {
			System.out.println("Avoided infrastructure calls.");
			movieIsSaved = true;
		}
	}
}
