
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class CurrentTime {

	 public static void main(String[] args) {

	        // Formatter for readable output
	        DateTimeFormatter formatter =
	                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss z");

	        // GMT 
	        ZonedDateTime gmtTime =
	                ZonedDateTime.now(ZoneId.of("GMT"));
	        System.out.println("Current time in GMT: " +
	                gmtTime.format(formatter));

	        // IST 
	        ZonedDateTime istTime =
	                ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
	        System.out.println("Current time in IST: " +
	                istTime.format(formatter));

	        // PST
	        ZonedDateTime pstTime =
	                ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
	        System.out.println("Current time in PST: " +
	                pstTime.format(formatter));
	    }

}
