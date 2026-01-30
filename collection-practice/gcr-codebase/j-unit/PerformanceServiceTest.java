import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class PerformanceServiceTest {

    private PerformanceService service = new PerformanceService();

    @Test
    @Timeout(2) // seconds
    void testLongRunningTaskPerformance() throws InterruptedException {
        service.longRunningTask();
    }
}
