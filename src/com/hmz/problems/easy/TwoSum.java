package com.hmz.problems.easy;

import com.hmz.test.Tester;

import java.util.*;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * */
public class TwoSum extends Tester {

    public TwoSum(int testIndex) {
        super(testIndex);
    }

    void test1() {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3,3}, 6)));
    }

    void test2() {
        System.out.println(Arrays.toString(twoSumEnhanced(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(twoSumEnhanced(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(twoSumEnhanced(new int[]{3,3}, 6)));
    }

    // Methods

    public int[] twoSum(int[] nums, int target) {
        int [] ret = new int[2];
        for(int i = 0 ; i < nums.length; i++) {
            for(int j = i + 1 ; j < nums.length; j++)
                if(nums[i] + nums[j] == target) {
                    ret[0] = i;
                    ret[1] = j;
                }
        }
        return ret;
    }

    public int[] twoSumEnhanced(int[] nums, int target) {
        int [] ret = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                ret[0] = map.get(complement);
                ret[1] = i;
                break;
            }
            else map.put(nums[i], i);
        }
        return ret;
    }

    // Endpoint

    public static void main(String[] args) {
        new TwoSum(2);
    }

}
