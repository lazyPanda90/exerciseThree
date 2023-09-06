package org.example;

import java.util.Arrays;
import java.util.Random;

/**
 * HybridSort is a sorting class that uses a combination of quicksort and bubble sort algorithms.
 */
public class HybridSort {

  /**
   * Threshold value to switch from quicksort to bubble sort.
   */
  private static final int THRESHOLD = 10;

  public static void main(String[] args) {

    int[] sizes = {100000, 500000, 1000000, 5000000, 10000000, 20000000};

    for (int size : sizes) {
      int[] randomArray = generateRandomArray(size);

      long startTime = System.currentTimeMillis();
      quicksort(randomArray, 0, randomArray.length - 1);
      long endTime = System.currentTimeMillis();

      System.out.println("Datasettstørrelse: " + size);
      System.out.println("Sortering tok: " + (endTime - startTime) + " millisekunder");
      System.out.println("-----------------------------------------");
    }
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

  /**
   * Generates a random integer array of a given size.
   *
   * @param size The size of the array to generate.
   * @return     An array of random integers.
   */
  public static int[] generateRandomArray(int size) {
    Random rand = new Random();
    int[] arr = new int[size];

    for (int i = 0; i < size; i++) {
      arr[i] = rand.nextInt(100000);  // Genererer tilfeldige tall mellom 0 og 99999
    }

    return arr;
  }
}
