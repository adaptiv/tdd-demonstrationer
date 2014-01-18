package se.pmlib.cmd;

import java.io.OutputStream;

public class AddMovieCmd {

    private String title;
    private String director;
    private String minutes;
    private String rating;

    private static final byte[] header = {(byte) 0xde, (byte) 0xad};
    private static final byte[] commandChar = {0x02};
    private static final byte[] footer = {(byte) 0xbe, (byte) 0xef};
    private static final int SIZE_LENGTH = 1;
    private static final int CMD_BYTE_LENGTH = 1;
    
    private int getSize() {
        return header.length +
        SIZE_LENGTH + 
        CMD_BYTE_LENGTH +
        footer.length + 
        title.getBytes().length + 1 +
        director.getBytes().length + 1 +
        minutes.getBytes().length + 1 +
        rating.getBytes().length + 1;
    }

    public AddMovieCmd(String title, String director, int minutes, String rating) {
        this.title = title;
        this.director = director;
        this.minutes = Integer.toString(minutes);
        this.rating = rating;
    }
    
    public void write(OutputStream outputStream) throws Exception {
        outputStream.write(header);
        outputStream.write(getSize());
        outputStream.write(commandChar);
        outputStream.write(title.getBytes());
        outputStream.write(0x00);
        outputStream.write(director.getBytes());
        outputStream.write(0x00);
        outputStream.write(minutes.getBytes());
        outputStream.write(0x00);
        outputStream.write(rating.getBytes());
        outputStream.write(0x00);
        outputStream.write(footer);
    }
}
