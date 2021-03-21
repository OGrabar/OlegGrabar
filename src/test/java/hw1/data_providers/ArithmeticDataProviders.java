package hw1.data_providers;

import org.testng.annotations.DataProvider;

import java.util.concurrent.ThreadLocalRandom;

public class ArithmeticDataProviders {

    private static final ThreadLocalRandom currentThreadLocalRandom = ThreadLocalRandom.current();

    @DataProvider(name = "longValuesForSumOrSub")
    public static Object[][] sumAndSubLongValuesDataProvider() {
        long first = currentThreadLocalRandom.nextLong(Long.MAX_VALUE / 2);
        long second = currentThreadLocalRandom.nextLong(Long.MAX_VALUE / 2 + 1);
        return new Object[][] {
                {first, second}
        };
    }

    @DataProvider(name = "doubleValuesForSumOrSub")
    public static Object[][] sumAndSubDoubleValuesDataProvider() {
        double first = currentThreadLocalRandom.nextDouble(Double.MAX_VALUE / 2);
        double second = currentThreadLocalRandom.nextDouble(Double.MAX_VALUE / 2);
        return new Object[][] {
                {first, second},
                {1.23, 3.45}
        };
    }

    @DataProvider(name = "longValuesForDiv")
    public static Object[][] divLongValuesDataProvider() {
        long first = currentThreadLocalRandom.current().nextLong();
        long second = currentThreadLocalRandom.current().nextLong();
        return new Object[][] {
                {first, second}
        };
    }

    @DataProvider(name = "doubleValuesForDiv")
    public static Object[][] divDoubleValuesDataProvider() {
        double first = currentThreadLocalRandom.nextDouble();
        double second = currentThreadLocalRandom.nextDouble(1, Double.MAX_VALUE);
        return new Object[][] {
                {first, second},
                {1.23, 3.45}
        };
    }

    @DataProvider(name = "longValuesForMult")
    public static Object[][] multLongValuesDataProvider() {
        long first = currentThreadLocalRandom.nextLong(0, Long.MAX_VALUE);
        long second = currentThreadLocalRandom.nextLong(Long.MAX_VALUE / first);
        return new Object[][] {
                {first, second},
        };
    }

    @DataProvider(name = "doubleValuesForMult")
    public static Object[][] multDoubleValuesDataProvider() {
        double first = currentThreadLocalRandom.nextDouble();
        double second = currentThreadLocalRandom.nextDouble(Double.MAX_VALUE / first);
        return new Object[][] {
                {first, second},
                {1.23, 3.45}
        };
    }

}
