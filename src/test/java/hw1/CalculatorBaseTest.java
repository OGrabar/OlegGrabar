package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CalculatorBaseTest {

    protected Calculator calculator;
    protected static final double DOUBLE_DELTA = 1e-6;

    @BeforeClass
    public void setUp() {
        System.out.println("213");
        calculator = new Calculator();
    }

    @AfterClass
    public void tearDown() {
        calculator = null;
    }
}
