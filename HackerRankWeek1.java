public class HackerRankWeek1 {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        double positiveCount = 0;
        double negativeCount = 0;
        double zeroCount = 0;
        int size = arr.size();

        for (Integer value : arr) {
            if (value > 0) {
                positiveCount++;
            } else if (value < 0) {
                negativeCount++;
            } else zeroCount++;
        }

        System.out.printf("%.6f", positiveCount/size);
        System.out.printf("%.6f%n", negativeCount/size);
        System.out.printf("%.6f%n", zeroCount/size);

    }
  
  public static String timeConversion(String s) {
        // Write your code here
        String hour = s.substring(0, 2);
        String min = s.substring(3, 5);
        String sec = s.substring(6, 8);
        char amPm = s.charAt(8);
        System.out.println("ampm is: " + amPm);

        //String outputHr = 00;
        //String outputMin = 00;
        //String outputSec = 00;

        if (amPm == 'A') {
            if (hour.equals("12")) {
                if (min.equals("00") && sec.equals("00")) {
                    return "00:00:00";
                } else {
                    return "00:"+min+":"+sec;
                }
            }
        }

        if (amPm == 'P') {
            int hr = Integer.parseInt(hour);
            System.out.println("Hour is: " + hr);
            if (hr >= 1 && hr < 12) {
                String outputHr = String.valueOf(hr + 12);
                return outputHr+":"+min+":"+sec;
            }
        }

        return hour+":"+min+":"+sec;

    }

    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();

        int uniqueInt;
        for (Integer i : a) {
            Integer value = map.get(i);
            if (map.containsKey(i)) {
                map.remove(i);
            } else {
                map.put(i, 1);
            }
        }
        uniqueInt = (int) map.keySet().toArray()[0];
        return uniqueInt;

    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int rowCnt = 0;
        int sizeCnt = 1;
        int leftDiagCnt = 0;
        int rightDiagCnt = 0;
        for (List<Integer> i: arr) {
            int size = i.size();
            if (size == 1) {
                continue;
            }
            int leftMostInt = i.get(rowCnt);
            leftDiagCnt = leftDiagCnt + leftMostInt;

            int rightMostInt = i.get(size - sizeCnt);
            rightDiagCnt = rightDiagCnt + rightMostInt;
            sizeCnt++;
            rowCnt++;
        }
        int diff = leftDiagCnt - rightDiagCnt;
        return Math.abs(diff);
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        int[] frequencyArr = new int[100];
        for (Integer val : arr) {
            frequencyArr[val] = frequencyArr[val] + 1;

        }
        for (int i = 0; i < frequencyArr.length; i++) {
            result.add(frequencyArr[i]);
        }
        return result;

    }

    public static int findMedian(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        int median = 0;
        int middle = Math.abs(arr.size()/2);
        if (arr.size() % 2 == 0) {
            median = (arr.get(middle) + arr.get(middle-1))/2;
        } else {
            median = arr.get(middle)/2;
        }
        return median;

    }
}
