package se.tddcourse.legacy.couple;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import us.blanshard.stubout.Stubber;
import us.blanshard.stubout.StubbingRunner;

@RunWith(StubbingRunner.class)
public class MovieListSurgicalTest {

	@Test
	public void shouldRecordLoan() {
		Stubber.replaceMethods(MovieDao.class, new Object() {
			@SuppressWarnings("unused")
			private void problematic() {
				System.out.println("This is the replaced method...");
			}
		});
		MovieList movieList = new MovieList();
		Movie jawsMovie = new Movie("Jaws");
		movieList.lend(jawsMovie, "Kalle");
		assertTrue(jawsMovie.isOnLoan());
	}
	
}
