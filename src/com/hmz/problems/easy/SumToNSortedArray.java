package com.hmz.problems.easy;

import com.hmz.test.Tester;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem Description :
 * We have an array [1, 2, 3, 9] and another [1, 3, 4, 4]
 * Our goal is to see if there is pair that equals to the target sum
 * in any of those arrays
 */
public class SumToNSortedArray extends Tester {

    public static final int TARGET_SUM = 8;
    public static final int[] array1 = {1, 2, 3, 9};
    public static final int[] array2 = {1, 3, 4, 4};

    public SumToNSortedArray(int testIndex) {
        super(testIndex);
    }

    /**
     * Solution 1 : Double for loop
     */
    void test1() {
        for(int i = 0; i < selected.length; i++) {
            for(int j = i + 1; j < selected.length; j++) {
                if(selected[i] + selected[j] == TARGET_SUM) {
                    System.out.println("[TRUE]");
                    return;
                }
            }
        }
        System.out.println("[FALSE]");
    }

    /**
     * Solution 2 : Binary search
     */
    void test2() {
        for(int i = 1; i < selected.length; i++) {
            if(ArrayS.binarySearch(selected, 1, selected.length - 1, 8 - selected[i]) != -1) {
                System.out.println("[TRUE]");
                return;
            }
        }
        System.out.println("[FALSE]");
    }

    /**
     * Solution 3 : Fixing two indexes at bounds and moving up or down
     * If the sum in lower than the target we move up from the left
     * If the sum is larger than the target we move down from the right
     */
    void test3() {
        if(bidirectionalSum(selected)) {
            System.out.println("[TRUE]");
        }
        else System.out.println("[FALSE]");
    }

    /**
     * Solution 3 but with recursive method
     */
    void test4() {
        if(bidirectionalSumR(selected, 0, selected.length-1)) {
            System.out.println("[TRUE]");
        }
        else System.out.println("[FALSE]");
    }

    /**
     * Solution 4 : Using Hashset to store all previous complements (for non sorted case)
     */
    void test5() {
        if(complementedSum(selected)) {
            System.out.println("[TRUE]");
        }
        else System.out.println("[FALSE]");
    }

    // Methods

    public static boolean bidirectionalSum(int [] intArray) {
        int low = 0;
        int high = intArray.length - 1;
        while (high > low) {
            int sum = intArray[low] + intArray[high];
            if(sum == TARGET_SUM) return true;
            else if(sum < TARGET_SUM) low++;
            else high--;
        }
        return false;
    }

    public static boolean bidirectionalSumR(int [] intArray, int low, int high) {
        if(high > low) {
            int sum = intArray[low] + intArray[high];
            if(sum == TARGET_SUM) return true;
            else if(sum < TARGET_SUM) return bidirectionalSumR(intArray, low+1, high);
            else return bidirectionalSumR(intArray, low, high-1);
        }
        return false;
    }

    public static boolean complementedSum(int [] intArray) {
        Set<Integer> storedCmp = new HashSet<>();
        for(int value : intArray) {
            if(storedCmp.contains(TARGET_SUM - value)) return true;
            else storedCmp.add(TARGET_SUM - value);
        }
        return false;
    }

    // Endpoint

    public static final int[] selected = array1;
    public static void main(String[] args) {
        new SumToNSortedArray(5);
    }

}
