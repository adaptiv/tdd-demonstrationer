package se.tddcourse.pmlib;

import java.util.ArrayList;
import java.util.List;

public class ConsoleListView {

    private List<String> lines = new ArrayList<String>();

    public String render() {
        StringBuilder builder = new StringBuilder();

        for (String line : lines) {
            builder.append(line);
        }

		return builder.toString();
	}

    public void output(String text) {
        lines.add(text);
    }
}
