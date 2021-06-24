package com.sparters.config;

import java.util.*;
// Add any extra import statements you may need here


class BalancedSplit {

    // Add any helper functions you may need here

    boolean getSumOfArray(int mid, int[] arr) {
        Arrays.sort((arr));
        int[] leftArr = Arrays.copyOfRange(arr, 0, mid + 1);
        int[] rightArr = getRightArr(mid, arr);


        int leftSum = Arrays.stream(leftArr).sum();
        int rightSum = Arrays.stream(rightArr).sum();

        return leftSum == rightSum;
    }

    int[] getRightArr(int mid, int[] arr) {
        if (arr.length % 2 == 0) {
            return Arrays.copyOfRange(arr, mid + 1, arr.length);
        } else {
            return Arrays.copyOfRange(arr, mid + 2, arr.length);
        }
    }

    boolean balancedSplitExists(int[] arr) {
        // Write your code here

        int mid = arr.length/2;
        int[] rightArr = getRightArr(mid, arr);

        for (int i = 0; i < rightArr.length; i++) {
            if (getSumOfArray(mid, arr)) {
                return true;
            } else {
                mid = mid + 1;
            }
        }

        return false;

    }



    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[" + str + "]");
    }

    public void run() {
        int arr_1[] = {2, 1, 2, 5};
        boolean expected_1 = true;
        boolean output_1 = balancedSplitExists(arr_1);
        check(expected_1, output_1);

        int arr_2[] = {3, 6, 3, 4, 4};
        boolean expected_2 = false;
        boolean output_2 = balancedSplitExists(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new BalancedSplit().run();
    }
}
