import multiplication.Alg1;
import multiplication.Alg2;
import org.testng.Assert;

public class MultiplyTest {

    @org.testng.annotations.Test
    public void testMain() {

        String firstBigNumber = "12345678901234567890";
        String secondBigNumber = "11111111111111111111";

        String result1 = Alg1.multiply(firstBigNumber, secondBigNumber);

        String result2 = Alg2.multiply(firstBigNumber, secondBigNumber);

        Assert.assertEquals(result1, result2);
    }
}