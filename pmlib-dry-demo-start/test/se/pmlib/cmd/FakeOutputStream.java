package se.pmlib.cmd;

import java.io.IOException;
import java.io.OutputStream;


public class FakeOutputStream extends OutputStream {
    
    byte[] outputCollector;
    int cursor;

    public FakeOutputStream(int bufferSize) {
        this.outputCollector = new byte[bufferSize];
        this.cursor = 0;
    }

    @Override
    public void write(int i) throws IOException {
        outputCollector[cursor++] = (byte) i;
    }

    @Override
    public void write(byte[] barr) throws IOException {
        for (byte b : barr) {
            outputCollector[cursor++] = b;
        }
    }

    byte[] result() {
        return outputCollector;
    }

}
