package com.hmz.utils.sort;

import com.hmz.test.Tester;

import java.util.Arrays;

public class BubbleSort extends Tester {

    public BubbleSort(int testIndex) {
        super(testIndex);
    }

    public static void sort(int [] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = i + 1; j < array.length; j++) {
                if(array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    void test1() {
        int [] array = {5, 8, 6, 14, 10, 3, 90, 45, 19, 31, 1, 63, 16, 46, 26, 84, 11, 2, 36, 75, 51, 15, 47, 30, 0, 82};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        new BubbleSort(1);
    }


}
