package se.tddcourse.pmlib.scenarios;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import se.tddcourse.pmlib.ConsoleListView;
import se.tddcourse.pmlib.MovieList;
import se.tddcourse.pmlib.MovieListController;

public class EmptyMovieLibrarySteps {

	private String result;
	private MovieListController controller;
	private ConsoleListView view;
	private MovieList movieList;

	@Given("att filmbiblioteket är tomt")
	public void createNewCollection() {
        movieList = new MovieList();
		controller = new MovieListController(movieList);
		view = new ConsoleListView();
		controller.setListView(view);
	}
	
	@When("jag listar filmerna")
	public void listMovies() {
		controller.list();
	}
	
	@Then("ser listan av filmer ut så här: \"([^\"]*)\"$")
	public void compareList(String listing) {
		result = view.render();
		assertThat(result, equalTo(listing));
	}

}
