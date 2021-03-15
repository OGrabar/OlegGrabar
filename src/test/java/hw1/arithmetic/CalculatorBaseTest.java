package hw1.arithmetic;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CalculatorBaseTest {

    protected Calculator calculator;
    protected static final double DOUBLE_DELTA = 1e-6;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }
}
