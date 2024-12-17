// LeetCode Question: https://leetcode.com/problems/find-the-difference-of-two-arrays

package solutions.LeetCode_75.HashMap_Set.Find_the_Difference_of_Two_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    Set<Integer> set1 = new HashSet<>();
    Set<Integer> set2 = new HashSet<>();

    for (int num : nums1) {
      set1.add(num);
    }
    for (int num : nums2) {
      set2.add(num);
    }

    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    for (int num : set1) {
      if (!set2.contains(num)) {
        list1.add(num);
      }
    }
    for (int num : set2) {
      if (!set1.contains(num)) {
        list2.add(num);
      }
    }

    return Arrays.asList(list1, list2);
  }
}
