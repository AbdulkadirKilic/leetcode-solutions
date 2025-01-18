// LeetCode Question: https://leetcode.com/problems/combination-sum-ii

package solutions.Array.Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates); // Sort to handle duplicates and for easier backtracking
    backtrack(candidates, target, 0, new ArrayList<>(), result);
    return result;
  }

  private void backtrack(
      int[] candidates,
      int target,
      int start,
      List<Integer> combination,
      List<List<Integer>> result) {
    if (target == 0) {
      result.add(new ArrayList<>(combination));
      return;
    }

    for (int i = start; i < candidates.length; i++) {
      // Skip duplicates
      if (i > start && candidates[i] == candidates[i - 1]) continue;

      if (candidates[i] > target) break; // Early termination if the candidate exceeds the target

      combination.add(candidates[i]);
      backtrack(
          candidates, target - candidates[i], i + 1, combination, result); // Move to next index
      combination.remove(combination.size() - 1); // Backtrack
    }
  }
}
