package com.mark.codingtest.leetcode.editor.en;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

//Seven different symbols represent Roman numerals with the following values: 
//
// 
// 
// 
// Symbol 
// Value 
// 
// 
// 
// 
// I 
// 1 
// 
// 
// V 
// 5 
// 
// 
// X 
// 10 
// 
// 
// L 
// 50 
// 
// 
// C 
// 100 
// 
// 
// D 
// 500 
// 
// 
// M 
// 1000 
// 
// 
// 
//
// Roman numerals are formed by appending the conversions of decimal place 
//values from highest to lowest. Converting a decimal place value into a Roman numeral 
//has the following rules: 
//
// 
// If the value does not start with 4 or 9, select the symbol of the maximal 
//value that can be subtracted from the input, append that symbol to the result, 
//subtract its value, and convert the remainder to a Roman numeral. 
// If the value starts with 4 or 9 use the subtractive form representing one 
//symbol subtracted from the following symbol, for example, 4 is 1 (I) less than 5 (
//V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following subtractive forms 
//are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM). 
// Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times 
//to represent multiples of 10. You cannot append 5 (V), 50 (L), or 500 (D) 
//multiple times. If you need to append a symbol 4 times use the subtractive form. 
// 
//
// Given an integer, convert it to a Roman numeral. 
//
// 
// Example 1: 
//
// 
// Input: num = 3749 
// 
//
// Output: "MMMDCCXLIX" 
//
// Explanation: 
//
// 
//3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
// 700 = DCC as 500 (D) + 100 (C) + 100 (C)
//  40 = XL as 10 (X) less of 50 (L)
//   9 = IX as 1 (I) less of 10 (X)
//Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on 
//decimal places
// 
//
//
// Example 2: 
//
// 
// Input: num = 58 
// 
//
// Output: "LVIII" 
//
// Explanation: 
//
// 
//50 = L
// 8 = VIII
// 
//
//
// Example 3: 
//
// 
// Input: num = 1994 
// 
//
// Output: "MCMXCIV" 
//
// Explanation: 
//
// 
//1000 = M
// 900 = CM
//  90 = XC
//   4 = IV
// 
//
//
// 
// Constraints: 
//
// 
// 1 <= num <= 3999 
// 
//
// Related Topics Hash Table Math String 👍 7311 👎 5579


@Slf4j
public class IntegerToRoman_12 {

    @Test
    void test() {
        log.info("result: {}", new Solution().intToRoman(1994));
    }    

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String intToRoman(int num) {
            // 로마 숫자와 그에 해당하는 값 배열
            String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

            StringBuilder roman = new StringBuilder();

            for (int i = 0; i < values.length; i++) {
                // 현재 숫자(num)가 현재 값보다 크거나 같은 동안 반복
                while (num >= values[i]) {
                    roman.append(symbols[i]); // 로마 기호 추가
                    num -= values[i];         // 숫자에서 값 빼기
                }
                // 숫자가 0이 되면 종료
                if(num == 0) break;
            }

            return roman.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}