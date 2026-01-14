public class CountingSortAges {

    public static void countingSort(int[] ages) {

        int minAge = 10;
        int maxAge = 18;
        int range = maxAge - minAge + 1;

        int[] count = new int[range];
        int[] output = new int[ages.length];

        // Step 1: Count frequency
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Step 2: Cumulative frequency
        for (int i = 1; i < range; i++) {
            count[i] = count[i] + count[i - 1];
        }

        // Step 3: Build output array (right to left for stability)
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            int index = count[age - minAge] - 1;
            output[index] = age;
            count[age - minAge]--;
        }


        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] ages = {12, 10, 14, 12, 15, 10, 18, 14};

        countingSort(ages);

        for (int age : ages) {
            System.out.print(age + " ");
        }
    }
}
