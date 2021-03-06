import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class NoFlagDriverTest {

    private static PrintStream stdOut = null;

    @BeforeClass
    public static void redirect() {
         stdOut = System.out;
    }

    @AfterClass
    public static void restore() {
        System.setOut(stdOut);
    }

    @Test
    public void testOutput() throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream, true, "UTF-8"));
        Driver.main();
        assertEquals(String.format("Event 'THE EVENT' create for the host 'HOSTNAME'%n"), outputStream.toString("UTF-8"));
    }

}
