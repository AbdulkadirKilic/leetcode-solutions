// LeetCode Question: https://leetcode.com/problems/permutations

package solutions.Array.Permutations;

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(nums, new ArrayList<>(), new boolean[nums.length], result);
    return result;
  }

  private void backtrack(
      int[] nums, List<Integer> tempList, boolean[] used, List<List<Integer>> result) {
    if (tempList.size() == nums.length) {
      result.add(new ArrayList<>(tempList));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (used[i]) continue;
      used[i] = true;
      tempList.add(nums[i]);
      backtrack(nums, tempList, used, result);
      used[i] = false;
      tempList.remove(tempList.size() - 1);
    }
  }
}
