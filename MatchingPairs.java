package com.sparters.config;

public class MatchingPairs {

    int matchingPairs(String s, String t) {

        if (s.equals(t)) {
            return s.length() - 2;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        char[] oArr = sArr;
        char unmatchedChar1 = ' ';
        int unmatchedIdx1 = 0;
        char unmatchedChar2 = ' ';
        int unmatchedIdx2 = 0;
        for (int i=0; i<sArr.length; i++) {
            if (sArr[i] != tArr[i]) {
                if (unmatchedChar1 != ' ') {
                    unmatchedChar2 = sArr[i];
                    unmatchedIdx2 = i;
                } else {
                    unmatchedChar1 = sArr[i];
                    unmatchedIdx1 = i;
                }
            }
        }
        oArr[unmatchedIdx1] = unmatchedChar2;
        oArr[unmatchedIdx2] = unmatchedChar1;

        System.out.println("Output Array" + oArr.toString());

        int matchingCount = 0;
        for (int i=0; i<sArr.length; i++) {
            if (oArr[i] == tArr[i]) {
                matchingCount++;
            }
        }
        return matchingCount;
    }

    void run() {
        String s_1 = "abcde";
        String t_1 = "adcbe";
        int expected_1 = 5;
        int output_1 = matchingPairs(s_1, t_1);
        boolean test1 = expected_1 == output_1;
        System.out.println("Test case 1 passed " + test1);

        String s_2 = "abcd";
        String t_2 = "abcd";
        int expected_2 = 2;
        int output_2 = matchingPairs(s_2, t_2);
        boolean test2 = expected_2 == output_2;
        System.out.println("Test case 2 passed " + test2);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new MatchingPairs().run();
    }
}
