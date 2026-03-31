public class SelectionSortScores {

    public static void selectionSort(int[] scores) {

        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;   // assume first element is smallest

            // find the minimum in remaining array
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // swap smallest with first unsorted element
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    public static void main(String[] args) {

        int[] scores = {85, 70, 90, 60, 75};

        selectionSort(scores);

        for (int score : scores) {
            System.out.print(score + " ");
        }
    }
}
