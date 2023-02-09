package com.hmz.problems.easy;

import com.hmz.test.Tester;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 */
public class RansomNote extends Tester {

    public RansomNote(int testIndex) {
        super(testIndex);
    }

    void test1() {
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aab", "baa"));
    }

    void test2() {
        System.out.println(canConstructCompact("aa", "ab"));
        System.out.println(canConstructCompact("aab", "baa"));
    }

    // Methods

    /**
     * (Recommended)
     * (Way faster and readable solution)
     * Initialize an array with 26 length abcd......z
     * Start searching the magazine string and count the freq of every character and store value in the array
     * Loop the ransomNote and for every found character on the array subtract the counted value
     * If a counted value of a character reached less than 0 that means there is no more assets in the magazine and we can't construct the ransomNote
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] counts = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            counts[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--counts[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * (Unrecommended)
     * Less faster
     * Not very readable
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstructCompact(String ransomNote, String magazine) {
        int[] counts = new int[26];
        magazine.chars().forEach(c -> counts[c - 'a']++);
        return ransomNote.chars().allMatch(c -> --counts[c - 'a'] >= 0);
    }

    // Endpoint

    public static void main(String[] args) {
        new RansomNote(1);
    }
}
