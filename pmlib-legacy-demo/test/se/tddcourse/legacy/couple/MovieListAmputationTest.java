package se.tddcourse.legacy.couple;

import org.junit.Test;
import org.junit.runner.RunWith;

import us.blanshard.stubout.Stubber;
import us.blanshard.stubout.StubbingRunner;

@RunWith(StubbingRunner.class)
public class MovieListAmputationTest {
	
	@StubbingRunner.BeforeReloading
	public static void reload() {
		Stubber.replaceClass(MovieDao.class, MovieDaoStub.class);
	}	
	
	@Test
	public void shouldRecordMovieLoan() {
		MovieList movieList = new MovieList();
		movieList.lend(new Movie("Jaws"), "Nisse");
	}
	
}
