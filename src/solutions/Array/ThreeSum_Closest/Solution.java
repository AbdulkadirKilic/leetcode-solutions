// LeetCode Question: https://leetcode.com/problems/3sum-closest

package solutions.Array.ThreeSum_Closest;

import java.util.Arrays;

class Solution {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums); // Sort the array to simplify the two-pointer approach
    int closestSum = Integer.MAX_VALUE; // Placeholder for the closest sum

    for (int i = 0; i < nums.length - 2; i++) {
      int left = i + 1, right = nums.length - 1;

      while (left < right) {
        int currentSum = nums[i] + nums[left] + nums[right];

        // Update closest sum if the current sum is closer to the target
        if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
          closestSum = currentSum;
        }

        // Move pointers based on the comparison with the target
        if (currentSum < target) {
          left++;
        } else {
          right--;
        }
      }
    }

    return closestSum;
  }
}
