package se.pmlib.cmd;

/**
 * Represents command to add movie to the library.
 * 
 * @see Command
 */
public class AddMovieCommand extends Command {

    /**
     * Creates command with field values.
     *
     * @param title movie title
     * @param director name of director
     * @param minutes length of movie
     * @param rating U.S. movie rating 
     */
    public AddMovieCommand(String title, String director, int minutes, String rating) {
        fields.add(title);
        fields.add(director);
        fields.add(Integer.toString(minutes));
        fields.add(rating);
    }
    
    protected byte[] getCommandChar() {
        return new byte[] {0x02};
    }

}
