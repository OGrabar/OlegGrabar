package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.*;

public class CalculatorBaseTest {

    protected Calculator calculator;
    protected static final double DOUBLE_DELTA = 1e-6;

    @BeforeClass
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterClass
    public void tearDown() {
        calculator = null;
    }
}
