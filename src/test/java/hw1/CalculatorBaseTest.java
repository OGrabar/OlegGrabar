package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CalculatorBaseTest {

    protected Calculator calculator;
    protected static final double DOUBLE_DELTA = 1e-6;

    @BeforeSuite
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterSuite
    public void tearDown() {
        calculator = null;
    }
}
