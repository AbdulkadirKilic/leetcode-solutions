// LeetCode Question: https://leetcode.com/problems/median-of-two-sorted-arrays

package solutions.Array.Median_of_Two_Sorted_Arrays;

class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length, n = nums2.length;
    if (m > n) {
      // Ensure nums1 is the smaller array
      return findMedianSortedArrays(nums2, nums1);
    }

    int low = 0, high = m;
    while (low <= high) {
      int partitionX = (low + high) / 2;
      int partitionY = (m + n + 1) / 2 - partitionX;

      int maxX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
      int minX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

      int maxY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
      int minY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

      if (maxX <= minY && maxY <= minX) {
        // Correct partition found
        if ((m + n) % 2 == 0) {
          return ((double) Math.max(maxX, maxY) + Math.min(minX, minY)) / 2;
        } else {
          return (double) Math.max(maxX, maxY);
        }
      } else if (maxX > minY) {
        // Move left in nums1
        high = partitionX - 1;
      } else {
        // Move right in nums1
        low = partitionX + 1;
      }
    }

    throw new IllegalArgumentException("Input arrays are not sorted");
  }
}
