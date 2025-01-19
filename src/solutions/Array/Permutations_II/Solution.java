// LeetCode Question: https://leetcode.com/problems/permutations-ii

package solutions.Array.Permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums); // Sort to handle duplicates
    backtrack(nums, new boolean[nums.length], new ArrayList<>(), result);
    return result;
  }

  private void backtrack(
      int[] nums, boolean[] used, List<Integer> tempList, List<List<Integer>> result) {
    if (tempList.size() == nums.length) {
      result.add(new ArrayList<>(tempList));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (used[i]) continue;
      // Skip duplicates: ensure not using the same number twice in a level
      if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
      used[i] = true;
      tempList.add(nums[i]);
      backtrack(nums, used, tempList, result);
      used[i] = false;
      tempList.remove(tempList.size() - 1);
    }
  }
}
