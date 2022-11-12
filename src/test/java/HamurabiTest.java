import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.Assert.*;

public class HamurabiTest {

    Hamurabi hamurabi = new Hamurabi();

    @Test
    public void someTestTest() {
        String expected = "this is a test";
        String actual = hamurabi.someTest();

        Assert.assertEquals(expected, actual);
    }
}
