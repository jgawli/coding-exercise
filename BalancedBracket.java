package com.sparters.config;

import java.util.Stack;
// Add any extra import statements you may need here


class BalancedBracket {

    // Add any helper functions you may need here

    boolean isBalanced(String s) {
        Stack<Character> charStack = new Stack<>();
        boolean balanced = false;
        for (int i =0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                charStack.push(s.charAt(i));
            } else if (s.charAt(i) == '}' && charStack.peek() == '{') {
                charStack.pop();
                balanced = true;
            } else if (s.charAt(i) == ']' && charStack.peek() == '[') {
                charStack.pop();
                balanced = true;
            } else if (s.charAt(i) == ')' && charStack.peek() == '(') {
                charStack.pop();
                balanced = true;
            } else {
                balanced = false;
                return balanced;
            }
        }
        return balanced;
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
        String s_1 = "{[(])}";
        boolean expected_1 = false;
        boolean output_1 = isBalanced(s_1);
        check(expected_1, output_1);

        String s_2 = "{{[[(())]]}}";
        boolean expected_2 = true;
        boolean output_2 = isBalanced(s_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new BalancedBracket().run();
    }
}
