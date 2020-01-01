package week1101;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Week01Test {
    private Week01 week01 = new Week01();

    /**
     * See https://www.hackerrank.com/challenges/solve-me-first/problem
     */
    @Test
    public void solveMeFirstTest() {
        int a = 2;
        int b = 3;
        int expected = 5;

        assertThat(week01.solveMeFirst(a,b), is(expected));
    }

    /**
     * See https://www.hackerrank.com/challenges/compare-the-triplets/problem
     */
    @Test
    public void compareTheTripletsTest01() {
        List<Integer> a = Arrays.asList(5,6,7);
        List<Integer> b = Arrays.asList(3,6,10);
        List<Integer> expected = Arrays.asList(1,1);

        compareTheTripletsComparator(expected, week01.compareTheTriplets(a, b));
    }

    /**
     * See https://www.hackerrank.com/challenges/compare-the-triplets/problem
     */
    @Test
    public void compareTheTripletsTest02() {
        List<Integer> a = Arrays.asList(17,28,30);
        List<Integer> b = Arrays.asList(99,16,8);
        List<Integer> expected = Arrays.asList(2,1);

        compareTheTripletsComparator(expected, week01.compareTheTriplets(a, b));
    }

    private void compareTheTripletsComparator(List<Integer> expected, List<Integer> result) {
        assertThat(result.size(), is(expected.size()));
        for (int idx = 0 ; idx < expected.size() ; idx ++) {
            assertThat(result.get(idx), is(expected.get(idx)));
        }
    }

    /**
     * See https://www.hackerrank.com/challenges/a-very-big-sum/problem
     */
    @Test
    public void aVeryBigSumTest() {
        long[] ar = new long[] {1000000001, 1000000002, 1000000003, 1000000004, 1000000005};
        long expected = 5000000015L;

        assertThat(week01.aVeryBigSum(ar), is(expected));
    }

    /**
     * See https://www.hackerrank.com/challenges/diagonal-difference/problem
     */
    @Test
    public void diagonalDifference() {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(11,2,4));
        arr.add(Arrays.asList(4,5,6));
        arr.add(Arrays.asList(10,8,-12));

        int expected = 15;

        assertThat(week01.diagonalDifference(arr), is(expected));
    }

    /**
     * See https://www.hackerrank.com/challenges/plus-minus/problem
     */
    @Test
    public void plusMinusTest(){
        int[] arr = new int[] {-4, 3, -9, 0, 4, 1};
        week01.plusMinus(arr);
    }

    /**
     * See https://www.hackerrank.com/challenges/staircase/problem
     */
    @Test
    public void stairCaseTest() {
        int n = 6;
        week01.stairCase(n);
    }

    /**
     * See https://www.hackerrank.com/challenges/mini-max-sum/problem
     */
    @Test
    public void minMaxSumTest() {
        int[] arr = new int[] {1,2,3,4,5};
        week01.minMaxSum(arr);
    }

    /**
     * See https://www.hackerrank.com/challenges/birthday-cake-candles/problem
     */
    @Test
    public void birthdayCakeCandlesTest() {
        int[] case01 = new int[] {3,2,1,3};
        int expected01 = 2;

        int[] case02 = new int[] {3,2,5,5,1,3,4,5};
        int expected02 = 3;

        assertThat(week01.birthdayCakeCandles(case01), is(expected01));
        assertThat(week01.birthdayCakeCandles(case02), is(expected02));
    }

    /**
     * See https://www.hackerrank.com/challenges/time-conversion/problem
     */
    @Test
    public void timeConversion() {
        String s = "07:05:45PM";
        String expected = "19:05:45";

        String result = week01.timeConversion(s);
        assertThat(result, is(expected));
    }

    /**
     * See https://www.hackerrank.com/challenges/grading/problem
     */
    @Test
    public void roundConversion() {
        List<Integer> a = Arrays.asList(4,73,67,38,33);
        List<Integer> expected = Arrays.asList(75,67,40,33);

        List<Integer> result = week01.roundConversion(a);

        compareTheTripletsComparator(expected, result);
    }

}