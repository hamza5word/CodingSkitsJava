package com.hmz.problems.medium;

import com.hmz.test.Tester;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Vector;


/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 */
public class LetterCombinationsPhoneNumber extends Tester {

    public LetterCombinationsPhoneNumber(int testIndex) {
        super(testIndex);
    }

    void test1() {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("2"));
        System.out.println(letterCombinations("239"));
        System.out.println(letterCombinations("2349"));
    }

    void test2() {

    }

    // Methods

    public List<String> letterCombinations(String digits) {
        List<String> ret = new Vector<>();
        if(digits.length() > 0) {
            Map<Character, List<String>> phoneMappings = Map.of(
                    '2', Arrays.asList("a", "b", "c"),
                    '3', Arrays.asList("d", "e", "f"),
                    '4', Arrays.asList("g", "h", "i"),
                    '5', Arrays.asList("j", "k", "l"),
                    '6', Arrays.asList("m", "n", "o"),
                    '7', Arrays.asList("p", "q", "r", "s"),
                    '8', Arrays.asList("t", "u", "v"),
                    '9', Arrays.asList("w", "x", "y", "z")
            );
            ret = phoneMappings.get(digits.charAt(0));
            if(digits.length() > 1) {
                for(int i = 1 ; i<digits.length(); i++) {
                    ret = getComb(ret, phoneMappings.get(digits.charAt(i)));
                }
            }
        }
        return ret;
    }

    public List<String> getComb(List<String> l1, List<String> l2) {
        List<String> comb = new Vector<>();
        l1.forEach(i -> l2.forEach(j -> comb.add(i + j)));
        return comb;
    }

    // Endpoint

    public static void main(String[] args) {
        new LetterCombinationsPhoneNumber(1);
    }
}
