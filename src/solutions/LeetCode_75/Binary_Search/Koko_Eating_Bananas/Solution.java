// LeetCode Question: https://leetcode.com/problems/koko-eating-bananas

package solutions.LeetCode_75.Binary_Search.Koko_Eating_Bananas;

class Solution {
  public int minEatingSpeed(int[] piles, int h) {
    int left = 1, right = getMaxPile(piles); // Search space: [1, maxPile]

    while (left < right) {
      int mid = left + (right - left) / 2;
      if (canEatAll(piles, mid, h)) {
        right = mid; // Try smaller speed
      } else {
        left = mid + 1; // Increase speed
      }
    }

    return left; // The minimum speed
  }

  private boolean canEatAll(int[] piles, int speed, int h) {
    int totalHours = 0;
    for (int pile : piles) {
      totalHours += (pile + speed - 1) / speed; // Calculate hours needed for each pile
      if (totalHours > h) return false; // Exceeds allowed hours
    }
    return true;
  }

  private int getMaxPile(int[] piles) {
    int max = 0;
    for (int pile : piles) {
      max = Math.max(max, pile); // Find the maximum pile size
    }
    return max;
  }
}
