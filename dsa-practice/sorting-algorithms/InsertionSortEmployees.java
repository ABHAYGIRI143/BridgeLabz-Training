public class InsertionSortEmployees {

    public static void insertionSort(int[] empIds) {

        int n = empIds.length;

        for (int i = 1; i < n; i++) {
            int key = empIds[i];
            int j = i - 1;

            // Shift larger elements to the right
            while (j >= 0 && empIds[j] > key) {
                empIds[j + 1] = empIds[j];
                j--;
            }

            // Insert key at correct position
            empIds[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        int[] empIds = {105, 101, 109, 102};

        insertionSort(empIds);

        for (int id : empIds) {
            System.out.print(id + " ");
        }
    }
}
