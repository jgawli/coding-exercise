import java.util.*;
// Add any extra import statements you may need here


class Main {

  // Add any helper functions you may need here
  int getAlphaIndex(int alphaIdx, int rotationFactor) {
    int idx= alphaIdx + rotationFactor;
          if (idx>25) {
            if (rotationFactor > 25) {
              idx = rotationFactor%26;              
            } else {
              idx = rotationFactor;
            }
          }
    return idx;
  }
  

  String rotationalCipher(String input, int rotationFactor) {
    // Write your code here
      char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
      char[] capsAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
      char[] inputArray = input.toCharArray();
     StringBuilder output = new StringBuilder();
      
      for (int i=0; i<inputArray.length; i++) {
        char c = inputArray[i];
                    
        if (!Character.isLetterOrDigit(c)) {
          output.append(c);
        }
          if (Character.isDigit(c)) {
            int digit = Character.getNumericValue(c) + rotationFactor;
            String s = String.valueOf(digit);
            output.append(s.charAt(0));
          }
        if (Character.isUpperCase(c)) {
          int capsAlphaIdx = new String(capsAlpha).indexOf(c);
          output.append(capsAlpha[getAlphaIndex(capsAlphaIdx, rotationFactor)]);
          
        }
        if (Character.isLowerCase(c)) {
          int alphaIdx = new String(alpha).indexOf(c);
          output.append(alpha[getAlphaIndex(alphaIdx, rotationFactor)]);
          
        }
      }
    return output.toString();
    
    public void run() {
    String input_1 = "All-convoYs-9-be:Alert1.";
    int rotationFactor_1 = 4;
    String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
    String output_1 = rotationalCipher(input_1, rotationFactor_1);
    check(expected_1, output_1);

    String input_2 = "abcdZXYzxy-999.@";
    int rotationFactor_2 = 200;
    String expected_2 = "stuvRPQrpq-999.@";
    String output_2 = rotationalCipher(input_2, rotationFactor_2);
    check(expected_2, output_2);

    // Add your own test cases here
    
  }
  
  public static void main(String[] args) {
    new Main().run();
  }
    
  }
