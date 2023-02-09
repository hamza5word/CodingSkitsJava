package com.hmz.problems.hard;

import com.hmz.test.Tester;

import java.util.*;


/**
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.​​​​
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 */
public class RegExMatcher extends Tester {

    public RegExMatcher(int testIndex) {
        super(testIndex);
    }

    void test1() {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
    }

    void test2() {

    }

    // Methods

    public boolean isMatch(String s, String p) {
        boolean[] match = new boolean[s.length()+1];
        Arrays.fill(match, false);
        match[s.length()] = true;
        for(int i=p.length()-1;i>=0;i--){
            if(p.charAt(i)=='*'){
                for(int j=s.length()-1;j>=0;j--)    match[j] = match[j]||match[j+1]&&(p.charAt(i-1)=='.'||s.charAt(j)==p.charAt(i-1));
                i--;
            }
            else{
                for(int j=0;j<s.length();j++)   match[j] = match[j+1]&&(p.charAt(i)=='.'||p.charAt(i)==s.charAt(j));
                match[s.length()] = false;
            }
        }
        return match[0];
    }

    // Endpoint

    public static void main(String[] args) {
        new RegExMatcher(1);
    }
}
