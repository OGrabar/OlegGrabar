package hw1.arithmetic;

import hw1.data_providers.ArithmeticDataProviders;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultOperationTest extends CalculatorBaseTest {

    @Test(dataProvider = "longValuesForMult", dataProviderClass = ArithmeticDataProviders.class)
    public void multLongValuesTest(long first, long second) {
        long actual = calculator.mult(first, second);
        long expected = first * second;
        assertEquals(actual, expected);
    }

    @Test(
            dataProvider = "doubleValuesForMult", dataProviderClass = ArithmeticDataProviders.class,
            groups = "failed"
    )
    public void multDoubleValuesTest(double first, double second) {
        double actual = calculator.mult(first, second);
        double expected = first * second;
        assertEquals(actual, expected, DOUBLE_DELTA);
    }
}
