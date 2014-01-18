package se.pmlib.cmd;

/**
 * Represents command to login with user name and password.
 * 
 * @see Command
 */
public class LoginCommand extends Command {

    /**
     * Creates command with field values.
     *
     * @param user user name
     * @param passwd password
     */
    public LoginCommand(String user, String passwd) {
        fields.add(user);
        fields.add(passwd);
    }
    
    protected byte[] getCommandChar() {
        return new byte[] {0x01};
    }
}
