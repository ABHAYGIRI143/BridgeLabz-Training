import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

    @Test
    void testDivideByZeroThrowsException() {
        ArithmeticException exception =
                assertThrows(ArithmeticException.class, () -> {
                    MathUtils.divide(10, 0);
                });

        assertEquals("Division by zero is not allowed", exception.getMessage());
    }
}
