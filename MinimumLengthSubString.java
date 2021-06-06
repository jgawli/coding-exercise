import java.io.*; 
import java.util.*;
// Add any extra import statements you may need here


class MinimumLengthSubString {

  // Add any helper functions you may need here
  

  int minLengthSubstring(String s, String t) {
    // Write your code here
    char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Map<Integer, Character> tMap = new HashMap<>();
        Map<Integer, Character> sMap = new HashMap<>();

        for (int i=0; i<tArr.length; i++) {
            tMap.put(i, tArr[i]);
        }
        System.out.println("tMap values is " + tMap.values());

        for (int i=0; i<sArr.length; i++) {
            if (tMap.containsValue(sArr[i])) {
                sMap.put(i, sArr[i]);
            }
        }
        System.out.println("sMap values is " + sMap.values());
        for (int i=0; i<tArr.length; i++) {
            int finalI = i;
            long charCountInSArr = s.chars().filter(ch -> ch == tArr[finalI]).count();
            long charCountInTArr = t.chars().filter(ch -> ch == tArr[finalI]).count();
            if (charCountInSArr != charCountInTArr) {
                return -1;
            }
        }

        Map<Integer, Character> sortedSMap = new TreeMap<>(sMap);
        Integer firstKey = ((TreeMap<Integer, Character>) sortedSMap).firstKey();
        Integer lastKey = ((TreeMap<Integer, Character>) sortedSMap).lastKey();
        String minimumLengthStr = s.substring(firstKey, lastKey+1);

        System.out.println("minimumLengthStr is " + minimumLengthStr);
        
        return minimumLengthStr.length();
  }











  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;
  void check(int expected, int output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printInteger(expected); 
      System.out.print(" Your output: ");
      printInteger(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printInteger(int n) {
    System.out.print("[" + n + "]");
  }
  public void run() throws IOException {
    String s_1 = "dcbefebce";
    String t_1 = "fd";
    int expected_1 = 5;
    int output_1 = minLengthSubstring(s_1, t_1);
    check(expected_1, output_1);

    String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
    String t_2 = "cbccfafebccdccebdd";
    int expected_2 = -1;
    int output_2 = minLengthSubstring(s_2, t_2);
    check(expected_2, output_2);

    // Add your own test cases here
    
  }
  public static void main(String[] args) throws IOException {
    new Main().run();
  }
}
