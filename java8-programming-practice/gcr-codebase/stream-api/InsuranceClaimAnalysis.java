import java.util.*;
import java.util.stream.Collectors;

class Claim {
    String claimType;
    double claimAmount;

    Claim(String claimType, double claimAmount) {
        this.claimType = claimType;
        this.claimAmount = claimAmount;
    }
}


public class InsuranceClaimAnalysis {

    public static void main(String[] args) {

        List<Claim> claims = Arrays.asList(
            new Claim("Health", 50000),
            new Claim("Vehicle", 20000),
            new Claim("Health", 30000),
            new Claim("Property", 80000),
            new Claim("Vehicle", 25000),
            new Claim("Health", 70000)
        );

        Map<String, Double> avgClaimByType =
            claims.stream()
                  .collect(Collectors.groupingBy(
                      c -> c.claimType,
                      Collectors.averagingDouble(c -> c.claimAmount)
                  ));

        avgClaimByType.forEach((type, avg) ->
            System.out.println(type + " Average Claim Amount: " + avg)
        );
    }
}
