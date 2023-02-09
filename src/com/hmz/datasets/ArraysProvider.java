package com.hmz.datasets;

import java.util.Random;

public class ArraysProvider {

    public static int[] intArray = new int[25000000];

    static {
        for(int i = 0; i < intArray.length; i++) {
            intArray[i] = (int) Math.floor(new Random().nextInt(8));
        }
    }

}
