package se.pmlib.cmd;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Base class for all commands that may be written to output.
 */
public abstract class Command {

    private static final byte[] HEADER = {(byte) 0xde, (byte) 0xad};
    private static final byte[] FOOTER = {(byte) 0xbe, (byte) 0xef};
    private static final int SIZE_LENGTH = 1;
    private static final int CMD_BYTE_LENGTH = 1;
    private static final int TERMINATOR_CHAR_LENGTH = 1;

    /**
     * Collection of all field values in the command.
     */
    protected List<String> fields = new ArrayList<String>();

    /**
     * Writes command to given output stream.
     *
     * @param outputStream destination stream
     * @throws Exception if write fails
     */
    public void write(OutputStream outputStream) throws Exception {
        writeHeader(outputStream);
        writeBody(outputStream);
        writeFooter(outputStream);
    }

    private void writeHeader(OutputStream outputStream) throws IOException {
        outputStream.write(HEADER);
        outputStream.write(getSize());
        outputStream.write(getCommandChar());
    }
    
    private int getSize() {
        return HEADER.length
             + SIZE_LENGTH
             + CMD_BYTE_LENGTH
             + FOOTER.length
             + getBodySize();
    }
    
    private int getBodySize() {
        int result = 0;
        for (String field : fields) {
            result += getFieldSize(field);
        }
        return result;
    }
    
    private int getFieldSize(String field) {
        return field.getBytes().length + TERMINATOR_CHAR_LENGTH;
    }
    
    /**
     * Character unique of this command. Override for each command.
     *
     * @return command identifier
     */
    protected abstract byte[] getCommandChar();

    private void writeBody(OutputStream outputStream) throws IOException {
        for (String field : fields) {
            writeField(outputStream, field);
        }
    }
    
    private void writeField(OutputStream outputStream, String field) throws IOException {
        outputStream.write(field.getBytes());
        outputStream.write(0x00);
    }    

    private void writeFooter(OutputStream outputStream) throws IOException {
        outputStream.write(FOOTER);
    }
}

