public class QuickSortPrices {

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            int p = partition(arr, low, high);

            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];   // choose last element as pivot
        int i = low - 1;         // index for smaller elements

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // place pivot in correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {

        int[] prices = {1200, 800, 1500, 500, 1000};

        quickSort(prices, 0, prices.length - 1);

        for (int p : prices) {
            System.out.print(p + " ");
        }
    }
}
