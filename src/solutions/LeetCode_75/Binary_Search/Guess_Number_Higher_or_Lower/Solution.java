// LeetCode Question: https://leetcode.com/problems/guess-number-higher-or-lower

package solutions.LeetCode_75.Binary_Search.Guess_Number_Higher_or_Lower;

public class Solution extends GuessGame {
  public int guessNumber(int n) {
    int left = 1, right = n;

    while (left <= right) {
      int mid = left + (right - left) / 2; // Avoid overflow when calculating mid
      int result = guess(mid);

      if (result == 0) {
        return mid; // Found the correct number
      } else if (result == -1) {
        right = mid - 1; // Guess is higher, adjust the upper bound
      } else {
        left = mid + 1; // Guess is lower, adjust the lower bound
      }
    }

    return -1; // Should never reach here
  }
}
