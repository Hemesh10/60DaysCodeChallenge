package problems;

import java.util.Arrays;

public class Day19Problem_SortColors {
    // used quick sort algorithm
    static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quicksort(arr, low, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int[] sortColors(int[] nums) {
        quicksort(nums, 0, nums.length - 1);

        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};

        int[] res = sortColors(nums);
        System.out.println(Arrays.toString(res));
    }
}
