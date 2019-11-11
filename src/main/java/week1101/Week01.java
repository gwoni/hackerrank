package week1101;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Week01 {

    public int solveMeFirst(int a, int b) {
        return a + b;
    }

    public List<Integer> compareTheTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> result = Arrays.asList(0, 0);

        for (int idx = 0; idx < a.size(); idx++) {
            if (a.get(idx) > b.get(idx))
                result.set(0, result.get(0) + 1);
            else if (a.get(idx) < b.get(idx))
                result.set(1, result.get(1) + 1);
        }

        return result;
    }

    public long aVeryBigSum(long[] ar) {
        long result = 0;
        for (long item : ar) {
            result += item;
        }
        return result;
    }

    public int diagonalDifference(List<List<Integer>> arr) {
        int sizeMax = arr.size() - 1;
        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;
        for (int rowIdx = 0; rowIdx < arr.size(); rowIdx++) {
            primaryDiagonal += arr.get(rowIdx).get(rowIdx);
            secondaryDiagonal += arr.get(rowIdx).get(sizeMax - rowIdx);
        }
        return Math.abs(primaryDiagonal - secondaryDiagonal);
    }

    public void plusMinus(int[] arr) {
        int plusCount = 0;
        int minusCount = 0;
        int zeroCount = 0;
        int size = arr.length;

        for (int item :
                arr) {
            if (item > 0)
                plusCount ++;
            else if (item == 0)
                zeroCount ++;
            else
                minusCount ++;
        }

        printResult(plusCount, size);
        printResult(minusCount, size);
        printResult(zeroCount, size);
    }

    private void printResult(int count, int size) {
        System.out.println(String.format("%.6f", Double.valueOf(count) / Double.valueOf(size)));
    }

    public void stairCase(int n) {
        StringBuilder fullString = new StringBuilder();
        for (int idx = 0 ; idx < n ; idx ++) {
            fullString.append("#");
        }

        for (int idx = 0 ; idx < n; idx ++) {
            String format ="%" + String.valueOf(n) + "." + String.valueOf(idx + 1) + "s";
            System.out.println(String.format(format, fullString.toString()));
        }
    }

    public void minMaxSum(int[] arr) {
        long totalSum = 0;
        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (minValue > value) minValue = value;
            if (maxValue < value) maxValue = value;
            totalSum += value;
        }

        System.out.print(String.format("%d %d", totalSum - maxValue, totalSum - minValue));
    }

    public int birthdayCakeCandles(int[] ar) {
        int height = 0;
        int tallestCandeles = 0;

        for (int value : ar) {
            if (height > value) continue;
            if (height < value) {
                height = value;
                tallestCandeles = 0;
            }
            tallestCandeles ++;
        }
        return tallestCandeles;
    }

    public String timeConversion(String s) {
        SimpleDateFormat dt = new SimpleDateFormat("hh:mm:ssaa", Locale.US);
        Date date = null;
        try {
            date = dt.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat dt1 = new SimpleDateFormat("HH:mm:ss");
        return dt1.format(date).toString();
    }
}
