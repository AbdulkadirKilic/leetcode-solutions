// LeetCode Question: https://leetcode.com/problems/4sum

package solutions.Array.FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums == null || nums.length < 4) return result;

    Arrays.sort(nums); // Sort the array to use the two-pointer technique

    for (int i = 0; i < nums.length - 3; i++) {
      // Skip duplicates for the first number
      if (i > 0 && nums[i] == nums[i - 1]) continue;

      for (int j = i + 1; j < nums.length - 2; j++) {
        // Skip duplicates for the second number
        if (j > i + 1 && nums[j] == nums[j - 1]) continue;

        int left = j + 1, right = nums.length - 1;
        while (left < right) {
          long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

          if (sum == target) {
            result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

            // Skip duplicates for the third and fourth numbers
            while (left < right && nums[left] == nums[left + 1]) left++;
            while (left < right && nums[right] == nums[right - 1]) right--;

            left++;
            right--;
          } else if (sum < target) {
            left++; // Increase sum
          } else {
            right--; // Decrease sum
          }
        }
      }
    }

    return result;
  }
}
