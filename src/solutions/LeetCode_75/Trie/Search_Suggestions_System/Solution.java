// LeetCode Question: https://leetcode.com/problems/search-suggestions-system

package solutions.LeetCode_75.Trie.Search_Suggestions_System;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    List<List<String>> result = new ArrayList<>();
    Arrays.sort(products); // Ensure products are sorted lexicographically

    String prefix = "";
    for (char c : searchWord.toCharArray()) {
      prefix += c; // Update prefix with the current character
      List<String> suggestions = new ArrayList<>();

      for (String product : products) {
        if (product.startsWith(prefix)) {
          suggestions.add(product);
        }
        if (suggestions.size() == 3) break; // Only keep top 3 suggestions
      }
      result.add(suggestions);
    }
    return result;
  }
}
