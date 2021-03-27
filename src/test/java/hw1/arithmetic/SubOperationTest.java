package hw1.arithmetic;

import hw1.CalculatorBaseTest;
import hw1.data_providers.ArithmeticDataProviders;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubOperationTest extends CalculatorBaseTest {

    @Test(dataProvider = "longValuesForSumOrSub", dataProviderClass = ArithmeticDataProviders.class)
    public void sumLongValuesTest(long first, long second) {
        long actual = calculator.sub(first, second);
        long expected = first - second;
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "doubleValuesForSumOrSub", dataProviderClass = ArithmeticDataProviders.class)
    public void sumDoubleValuesTest(double first, double second) {
        double actual = calculator.sub(first, second);
        double expected = first - second;
        assertEquals(actual, expected, DOUBLE_DELTA);
    }
}
