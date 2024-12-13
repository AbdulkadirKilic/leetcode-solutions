// LeetCode Question: https://leetcode.com/problems/greatest-common-divisor-of-strings

package solutions.LeetCode_75.Kids_With_the_Greatest_of_Candies;

import java.util.*;

class Solution {
  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    List<Boolean> result = new ArrayList<>();
    int maxCandies = 0;

    // Find the maximum candies any kid currently has
    for (int candy : candies) {
      if (candy > maxCandies) {
        maxCandies = candy;
      }
    }

    // Check if each kid can have the greatest candies with extraCandies
    for (int candy : candies) {
      result.add(candy + extraCandies >= maxCandies);
    }

    return result;
  }
}
