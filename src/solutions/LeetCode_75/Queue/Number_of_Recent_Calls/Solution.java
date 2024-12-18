// LeetCode Question: https://leetcode.com/problems/number-of-recent-calls

package solutions.LeetCode_75.Queue.Number_of_Recent_Calls;

import java.util.*;

class RecentCounter {
  private Queue<Integer> requests;

  public RecentCounter() {
    requests = new LinkedList<>();
  }

  public int ping(int t) {
    requests.offer(t);

    // Remove requests older than 3000 milliseconds
    while (requests.peek() < t - 3000) {
      requests.poll();
    }

    return requests.size();
  }
}

/**
 * Your RecentCounter object will be instantiated and called as such: RecentCounter obj = new
 * RecentCounter(); int param_1 = obj.ping(t);
 */
