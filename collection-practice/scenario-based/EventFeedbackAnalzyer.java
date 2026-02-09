import java.util.*;

class InvalidRatingException extends RuntimeException {
    public InvalidRatingException(String message) {
        super(message);
    }
}



class EventFeedback {

    // Map<EventID, List<Integer>>
    private Map<String, List<Integer>> feedbackMap;

    public EventFeedback() {
        feedbackMap = new HashMap<>();
    }

    // Add rating for an event
    public void addRating(String eventId, int rating) {

        if (rating < 1 || rating > 5) {
            throw new InvalidRatingException(
                "Rating must be between 1 and 5."
            );
        }

        feedbackMap.putIfAbsent(eventId, new ArrayList<>());
        feedbackMap.get(eventId).add(rating);
    }

    // Calculate average rating of one event
    public double getAverageRating(String eventId) {

        List<Integer> ratings = feedbackMap.get(eventId);

        if (ratings == null || ratings.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (int r : ratings) {
            sum += r;
        }

        return (double) sum / ratings.size();
    }

    // Get average ratings of all events
    public Map<String, Double> getAllAverageRatings() {

        Map<String, Double> avgMap = new HashMap<>();

        for (String eventId : feedbackMap.keySet()) {
            avgMap.put(eventId, getAverageRating(eventId));
        }

        return avgMap;
    }

    // Identify top-rated event(s)
    public List<String> getTopRatedEvents() {

        List<String> topEvents = new ArrayList<>();
        double maxAvg = -1;

        for (String eventId : feedbackMap.keySet()) {

            double avg = getAverageRating(eventId);

            if (avg > maxAvg) {
                maxAvg = avg;
                topEvents.clear();
                topEvents.add(eventId);
            } else if (avg == maxAvg) {
                topEvents.add(eventId);
            }
        }

        return topEvents;
    }
}


public class EventFeedbackAnalzyer{
    public static void main(String[] args) {

        EventFeedback analyzer = new EventFeedback();

        try {
            analyzer.addRating("E101", 5);
            analyzer.addRating("E101", 4);

            analyzer.addRating("E102", 3);
            analyzer.addRating("E102", 5);

            analyzer.addRating("E103", 5);
            analyzer.addRating("E103", 5);

            // Invalid rating example
            // analyzer.addRating("E104", 7);

        } catch (InvalidRatingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Average Ratings:");
        System.out.println(analyzer.getAllAverageRatings());

        System.out.println("Top Rated Events:");
        System.out.println(analyzer.getTopRatedEvents());
    }
}
