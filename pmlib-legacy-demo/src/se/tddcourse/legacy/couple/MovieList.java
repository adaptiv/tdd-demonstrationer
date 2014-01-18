package se.tddcourse.legacy.couple;

public class MovieList {

	MovieDao dao = new MovieDao();
	
	public void lend(Movie movie, String borrower) {
		movie.lendTo(borrower);
		dao.save(movie);
	}
}
