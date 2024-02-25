package source.dsa.leetcode.code;

import java.util.Arrays;
import java.util.Comparator;

public class P1235MaximumProfitInJobScheduling {

  public static void main(String[] args) {
    Solution s = new P1235MaximumProfitInJobScheduling().new Solution();
    System.out.println(
      s.jobScheduling(
        new int[] { 1, 2, 3, 4, 6 },
        new int[] { 3, 5, 10, 6, 9 },
        new int[] { 20, 20, 100, 70, 60 }
      )
    );
  }

  class Solution {

    private class Job {

      int startTime;
      int endTime;
      int profit;

      Job(int startTime, int endTime, int profit) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
      }

      @Override
      public String toString() {
        return String.format("%d->%d: %d", startTime, endTime, profit);
      }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
      final int n = startTime.length;

      Job[] jobs = new Job[n];

      for (int i = 0; i < n; ++i) {
        jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
      }

      Arrays.sort(jobs, Comparator.comparingInt(job -> job.endTime));

      int[] dp = new int[n + 1];

      for (int i = 0; i < n; ++i) {
        int lastNonConflictingJobIndex = findLastNonConflictingJobIndex(
          jobs,
          jobs[i].startTime,
          i
        );

        dp[i + 1] =
          Math.max(dp[i], dp[lastNonConflictingJobIndex + 1] + jobs[i].profit);
      }

      return dp[n];
    }

    // find the last job whose endTime is not laterThan the startTime
    private int findLastNonConflictingJobIndex(
      Job[] jobs,
      int startTime,
      int upperBound
    ) {
        int left = 0, right = upperBound;
        while (left < right) {
            
        }
      for (int i = upperBound; i >= 0; --i) {
        if (startTime >= jobs[i].endTime) {
          return i;
        }
      }
      return -1;
    }
  }
}
