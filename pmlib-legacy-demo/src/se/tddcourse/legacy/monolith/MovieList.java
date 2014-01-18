package se.tddcourse.legacy.monolith;

public class MovieList {

	
	public void addMovie(String title) {
		System.out.println("Adding movie...");		
		saveMovie(new Movie(title));
	}
	
	/**
	 * Nasty infrastructure stuff.
	 * @param movie 
	 */
	protected void saveMovie(Movie movie) {
		System.out.println("Talking to the database");
		throw new RuntimeException();
	}
}
