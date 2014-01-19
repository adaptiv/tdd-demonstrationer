package se.tddcourse.pmlib;

import se.tddcourse.pmlib.scenarios.steps.MovieList;

public class MovieListController {

    private MovieList movieList;
    private ConsoleListView view;

    public MovieListController(MovieList movieList) {
        this.movieList = movieList;
    }

	public void list() {
		if (movieList.isEmpty()) {
            view.output("Your collection is empty.");
        }
	}

	public void setListView(ConsoleListView view) {
        this.view = view;
    }

}
