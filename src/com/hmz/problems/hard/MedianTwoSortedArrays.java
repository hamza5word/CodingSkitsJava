package com.hmz.problems.hard;

import com.hmz.test.Tester;

import java.util.Arrays;


/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class MedianTwoSortedArrays extends Tester {

    public MedianTwoSortedArrays(int testIndex) {
        super(testIndex);
    }

    void test1() {
        int [] nums1 = {1, 3};
        int [] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    void test2() {
        int [] nums1 = {1, 2};
        int [] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    // Methods

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length + nums2.length];
        int j = 0;
        for(int i = 0; i< merge.length; i++) {
            if(i < nums1.length) merge[i] = nums1[i];
            else merge[i] = nums2[j++];
        }
        Arrays.sort(merge);
        return findMedian(merge);
    }

    public double findMedian(int [] array) {
        int mid = array.length / 2;
        if(array.length % 2 != 0) return array[mid];
        else {
            double value = array[mid - 1] + array[mid];
            return value/2;
        }
    }

    // Endpoint

    public static void main(String[] args) {
        new MedianTwoSortedArrays(2);
    }
}
