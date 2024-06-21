package com.mark.codingtest.leetcode.editor.en;

import org.junit.jupiter.api.Test;

//Given two binary strings a and b, return their sum as a binary string. 
//
// 
// Example 1: 
// Input: a = "11", b = "1"
//Output: "100"
// 
// Example 2: 
// Input: a = "1010", b = "1011"
//Output: "10101"
// 
// 
// Constraints: 
//
// 
// 1 <= a.length, b.length <= 10⁴ 
// a and b consist only of '0' or '1' characters. 
// Each string does not contain leading zeros except for the zero itself. 
// 
//
// Related Topics Math String Bit Manipulation Simulation 👍 9366 👎 967


public class AddBinary_67 {

    @Test
    void test() {
        new Solution().addBinary("11", "1");
        new Solution().addBinary("1010", "1011");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            StringBuilder result = new StringBuilder();
            int i = a.length() - 1, j = b.length() - 1, carry = 0;

            while (i >= 0 || j >= 0) {
                int sum = carry;
                if (i >= 0) sum += a.charAt(i--) - '0';
                if (j >= 0) sum += b.charAt(j--) - '0';
                result.append(sum % 2);
                carry = sum / 2;
            }

            if (carry != 0) result.append(carry);

            return result.reverse().toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}