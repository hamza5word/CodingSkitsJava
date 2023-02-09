package com.hmz.utils.sort;

import com.hmz.test.Tester;

import java.util.Arrays;

public class InsertionSort extends Tester {

    public InsertionSort(int testIndex) {
        super(testIndex);
    }

    public static void sort(int [] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    void test1() {
        int [] array = {5, 8, 6, 14, 10, 3, 90, 45, 19, 31, 1, 63, 16, 46, 26, 84, 11, 2, 36, 75, 51, 15, 47, 30, 0, 82};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        new InsertionSort(1);
    }


}
