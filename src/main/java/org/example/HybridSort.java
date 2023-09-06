package org.example;

/**
 * HybridSort is a sorting class that uses a combination of quicksort and bubble sort algorithms.
 */
public class HybridSort {

  /**
   * Threshold value to switch from quicksort to bubble sort.
   */
  private static final int THRESHOLD = 10; // Bytt til boblesort når arrayet er mindre enn denne størrelsen.


  public static void main(String[] args) {
    int[] arr = {12, 4, 5, 6, 7, 3, 1, 15};
    quicksort(arr, 0, arr.length - 1);

    for (int num : arr) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  /**
   * Sorts an array using quicksort or bubble sort based on the given threshold.
   *
   * @param arr  The array to be sorted.
   * @param low  The starting index for sorting.
   * @param high The ending index for sorting.
   */
  public static void quicksort(int[] arr, int low, int high) {
    if (low < high) {
      if (high - low < THRESHOLD) {
        bubbleSort(arr, low, high);
        return;
      }

      int pivot = partition(arr, low, high);

      quicksort(arr, low, pivot - 1);
      quicksort(arr, pivot + 1, high);
    }
  }

  /**
   * Partitions the array around a pivot element.
   *
   * @param arr  The array to be partitioned.
   * @param low  The starting index for partitioning.
   * @param high The ending index for partitioning.
   * @return     The pivot index after partitioning.
   */
  public static int partition(int[] arr, int low, int high) {
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

  /**
   * Sorts a sub-array using the bubble sort algorithm.
   *
   * @param arr  The array containing the sub-array to be sorted.
   * @param low  The starting index of the sub-array.
   * @param high The ending index of the sub-array.
   */
  public static void bubbleSort(int[] arr, int low, int high) {
    for (int i = low; i <= high; i++) {
      for (int j = low; j < high - i + low; j++) {
        if (arr[j] > arr[j + 1]) {
          swap(arr, j, j + 1);
        }
      }
    }
  }
  
  /**
   * Swaps two elements in an array.
   *
   * @param arr The array containing elements to be swapped.
   * @param i   The index of the first element.
   * @param j   The index of the second element.
   */
  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
