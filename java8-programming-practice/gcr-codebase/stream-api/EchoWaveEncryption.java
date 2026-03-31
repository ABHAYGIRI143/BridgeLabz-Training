import java.util.*;

public class EchoWaveEncryption {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        // 1️⃣ Input Validation
        if (!input.matches("^[A-Za-z]+$")) {
            System.out.println(input + " is an invalid input");
            return;
        }

        // 2️⃣ Normalize input
        input = input.toUpperCase();

        // 3️⃣ Character grouping with order preserved
        LinkedHashMap<Character, Integer> freqMap = new LinkedHashMap<>();

        for (char ch : input.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        StringBuilder encrypted = new StringBuilder();
        StringBuilder remaining = new StringBuilder();

        List<Character> evenGroup = new ArrayList<>();
        List<Character> oddGroup = new ArrayList<>();

        int singleOccurrenceCount = 0;

        // 4️⃣ Group characters
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();

            if (count % 2 == 0) {
                evenGroup.add(ch);
            } else {
                oddGroup.add(ch);
            }

            if (count == 1) {
                singleOccurrenceCount++;
            }
        }

        // 5️⃣ Construction steps
        // Append Group 1 (even)
        for (char ch : evenGroup) {
            encrypted.append(ch);
        }

        // Append Group 2 (odd)
        for (char ch : oddGroup) {
            encrypted.append(ch);
        }

        // Append remaining occurrences
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();

            for (int i = 1; i < count; i++) {
                remaining.append(ch);
            }
        }

        encrypted.append(remaining);

        // 6️⃣ Insert single-occurrence count
        if (singleOccurrenceCount > 0) {
            int len = encrypted.length();
            int insertIndex = (len % 2 == 0) ? (len / 2 - 1) + 1 : (len / 2) + 1;
            encrypted.insert(insertIndex, singleOccurrenceCount);
        }

        // Output
        System.out.println(encrypted.toString());
    }
}
