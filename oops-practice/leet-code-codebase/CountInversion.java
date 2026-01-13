class Solution {
    
    static long countInversions(long[] arr) {
        long[] temp = new long[arr.length];
        return mergeSort(arr, temp, 0, arr.length - 1);
    }

    static long mergeSort(long[] arr, long[] temp, int left, int right) {
        long invCount = 0;

        if (left < right) {
            int mid = (left + right) / 2;

            invCount += mergeSort(arr, temp, left, mid);
            invCount += mergeSort(arr, temp, mid + 1, right);
            invCount += merge(arr, temp, left, mid, right);
        }

        return invCount;
    }

    static long merge(long[] arr, long[] temp, int left, int mid, int right) {
        int i = left;     
        int j = mid + 1;  
        int k = left;    
        long invCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid - i + 1);   // 🔥 key line
            }
        }

        while (i <= mid)
            temp[k++] = arr[i++];

        while (j <= right)
            temp[k++] = arr[j++];

        for (i = left; i <= right; i++)
            arr[i] = temp[i];

        return invCount;
    }
}
