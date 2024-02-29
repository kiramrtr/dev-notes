import java.util.Arrays;

class BlockSwap {

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
    System.out.println(Arrays.toString(arr));

    rotate(arr, 0, 4, 7);

    System.out.println(Arrays.toString(arr));
  }

  public static void rotate(int arr[], int start, int k, int size) {
    System.out.println(
      String.format(
        ">> rotate(arr[]: %s, start: %d, k: %d, size: %d)",
        Arrays.toString(arr),
        start,
        k,
        size
      )
    );

    if (k == 0 || k == size) return;

    // divide the array into two parts
    // A = [0...K-1] or [start...K-1]
    // B = [K...N-1] or [K...N-1]

    // Example
    // [1, 2, 3, 4, 5, 6, 7]
    //  0  1  2  3  4  5  6

    int aBlockSize = k;
    int bBlockSize = size - k;

    if (aBlockSize == bBlockSize) {
      // size - k + start: starting index of block B
      swap(arr, start, size - k + start, k);
      return;
    }

    if (aBlockSize < bBlockSize) { // Block A is smaller than Block B
      // start + bBlockSize: starting index for swapping
      swap(arr, start, bBlockSize + start, k);
      rotate(arr, start, k, bBlockSize);
    } else { // Block A is larger than Block B
      swap(arr, start, k, bBlockSize);
      rotate(arr, bBlockSize + start, 2 * k - size, k);
    }
  }

  public static void swap(int arr[], int aIdx, int bIdx, int k) {
    System.out.println(
      String.format(
        ">>>> swap(arr: %s, start: %d, end: %d, k: %d)",
        Arrays.toString(arr),
        aIdx,
        bIdx,
        k
      )
    );
    for (int i = 0; i < k; i++) {
      int temp = arr[aIdx + i];
      arr[aIdx + i] = arr[bIdx + i];
      arr[bIdx + i] = temp;
    }
  }
}
