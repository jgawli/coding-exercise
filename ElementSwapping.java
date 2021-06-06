package com.sparters.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElementSwapping {

    int[] findMinArray(int[] arr, int k) {
        // Write your code here

        for (int i = k; i == 1; i--) {
            int value1 = arr[i-1];
            int value2 = arr[i];

            System.out.println("value at first Idx " + value1);
            System.out.println("value at second Idx " + value2);

            arr[i-1] = value2;
            arr[i] = value1;
            System.out.println("output arr after " + k + " iteration " + Arrays.toString(arr));

        }

        System.out.println("output arr after " + Arrays.toString(arr));
        return arr;
    }

    void run() {
        int n_1 = 3, k_1 = 2;
        int[] arr_1 = {5, 3, 1};
        int[] expected_1 = {1, 5, 3};
        int[] output_1 = findMinArray(arr_1,k_1);
        boolean test1 = expected_1 == output_1;
        System.out.println("Test case 1 passed " + test1);

        int n_2 = 5, k_2 = 3;
        int[] arr_2 = {8, 9, 11, 2, 1};
        int[] expected_2 = {2, 8, 9, 11, 1};
        int[] output_2 = findMinArray(arr_2,k_2);
        boolean test2 = expected_2 == output_2;
        System.out.println("Test case 2 passed " + test2);

    }

    public static void main(String[] args) {
        new MatchingPairs().run();
    }
}
