import java.util.*;

public class CompareSets {

    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 3, 2, 1));

        System.out.println(set1.equals(set2));
    }
}
