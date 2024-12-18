// LeetCode Question: https://leetcode.com/problems/asteroid-collision

package solutions.LeetCode_75.Asteroid_Collision;

import java.util.Stack;

class Solution {
  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();

    for (int asteroid : asteroids) {
      boolean isAlive = true;

      while (isAlive && asteroid < 0 && !stack.isEmpty() && stack.peek() > 0) {
        if (stack.peek() < -asteroid) {
          stack.pop(); // Previous asteroid explodes
        } else if (stack.peek() == -asteroid) {
          stack.pop(); // Both asteroids explode
          isAlive = false;
        } else {
          isAlive = false; // Current asteroid explodes
        }
      }

      if (isAlive) {
        stack.push(asteroid);
      }
    }

    int[] result = new int[stack.size()];
    for (int i = result.length - 1; i >= 0; i--) {
      result[i] = stack.pop();
    }

    return result;
  }
}
