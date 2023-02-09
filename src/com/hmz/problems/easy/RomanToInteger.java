package com.hmz.problems.easy;

import com.hmz.test.Tester;

import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 *
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 *
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class RomanToInteger extends Tester {

    public RomanToInteger(int testIndex) {
        super(testIndex);
    }

    void test1() {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    void test2() {
        System.out.println(romanToIntV2("III"));
        System.out.println(romanToIntV2("LVIII"));
        System.out.println(romanToIntV2("MCMXCIV"));
    }

    void test3() {
        System.out.println(romanToIntV3("III"));
        System.out.println(romanToIntV3("LVIII"));
        System.out.println(romanToIntV3("MCMXCIV"));
    }

    // Methods

    /**
     * Maps based solution
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int ret = 0;
        Map<Character, Integer> romanDict = Map.of(
          'I', 1,
          'V', 5,
          'X', 10,
          'L', 50,
          'C', 100,
          'D', 500,
          'M', 1000
        );
        Map<Character, String> subtractExceptions = Map.of(
          'I', "VX",
          'X', "LC",
          'C', "DM"
        );
        int size = s.toCharArray().length;
        for(int i = 0; i<size; i++) {
            char c = s.charAt(i);
            if(subtractExceptions.containsKey(c) && i != size - 1) {
                char nextC = s.charAt(i+1);
                if(subtractExceptions.get(c).contains(nextC + "")) {
                    ret += romanDict.get(nextC) - romanDict.get(c);
                    i++;
                    continue;
                }
            }
            ret += romanDict.get(c);
        }
        return ret;
    }

    /**
     * --> MCMXCIV
     * Procedure (BEST)
     * --------------------------------------------------
     * V 5     4 x 5    = 20   <? 0    | ans + 5    = 5
     * I 1     4 x 1    = 4    <? 5    | ans - 1    = 4
     * C 100   4 x 100  = 400  <? 4    | ans + 100  = 104
     * X 10    4 x 10   = 40   <? 104  | ans - 10   = 94
     * M 1000  4 x 1000 = 4000 <? 94   | ans + 1000 = 1094
     * C 100   4 x 100  = 400  <? 1094 | ans - 100  = 994
     * M 1000  4 x 1000 = 4000 <? 994  | ans + 1000 = 1994
     * ---------------------------------------------------
     * @param s
     * @return
     */
    public int romanToIntV2(String s) {
        int ans = 0, num = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            switch(s.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            if (4 * num < ans) ans -= num;
            else ans += num;
        }
        return ans;
    }

    /**
     * Enhanced Map solution (SLOWER THAN FIRST)
     * Replace exceptions with literal representation IV => IIII...
     * @param s
     * @return
     */
    public int romanToIntV3(String s) {
        Map<Character, Integer> romanDict = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );
        s = s.replace("IV", "IIII").replace("IX", "VIIII");
        s = s.replace("XL", "XXXX").replace("XC", "LXXXX");
        s = s.replace("CD", "CCCC").replace("CM", "DCCCC");
        return s.chars().map(c -> romanDict.get((char) c)).sum();
    }

    // Endpoint

    public static void main(String[] args) {
        new RomanToInteger(3);
    }
}
