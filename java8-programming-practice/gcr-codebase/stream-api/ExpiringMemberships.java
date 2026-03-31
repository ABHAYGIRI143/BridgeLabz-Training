import java.time.LocalDate;
import java.util.*;

import java.time.LocalDate;

class Member {
    String name;
    LocalDate expiryDate;

    Member(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return name + " | Expiry Date: " + expiryDate;
    }
}


public class ExpiringMemberships {

    public static void main(String[] args) {

        List<Member> members = Arrays.asList(
            new Member("Rahul", LocalDate.now().plusDays(10)),
            new Member("Anita", LocalDate.now().plusDays(45)),
            new Member("Vikram", LocalDate.now().plusDays(25)),
            new Member("Sneha", LocalDate.now().plusDays(5)),
            new Member("Karan", LocalDate.now().plusDays(60))
        );

        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        members.stream()
            // filter members whose membership expires in next 30 days
            .filter(m -> !m.expiryDate.isBefore(today)
                      && !m.expiryDate.isAfter(next30Days))
            .forEach(System.out::println);
    }
}
