package se.tddcourse.legacy.couple;

public class Movie {

	private boolean onLoan;
	
	public Movie(String title) {
	}

	public void lendTo(String borrower) {
		onLoan = true;
	}

	public boolean isOnLoan() {
		return onLoan;
	}
}
