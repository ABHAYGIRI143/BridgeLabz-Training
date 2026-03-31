import java.util.Arrays;

public class LinearAndBinarySearch {

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        int target = 4;

        int missing = firstMissingPositive(arr);
        System.out.println("First missing positive integer: " + missing);

        // Sort array before binary search
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));

        int targetIndex = binarySearch(arr, target);
        System.out.println("Index of target " + target + ": " + targetIndex);
    }

    // -------- Linear Search for First Missing Positive --------
    public static int firstMissingPositive(int[] arr) {
        int n = arr.length;

        // Boolean array to mark visited positives
        boolean[] visited = new boolean[n + 1];

        // Mark numbers present in array
        for (int num : arr) {
            if (num > 0 && num <= n) {
                visited[num] = true;
            }
        }

        // Find first missing positive
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                return i;
            }
        }

        return n + 1;
    }

    // -------- Binary Search for Target --------
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
