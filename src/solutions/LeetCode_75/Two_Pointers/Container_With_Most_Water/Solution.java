// LeetCode Question: https://leetcode.com/problems/container-with-most-water

package solutions.LeetCode_75.Two_Pointers.Container_With_Most_Water;

class Solution {
  public int maxArea(int[] height) {
    int left = 0, right = height.length - 1;
    int maxArea = 0;

    while (left < right) {
      int currentHeight = Math.min(height[left], height[right]);
      int width = right - left;
      maxArea = Math.max(maxArea, currentHeight * width);

      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }

    return maxArea;
  }
}
