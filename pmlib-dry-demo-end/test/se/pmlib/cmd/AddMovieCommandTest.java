package se.pmlib.cmd;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class AddMovieCommandTest {

    private AddMovieCommand addCommand;
    
    @Before
    public void setUp() throws Exception {
        this.addCommand = new AddMovieCommand("12 Monkeys", "Terry Gilliam", 123, "PG");
    }

    @Test
    public void testWriteAddMovieCommand() throws Exception {
        FakeOutputStream outputSpy = new FakeOutputStream(50);
        addCommand.write(outputSpy);

        byte[] expected = buildExpectedAddCommandOutput();
        assertArrayEquals(expected, outputSpy.result());
    }

    private byte[] buildExpectedAddCommandOutput() {
        byte[] expected = new byte[50];
        expected[0] = (byte) 0xde;
        expected[1] = (byte) 0xad;
        expected[2] = 38;
        expected[3] = 0x02;
        expected[4] = 49;   // 1
        expected[5] = 50;   // 2
        expected[6] = 32;   // 
        expected[7] = 77;   // M
        expected[8] = 111;  // o
        expected[9] = 110;  // n
        expected[10] = 107; // k
        expected[11] = 101; // e
        expected[12] = 121; // y
        expected[13] = 115; // s
        expected[14] = 0x00;
        expected[15] = 84;  // T
        expected[16] = 101; // e
        expected[17] = 114; // r
        expected[18] = 114; // r
        expected[19] = 121; // y
        expected[20] = 32;  //
        expected[21] = 71;  // G
        expected[22] = 105; // i
        expected[23] = 108; // l
        expected[24] = 108; // l
        expected[25] = 105; // i
        expected[26] = 97;  // a
        expected[27] = 109; // m
        expected[28] = 0x00;
        expected[29] = 49;  // 1
        expected[30] = 50;  // 2
        expected[31] = 51;  // 3
        expected[32] = 0x00;
        expected[33] = 80;  // P
        expected[34] = 71;  // G
        expected[35] = 0x00;
        expected[36] = (byte) 0xbe;
        expected[37] = (byte) 0xef;
        return expected;
    }

}
