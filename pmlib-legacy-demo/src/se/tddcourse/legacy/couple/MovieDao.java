package se.tddcourse.legacy.couple;

public class MovieDao {

	public void save(Movie movie) {
		System.out.println("Saving the movie...");
		problematic();
		harmless();
	}
	
	private void harmless() {
		System.out.println("This is the real but harmless procedure...");
	}

	private void problematic() {
		System.out.println("This is the real and problematic procedure...");
		throw new RuntimeException();
	}
	
}
