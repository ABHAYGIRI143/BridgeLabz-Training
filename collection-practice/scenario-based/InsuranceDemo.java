import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Policy {
    private String policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;

    public Policy(String policyNumber, String policyHolderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
    }

    public String getPolicyNumber() { return policyNumber; }
    public String getPolicyHolderName() { return policyHolderName; }
    public LocalDate getExpiryDate() { return expiryDate; }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyHolderName='" + policyHolderName + '\'' +
                ", expiryDate=" + expiryDate +
                '}';
    }
}

class InsurancePolicySystem {
    private Map<String, Policy> hashMapPolicies = new HashMap<>();
    private Map<String, Policy> linkedHashMapPolicies = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<Policy>> treeMapPolicies = new TreeMap<>();

    // Add policy to all maps
    public void addPolicy(Policy policy) {
        hashMapPolicies.put(policy.getPolicyNumber(), policy);
        linkedHashMapPolicies.put(policy.getPolicyNumber(), policy);

        treeMapPolicies.computeIfAbsent(policy.getExpiryDate(), k -> new ArrayList<>()).add(policy);
    }

    // Retrieve policy by policy number
    public Policy getPolicyByNumber(String policyNumber) {
        return hashMapPolicies.get(policyNumber);
    }

    // List policies expiring in next 30 days
    public List<Policy> getPoliciesExpiringIn30Days() {
        LocalDate today = LocalDate.now();
        LocalDate endDate = today.plusDays(30);

        List<Policy> expiringPolicies = new ArrayList<>();
        treeMapPolicies.subMap(today, true, endDate, true)
                       .values()
                       .forEach(expiringPolicies::addAll);

        return expiringPolicies;
    }

    // List all policies for a specific policyholder
    public List<Policy> getPoliciesByHolder(String holderName) {
        List<Policy> policies = new ArrayList<>();
        for (Policy p : hashMapPolicies.values()) {
            if (p.getPolicyHolderName().equalsIgnoreCase(holderName)) {
                policies.add(p);
            }
        }
        return policies;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        hashMapPolicies.values().removeIf(p -> p.getExpiryDate().isBefore(today));
        linkedHashMapPolicies.values().removeIf(p -> p.getExpiryDate().isBefore(today));
        treeMapPolicies.headMap(today, false).clear();
    }
}

public class InsuranceDemo {
    public static void main(String[] args) {
        InsurancePolicySystem system = new InsurancePolicySystem();

        // Add some policies
        system.addPolicy(new Policy("P1001", "Alice", LocalDate.of(2026, 2, 15)));
        system.addPolicy(new Policy("P1002", "Bob", LocalDate.of(2026, 1, 30)));
        system.addPolicy(new Policy("P1003", "Alice", LocalDate.of(2026, 3, 10)));

        System.out.println("Policy by Number P1002: " + system.getPolicyByNumber("P1002"));
        System.out.println("Policies expiring in 30 days: " + system.getPoliciesExpiringIn30Days());
        System.out.println("Policies for Alice: " + system.getPoliciesByHolder("Alice"));

        system.removeExpiredPolicies();
        System.out.println("After removing expired policies: " + system.getPoliciesExpiringIn30Days());
    }
}
