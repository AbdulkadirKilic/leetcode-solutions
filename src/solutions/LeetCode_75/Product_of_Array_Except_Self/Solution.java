// LeetCode Question: https://leetcode.com/problems/product-of-array-except-self

package solutions.LeetCode_75.Product_of_Array_Except_Self;

class Solution {
  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];

    // Compute the prefix products
    result[0] = 1;
    for (int i = 1; i < n; i++) {
      result[i] = result[i - 1] * nums[i - 1];
    }

    // Compute the suffix products and multiply with prefix products
    int suffixProduct = 1;
    for (int i = n - 1; i >= 0; i--) {
      result[i] *= suffixProduct;
      suffixProduct *= nums[i];
    }

    return result;
  }
}
