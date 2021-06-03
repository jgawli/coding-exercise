import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlowSums {

    int getTotalTime(int[] arr) {
        // Write your code here
        List<Integer> costList = new ArrayList();
        int previousCost = 0;
        Arrays.sort(arr);
        int arrLastIndex = arr.length - 1;
        System.out.println("sorted array " + Arrays.toString(arr));
        System.out.println("first index " + arrLastIndex);
        for (int i = arrLastIndex; i == 0; i--) {
            int cost = 0;
            if (i == arrLastIndex) {
                cost = arr[arrLastIndex] + arr[arrLastIndex-1];
                previousCost = cost;
            } else {
                cost = previousCost + arr[i-2];
                previousCost = cost;
            }

            costList.add(cost);
            System.out.println("cost at index i" + cost);

        }

        int totalCost = 0;
        for (Integer cost: costList) {
            totalCost = totalCost + cost;
        }

        System.out.println("total cost " + totalCost);
        return totalCost;
    }

    void run() {
        int[] arr_1 = {4, 2, 1, 3};
        int expected_1 = 26;
        int output_1 = getTotalTime(arr_1);
        boolean test1 = expected_1 == output_1;
        System.out.println("Test case 1 passed " + test1);

        int[] arr_2 = {2, 3, 9, 8, 4};
        int expected_2 = 88;
        int output_2 = getTotalTime(arr_2);
        boolean test2 = expected_2 == output_2;
        System.out.println("Test case 2 passed " + test2);

    }
    public static void main(String[] args) {
        new MatchingPairs().run();
    }
}
