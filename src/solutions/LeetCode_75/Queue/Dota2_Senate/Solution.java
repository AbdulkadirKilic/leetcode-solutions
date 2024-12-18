// LeetCode Question: https://leetcode.com/problems/dota2-senate

package solutions.LeetCode_75.Queue.Dota2_Senate;

import java.util.*;

class Solution {
  public String predictPartyVictory(String senate) {
    Queue<Integer> radiant = new LinkedList<>();
    Queue<Integer> dire = new LinkedList<>();
    int n = senate.length();

    // Populate the queues with indexes of Radiant (R) and Dire (D) senators
    for (int i = 0; i < n; i++) {
      if (senate.charAt(i) == 'R') {
        radiant.offer(i);
      } else {
        dire.offer(i);
      }
    }

    // Simulation of the banning process
    while (!radiant.isEmpty() && !dire.isEmpty()) {
      int rIndex = radiant.poll();
      int dIndex = dire.poll();

      if (rIndex < dIndex) {
        radiant.offer(rIndex + n); // Radiant wins this round
      } else {
        dire.offer(dIndex + n); // Dire wins this round
      }
    }

    return radiant.isEmpty() ? "Dire" : "Radiant";
  }
}
