package com.finley.basic;

import com.sun.org.apache.xpath.internal.functions.FuncStringLength;

import java.util.Arrays;

public class SortTest {
    public Item[] arr = new Item[7];


    public SortTest() {
        Item it6 = new Item(4, null);
        Item it5 = new Item(2, it6);
        Item it4 = new Item(6, it5);
        Item it3 = new Item(7, it4);
        Item it2 = new Item(11, it3);
        Item it1 = new Item(12, it2);
        Item it0 = new Item(14, it1);
        arr[0] = it0;
        arr[1] = it1;
        arr[2] = it2;
        arr[3] = it3;
        arr[4] = it4;
        arr[5] = it5;
        arr[6] = it6;

    }


    public static void main(String[] args) {
        SortTest sortTest = new SortTest();
        int middle = getMiddleIndex(sortTest.arr);
        sort(sortTest.arr, middle);
        System.out.println(Arrays.toString(sortTest.arr));
    }

    public static void sort(Item[] arr, int middle) {
        Item temp = null;
        Item temp1 = null;
        int left = -1;
        int right = -1;
        for (int i = 0; i < middle - 1; i++) {
            if (arr[i].value > arr[middle].value) {
                temp = arr[i];
                left = i;
                break;
            }
        }

        for (int j = arr.length-1; j > middle; j--) {
            if (arr[j].value < arr[middle].value) {
                temp1 = arr[j];
                right = j;
                break;
            }
        }

        if (left != -1 && right != -1) {
            arr[left] = temp1;
            arr[right] = temp;
        }

        sort(arr, middle - 1);
        sort(arr, middle + 1);
    }

    public static int getMiddleIndex(Item[] arr) {
        int length = arr.length;
        return (length / 2);
    }


}
