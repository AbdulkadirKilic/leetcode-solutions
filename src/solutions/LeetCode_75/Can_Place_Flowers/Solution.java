// LeetCode Question: https://leetcode.com/problems/can-place-flowers

package solutions.LeetCode_75.Can_Place_Flowers;

class Solution {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int count = 0;

    for (int i = 0; i < flowerbed.length; i++) {
      if (flowerbed[i] == 0) {
        // Check if the previous and next plots are empty or out of bounds
        boolean prevEmpty = (i == 0) || (flowerbed[i - 1] == 0);
        boolean nextEmpty = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);

        if (prevEmpty && nextEmpty) {
          flowerbed[i] = 1; // Plant a flower here
          count++;

          if (count >= n) {
            return true; // We have planted enough flowers
          }
        }
      }
    }

    return count >= n; // Check if we could plant the required number of flowers
  }
}
