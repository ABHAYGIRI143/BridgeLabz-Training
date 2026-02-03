import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TransactionLogger {

    public static void main(String[] args) {

        List<String> transactionIds = Arrays.asList(
            "TXN1001",
            "TXN1002",
            "TXN1003",
            "TXN1004"
        );

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        transactionIds.forEach(txnId -> {
            String timestamp = LocalDateTime.now().format(formatter);
            System.out.println(
                "[" + timestamp + "] Transaction logged: " + txnId
            );
        });
    }
}
