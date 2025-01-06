// LeetCode Question: https://leetcode.com/problems/online-stock-span

package solutions.LeetCode_75.Monotonic_Stack.Online_Stock_Span;

import java.util.Stack;

class StockSpanner {
  private Stack<int[]> stack;

  public StockSpanner() {
    stack = new Stack<>(); // Store pairs of (price, span)
  }

  public int next(int price) {
    int span = 1;

    // Merge spans while the current price is greater than or equal to the top of the stack
    while (!stack.isEmpty() && stack.peek()[0] <= price) {
      span += stack.pop()[1];
    }

    stack.push(new int[] {price, span}); // Push the current price and span
    return span;
  }
}
