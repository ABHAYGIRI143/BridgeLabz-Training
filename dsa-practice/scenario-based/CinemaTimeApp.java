
import java.util.ArrayList;
import java.util.List;

class InvalidTimeFormatException extends Exception {
    public InvalidTimeFormatException(String message) {
        super(message);
    }
}


class CinemaTime {

    private List<String> movieTitles = new ArrayList<>();
    private List<String> showTimes = new ArrayList<>();

    // ADD MOVIE
    public void addMovie(String title, String time) throws InvalidTimeFormatException {
        if (!isValidTime(time)) {
            throw new InvalidTimeFormatException("Invalid time format: " + time);
        }
        movieTitles.add(title);
        showTimes.add(time);
    }

    // SEARCH MOVIE
    public void searchMovie(String keyword) {
        try {
            boolean found = false;
            for (int i = 0; i < movieTitles.size(); i++) {
                if (movieTitles.get(i).toLowerCase().contains(keyword.toLowerCase())) {
                    System.out.println(formatMovie(i));
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No movie found with keyword: " + keyword);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index accessed!");
        }
    }

    // DISPLAY ALL MOVIES
    public void displayAllMovies() {
        for (int i = 0; i < movieTitles.size(); i++) {
            System.out.println(formatMovie(i));
        }
    }

    // FORMAT OUTPUT
    private String formatMovie(int index) {
        return String.format("Movie: %s | Time: %s",
                movieTitles.get(index), showTimes.get(index));
    }

    // TIME VALIDATION
    private boolean isValidTime(String time) {
        if (!time.matches("\\d{2}:\\d{2}")) return false;

        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(3, 5));

        return hours >= 0 && hours < 24 && minutes >= 0 && minutes < 60;
    }

    // CONVERT LIST TO ARRAY FOR REPORT
    public void generateReport() {
        String[] report = movieTitles.toArray(new String[0]);

        System.out.println("\n--- Printable Movie Report ---");
        for (String movie : report) {
            System.out.println(movie);
        }
    }
}


public class CinemaTimeApp {
    public static void main(String[] args) {

        CinemaTime cinema = new CinemaTime();

        try {
            cinema.addMovie("Inception", "18:30");
            cinema.addMovie("Interstellar", "21:00");
            cinema.addMovie("Avatar", "25:99"); // ❌ Invalid time
        } catch (InvalidTimeFormatException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- All Movies ---");
        cinema.displayAllMovies();

        System.out.println("\n--- Search Result ---");
        cinema.searchMovie("inter");

        cinema.generateReport();
    }
}
