package com.hmz.utils.search;

public class ArraySearch {

    public static int binarySearch(int[] intArray, int low, int high, int key){
        //if array is in order then perform binary search on the array
        if (high>=low){
            //calculate mid
            int mid = low + (high - low)/2;
            //if key =intArray[mid] return mid
            if (intArray[mid] == key){
                return mid;
            }
            //if intArray[mid] > key then key is in left half of array
            if (intArray[mid] > key){
                return binarySearch(intArray, low, mid-1, key);//recursively search for key
            }else       //key is in right half of the array
            {
                return binarySearch(intArray, mid+1, high, key);//recursively search for key
            }
        }
        return -1;
    }

}
