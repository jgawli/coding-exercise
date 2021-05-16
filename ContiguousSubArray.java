import java.util.*;

public class ContiguousSubArray {

    static int[] countSubarrays(int[] arr) {
        // Write your code here
        int [] outputArr = new int[arr.length];
        int lastIndex = arr.length;
        for (int i=0; i<arr.length; i++) {
            int numOfArrays = 1;
            for (int j = i-1; j>=0; j--) {
                if (arr[j] < arr[i]) {
                    numOfArrays++;
                    continue;
                }
                break;
            }

            for (int k = i+1; k<lastIndex; k++) {
                if (arr[k] < arr[i]) {
                    numOfArrays++;
                    continue;
                }
                break;
            }
            outputArr[i] = numOfArrays;
        }
        System.out.println("Input Array" + Arrays.toString(arr));
        System.out.println("Output Array" + Arrays.toString(outputArr));
        return outputArr;

    }

    public static void main(String[] args) {
        int[] test_1 = {3, 4, 1, 6, 2};
        int[] expected_1 = {1, 3, 1, 5, 1};
        int[] output_1 = countSubarrays(test_1);
        System.out.println(Arrays.equals(expected_1, output_1));

        int[] test_2 = {2, 4, 7, 1, 5, 3};
        int[] expected_2 = {1, 2, 6, 1, 3, 1};
        int[] output_2 = countSubarrays(test_2);
        System.out.println(Arrays.equals(expected_2, output_2));

    }
}
