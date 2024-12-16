// LeetCode Question:
// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length

package solutions.LeetCode_75.Sliding_Window.Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length;

class Solution {
  public int maxVowels(String s, int k) {
    int maxCount = 0, currentCount = 0;
    String vowels = "aeiou";

    // Initialize the first window of size k
    for (int i = 0; i < k; i++) {
      if (vowels.indexOf(s.charAt(i)) != -1) {
        currentCount++;
      }
    }
    maxCount = currentCount;

    // Slide the window across the string
    for (int i = k; i < s.length(); i++) {
      if (vowels.indexOf(s.charAt(i)) != -1) {
        currentCount++;
      }
      if (vowels.indexOf(s.charAt(i - k)) != -1) {
        currentCount--;
      }
      maxCount = Math.max(maxCount, currentCount);
    }

    return maxCount;
  }
}
