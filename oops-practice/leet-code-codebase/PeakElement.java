public class PeakElement {

    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};

        int peakIndex = findPeakElement(arr);

        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element value: " + arr[peakIndex]);
    }

    public static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid is smaller than next element,
            // then peak must be on the right side
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                // Peak is on the left side (including mid)
                right = mid;
            }
        }

        // left == right -> peak element index
        return left;
    }
}
