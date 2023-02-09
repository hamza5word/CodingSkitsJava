package com.hmz.problems.medium;

import com.hmz.test.Tester;

import java.util.*;


/**
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringNRC extends Tester {

    public LongestSubstringNRC(int testIndex) {
        super(testIndex);
    }

    void test1() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    void test2() {

    }

    // Methods

    public int lengthOfLongestSubstring(String s) {
        int maximum_length = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i)))
            {
                start = Math.max(start, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            maximum_length = Math.max(maximum_length, i-start + 1);
        }
        return maximum_length;
    }

    // Endpoint

    public static void main(String[] args) {
        new LongestSubstringNRC(1);
    }
}
