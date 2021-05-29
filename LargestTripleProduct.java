import java.io.*; 
import java.util.*;
// Add any extra import statements you may need here


class Main {

  // Add any helper functions you may need here
  

  int[] findMaxProduct(int[] arr) {
    // Write your code here
    
    int[] outputArr = new int[arr.length];
    outputArr[0] = -1;
    outputArr[1] = -1;
    outputArr[2] = arr[0] * arr[1] * arr[2];
    int[] sortedArr = {arr[0], arr[1], arr[2]};
    Arrays.sort(sortedArr);
    int max1 = sortedArr[0];
    int max2 = sortedArr[1];
    int max3 = sortedArr[2];
    
    for (int i = 3; i < arr.length; i++) {
      if (arr[i] > max3) {
        max1 = max2;
        max2 = max3;
        max3 = arr[i];
      } else if (arr[i] > max2) {
        max1 = max2;
        max2 = arr[i];
      } else if (arr[i] > max1) {
        max1 = arr[i];
      }
        outputArr[i] = max1 * max2 * max3;
      
    }
    return outputArr;
  }
}
