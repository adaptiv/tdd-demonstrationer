package se.tddcourse.pmlib;

public class MovieListController {

    private MovieList movieList;
    private ConsoleListView view;

    public MovieListController(MovieList movieList) {
        this.movieList = movieList;
    }

	public void list() {
	}

	public void setListView(ConsoleListView view) {
        this.view = view;
    }

}
