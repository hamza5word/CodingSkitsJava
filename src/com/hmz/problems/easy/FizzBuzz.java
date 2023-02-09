package com.hmz.problems.easy;

import com.hmz.test.Tester;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return a string array answer (1-indexed) where:
 *
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i (as a string) if none of the above conditions are true.
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["1","2","Fizz"]
 * Example 2:
 *
 * Input: n = 5
 * Output: ["1","2","Fizz","4","Buzz"]
 * Example 3:
 *
 * Input: n = 15
 * Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 */
public class FizzBuzz extends Tester {

    public FizzBuzz(int testIndex) {
        super(testIndex);
    }

    void test1() {
        System.out.println(fizzBuzz(3));
        System.out.println(fizzBuzz(5));
        System.out.println(fizzBuzz(15));
    }

    void test2() {
        System.out.println(fizzBuzzV2(3));
        System.out.println(fizzBuzzV2(5));
        System.out.println(fizzBuzzV2(15));
    }

    // Methods

    public List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList<>();
        for(int i = 1; i<=n; i++) {
            StringBuilder b = new StringBuilder();
            if(i % 3 == 0) b.append("Fizz");
            if(i % 5 == 0) b.append("Buzz");
            if(b.length() == 0) b.append(i);
            ret.add(b.toString());
        }
        return ret;
    }

    /**
     * Fastest
     * Add all the i items
     * then loop starting from 3 with step of 3 : 3, 6, 9.... set every found value with Fizz
     * loop starting from 5 with step of 5 : 5, 10, 15.... set every found value with Buzz
     * loop starting from 15 with step of 15 : 15, 30, 45.... set every found value with FizzBuzz
     * @param n
     * @return
     */
    public List<String> fizzBuzzV2(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ans.add(String.valueOf(i));
        }
        for (int i = 3; i <= n; i += 3) {
            ans.set(i - 1, "Fizz");
        }
        for (int i = 5; i <= n; i += 5) {
            ans.set(i - 1, "Buzz");
        }
        for (int i = 15; i <= n; i += 15) {
            ans.set(i - 1, "FizzBuzz");
        }
        return ans;
    }

    // Endpoint

    public static void main(String[] args) {
        new FizzBuzz(2);
    }

}
