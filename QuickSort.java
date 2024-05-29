public class QuickSort {

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            // Partition the array and get the pivot index
            int part = partition(arr, start, end);

            // Recursively sort elements before and after partition
            quickSort(arr, start, part - 1);
            quickSort(arr, part + 1, end);
        }
    }

    // Method to take last element as pivot and to sort elements by placing them at correct position
    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];

        int i = (start - 1);

        for (int j = start; j < end; j++) {
            // checking the current element is smaller than pivot
            if (arr[j] <= pivot) {
                i++;

                // Swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {2,8,7,1,3,5,6,4};
        int n = arr.length;

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
