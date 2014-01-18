package se.pmlib.cmd;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class LoginCommandTest {

    private LoginCmd loginCommand;
    
    @Before
    public void setUp() throws Exception {
        this.loginCommand = new LoginCmd("jholm", "pass");
    }

    @Test
    public void testWriteLoginCommand() throws Exception {
        FakeOutputStream outputSpy = new FakeOutputStream(50);
        loginCommand.write(outputSpy);
        
        byte[] expected = buildExpectedLoginCommandOutput();
        assertArrayEquals(expected, outputSpy.result());
    }

    private byte[] buildExpectedLoginCommandOutput() {
        byte[] expected = new byte[50];
        expected[0] = (byte) 0xde;
        expected[1] = (byte) 0xad;
        expected[2] = 17;
        expected[3] = 0x01;
        expected[4] = 106;  // j
        expected[5] = 104;  // h
        expected[6] = 111;  // o
        expected[7] = 108;  // l
        expected[8] = 109;  // m
        expected[9] = 0x00;
        expected[10] = 112; // p
        expected[11] = 97;  // a
        expected[12] = 115; // s
        expected[13] = 115; // s
        expected[14] = 0x00;
        expected[15] = (byte) 0xbe;
        expected[16] = (byte) 0xef;
        return expected;
    }
}
