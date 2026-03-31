import java.util.*;

public class SubArraysSumZero {

    public static int findSubarrays(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        int count = 0;

        // Very important
        map.put(0, 1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                count += map.get(sum);   // 🔥 add frequency
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, -1, 2, -2, 3, -3};
        System.out.println(findSubarrays(arr));  // Output: 6
    }
}
