package source.java.code;

import java.util.Arrays;

public class CollectionsUsage {

  public static void main(String[] args) {
    // binarySearch
    int[] arr = { 1, 3, 5 };
    System.out.println("arr length: " + arr.length);
    System.out.println(Arrays.binarySearch(arr, 2));
    System.out.println(Arrays.binarySearch(arr, 6));
  }
}
