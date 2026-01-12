import java.util.*;

// ================= Custom Exception =================
class DuplicateVoteException extends Exception {
    public DuplicateVoteException(String msg) {
        super(msg);
    }
}

// ================= Abstraction =================
interface ElectionService {
    void registerVoter(Voter v);
    void addCandidate(Candidate c);
    void castVote(int voterId, int candidateId) throws DuplicateVoteException;
    void showResults();
}

// ================= Voter =================
class Voter {
    int id;
    String name;
    boolean hasVoted = false;

    Voter(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// ================= Candidate =================
class Candidate {
    int id;
    String name;
    int votes = 0;

    Candidate(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// ================= Election =================
class Election implements ElectionService {

    private Map<Integer, Voter> voters = new HashMap<>();
    private Map<Integer, Candidate> candidates = new HashMap<>();

    // CREATE Voter
    public void registerVoter(Voter v) {
        voters.put(v.id, v);
        System.out.println("Voter Registered: " + v.name);
    }

    // CREATE Candidate
    public void addCandidate(Candidate c) {
        candidates.put(c.id, c);
        System.out.println("Candidate Added: " + c.name);
    }

    // Vote casting
    public void castVote(int voterId, int candidateId) throws DuplicateVoteException {

        Voter v = voters.get(voterId);
        Candidate c = candidates.get(candidateId);

        if (v.hasVoted)
            throw new DuplicateVoteException("Voter " + v.name + " has already voted!");

        c.votes++;
        v.hasVoted = true;

        System.out.println(v.name + " voted for " + c.name);
    }

    // Result declaration
    public void showResults() {
        System.out.println("\nElection Results:");
        for (Candidate c : candidates.values()) {
            System.out.println(c.name + " → " + c.votes + " votes");
        }
    }
}

// ================= Main =================
public class OnlineVotingSystem {
    public static void main(String[] args) {

        Election election = new Election();

        // Register voters
        election.registerVoter(new Voter(1, "Abhay"));
        election.registerVoter(new Voter(2, "Rahul"));

        // Add candidates
        election.addCandidate(new Candidate(101, "Alice"));
        election.addCandidate(new Candidate(102, "Bob"));

        try {
            election.castVote(1, 101);
            election.castVote(2, 102);
            election.castVote(1, 102);   // Duplicate vote
        }
        catch (DuplicateVoteException e) {
            System.out.println(e.getMessage());
        }

        election.showResults();
    }
}
