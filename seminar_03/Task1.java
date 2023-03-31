package seminar_03;

import java.util.Arrays;

public class Task1 {
    // Реализовать алгоритм сортировки слиянием
    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);
            mergeSort(left);
            mergeSort(right);
            int i = 0, j = 0, k = 0;
            while (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    arr[k++] = left[i++];
                } else {
                    arr[k++] = right[j++];
                }
            }
            while (i < left.length)
                arr[k++] = left[i++];
            while (j < right.length)
                arr[k++] = right[j++];
        }
    }
    public static void main(String[] args) {
        int[] arr = {4, 7, 2, 9, 7, 12, 6, 9, 0, 45};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
