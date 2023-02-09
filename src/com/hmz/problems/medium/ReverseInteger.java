package com.hmz.problems.medium;

import com.hmz.test.Tester;
import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.Map;


/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 */
public class ReverseInteger extends Tester {

    public ReverseInteger(int testIndex) {
        super(testIndex);
    }

    void test1() {
        System.out.println(reverse(123));
        System.out.println(reverse(-321));
        System.out.println(reverse(120));
        System.out.println(reverse(1534236469));
    }

    void test2() {

    }

    // Methods

    public int reverse(int x) {
        long ret = 0;
        while (x != 0) {
            int remaining = x % 10;
            ret = ret * 10 + remaining;
            x /= 10;
        }
        if(ret < Integer.MIN_VALUE || ret > Integer.MAX_VALUE) return 0;
        return (int)ret;
    }

    // Endpoint

    public static void main(String[] args) {
        new ReverseInteger(1);
    }
}
