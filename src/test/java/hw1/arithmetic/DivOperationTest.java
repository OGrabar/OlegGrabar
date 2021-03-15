package hw1.arithmetic;

import hw1.data_providers.ArithmeticDataProviders;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class DivOperationTest extends CalculatorBaseTest {

    @Test
    public void divByZeroForLongValuesTest() {
        assertThrows(() -> calculator.div(1, 0));
    }

    @Test(groups = "failed")
    public void divByZeroForDoubleValuesTest() {
        assertThrows(() -> calculator.div(1d, 0));
    }

    @Test(dataProvider = "longValuesForDiv", dataProviderClass = ArithmeticDataProviders.class)
    public void divLongValuesTest(long first, long second) {
        long actual = calculator.div(first, second);
        long expected = first / second;
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "doubleValuesForDiv", dataProviderClass = ArithmeticDataProviders.class)
    public void divDoubleValuesTest(double first, double second) {
        double actual = calculator.div(first, second);
        double expected = first / second;
        assertEquals(actual, expected);
    }


}
