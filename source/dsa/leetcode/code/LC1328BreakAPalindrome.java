package dsa.leetcode.code;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LC1328BreakAPalindrome {

  Solution s = new Solution();

  private static Stream<Arguments> testParams() {
    return Stream.of(
      Arguments.of("a", ""),
      Arguments.of("aa", "ab"),
      Arguments.of("abccba", "aaccba")
    );
  }

  @ParameterizedTest
  @MethodSource("testParams")
  void breakAPalindrome(String input, String expected) {
    assertEquals(expected, s.breakPalindrome(input));
  }

  class Solution {

    public String breakPalindrome(String palindrome) {
      final int n = palindrome.length();

      if (n == 1) return "";
      StringBuilder sb = new StringBuilder(palindrome);

      for (int i = 0; i < n / 2; ++i) {
        if (palindrome.charAt(i) != 'a') {
          sb.setCharAt(i, 'a');
          return sb.toString();
        }
      }

      sb.setCharAt(n - 1, 'b');
      return sb.toString();
    }
  }
}
