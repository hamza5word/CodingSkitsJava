package com.hmz.problems.easy;

import com.hmz.test.Tester;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * */
public class LongestCommonPrefix extends Tester {

    public LongestCommonPrefix(int testIndex) {
        super(testIndex);
    }

    void test1() {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(longestCommonPrefix(new String[]{"ab","a"}));
    }

    // Methods

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        String prefix = strs[0];
        for(int i = 1; i< strs.length; i++) {
            prefix = recursivePrefixGet(strs[i], prefix);
        }
        return prefix;
    }

    public String recursivePrefixGet(String s, String prefix) {
        if(s.startsWith(prefix)) return prefix;
        else return recursivePrefixGet(s, prefix.substring(0, prefix.length() - 1));
    }

    // Endpoint

    public static void main(String[] args) {
        new LongestCommonPrefix(1);
    }

}
