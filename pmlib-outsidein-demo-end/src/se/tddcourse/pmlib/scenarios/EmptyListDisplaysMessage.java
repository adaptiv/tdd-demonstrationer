package se.tddcourse.pmlib.scenarios;

import org.jbehave.scenario.Scenario;

import se.tddcourse.pmlib.scenarios.steps.MovieCollectionSteps;

public class EmptyListDisplaysMessage extends Scenario {

	public EmptyListDisplaysMessage() {
		super(new MovieCollectionSteps());
	}
}
