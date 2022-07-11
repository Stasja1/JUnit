import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MainTest {
    @Test
    public void TaxEarningsTest() {
        int earning = 1000;
        int spending = 200;
        int expectedResult = 60;
        int result = Main.taxEarnings(1000);
        Assertions.assertEquals(expectedResult, result);
    }
    @Test
    public void taxEarningsMinusSpendingsTest(){
        int earning = 1000;
        int spending = 200;
        int expectedResult = 60;
        int result = Main.taxEarningsMinusSpendings(1000,200);
        Assertions.assertEquals(expectedResult, result);
    }
    @Test
    public void differenceTaxTest(){
        int earning = 1000;
        int spending = 200;
        int expectedResult = 60;
        int result = Main.differenceTax(Main.taxEarnings(1000), Main.taxEarningsMinusSpendings(1000,200));
        Assertions.assertEquals(expectedResult, result);

    }


}

