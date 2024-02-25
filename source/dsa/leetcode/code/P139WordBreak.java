package source.dsa.leetcode.code;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P139WordBreak {

  public static void main(String[] args) {
    Solution s = new P139WordBreak().new Solution();
    System.out.println(s.wordBreak("leetcode", List.of("leet", "code")));
  }

  class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
      final Set<String> dict = new HashSet<>(wordDict);
      final int n = s.length();
      boolean[] possible = new boolean[n + 1];
      possible[0] = true;

      for (int i = 1; i < n + 1; ++i) {
        for (int k = 0; k < i; ++k) {
          if (possible[k] && dict.contains(s.substring(k, i))) {
            possible[i] = true;
            break;
          }
        }
      }

      return possible[n];
    }
  }
}
