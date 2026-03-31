import java.util.Random;

public class TicketPriceOptimizer {

    // Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);

            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    // Partition
    public static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i;
    }

    // Display top cheapest tickets
    public static void showCheapest(int[] arr, int k) {
        System.out.println("\nTop " + k + " Cheapest Tickets:");
        for (int i = 0; i < k; i++) {
            System.out.print("₹" + arr[i] + "  ");
        }
    }

    // Display top expensive tickets
    public static void showMostExpensive(int[] arr, int k) {
        System.out.println("\n\nTop " + k + " Most Expensive Tickets:");
        for (int i = arr.length - k; i < arr.length; i++) {
            System.out.print("₹" + arr[i] + "  ");
        }
    }

    public static void main(String[] args) {

        int totalTickets = 200;   // simulate large dataset
        int[] prices = new int[totalTickets];

        // Generate random ticket prices
        Random r = new Random();
        for (int i = 0; i < totalTickets; i++) {
            prices[i] = 100 + r.nextInt(5000);   // ₹100 to ₹5100
        }

        // Sort ticket prices
        quickSort(prices, 0, prices.length - 1);

        // Show Top 50
        int k = 50;
        showCheapest(prices, k);
        showMostExpensive(prices, k);
    }
}
