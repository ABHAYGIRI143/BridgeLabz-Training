import java.util.*;

class VotingSystem {
    private Map<String, Integer> votesMap = new HashMap<>();         // Candidate -> Votes
    private Map<String, Integer> linkedVotesMap = new LinkedHashMap<>(); // Maintain insertion order

    // Add vote for a candidate
    public void vote(String candidate) {
        votesMap.put(candidate, votesMap.getOrDefault(candidate, 0) + 1);
        linkedVotesMap.put(candidate, linkedVotesMap.getOrDefault(candidate, 0) + 1);
    }

    // Display results in sorted order by candidate name
    public void displaySortedResults() {
        TreeMap<String, Integer> sortedResults = new TreeMap<>(votesMap);
        System.out.println("Sorted Results: " + sortedResults);
    }

    // Display results in insertion order
    public void displayOrderedResults() {
        System.out.println("Ordered Results: " + linkedVotesMap);
    }
}

public class VotingDemo {
    public static void main(String[] args) {
        VotingSystem voting = new VotingSystem();

        voting.vote("Alice");
        voting.vote("Bob");
        voting.vote("Alice");
        voting.vote("Charlie");
        voting.vote("Bob");

        voting.displaySortedResults();
        voting.displayOrderedResults();
    }
}
