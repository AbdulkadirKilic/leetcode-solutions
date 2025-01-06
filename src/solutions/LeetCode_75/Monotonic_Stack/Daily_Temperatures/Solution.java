// LeetCode Question: https://leetcode.com/problems/daily-temperatures

package solutions.LeetCode_75.Monotonic_Stack.Daily_Temperatures;

import java.util.Stack;

class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
    int n = temperatures.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>(); // Store indices of temperatures

    for (int i = 0; i < n; i++) {
      // Check if the current temperature is warmer than the temperature at the index stored in the
      // stack
      while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
        int index = stack.pop();
        result[index] = i - index; // Calculate the number of days
      }
      stack.push(i); // Store the current day's index
    }

    return result;
  }
}
