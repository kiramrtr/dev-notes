package source.java.code;

import java.util.Arrays;

public class StreamsUsage {

  public static void main(String[] args) {
    int[] arr = { 1, 4, 5, 6, 10 };
    Arrays.stream(arr).max().orElse(0);
  }
}
