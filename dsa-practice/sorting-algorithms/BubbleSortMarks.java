public class BubbleSortMarks {

    public static void bubbleSort(int[] marks) {

        int n = marks.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {

            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    // swap
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            // if no swaps, array is already sorted
            if (!swapped)
                break;
        }
    }

    public static void main(String[] args) {

        int[] marks = {70, 85, 60, 90, 75};

        bubbleSort(marks);

        for (int m : marks) {
            System.out.print(m + " ");
        }
    }
}
