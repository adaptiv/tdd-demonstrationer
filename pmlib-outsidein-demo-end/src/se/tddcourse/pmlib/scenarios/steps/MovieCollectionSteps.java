package se.tddcourse.pmlib.scenarios.steps;

import static org.hamcrest.CoreMatchers.*;
import static org.jbehave.util.JUnit4Ensure.*;

import org.jbehave.scenario.annotations.Given;
import org.jbehave.scenario.annotations.Then;
import org.jbehave.scenario.annotations.When;
import org.jbehave.scenario.steps.Steps;

import se.tddcourse.pmlib.ConsoleListView;
import se.tddcourse.pmlib.MovieListController;

public class MovieCollectionSteps extends Steps {

		
	private String result;
	private MovieListController controller;
	private ConsoleListView view;
	private MovieList movieList;

	@Given("the collection is empty")
	public void createNewCollection() {
		controller = new MovieListController(movieList);
		view = new ConsoleListView();
		controller.setListView(view);
	}
	
	@When("I list the movies")
	public void listMovies() {
		controller.list();
	}
	
	@Then("the list of movies should look like: \"$listing\"")
	public void compareList(String listing) {
		result = view.render();
		ensureThat(result, equalTo(listing));
	}


}
