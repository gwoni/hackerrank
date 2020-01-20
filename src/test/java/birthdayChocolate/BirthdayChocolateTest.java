package birthdayChocolate;

import birthdayChoocolate.BirthdayChocolate;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BirthdayChocolateTest {
    /**
     * https://www.hackerrank.com/challenges/the-birthday-bar/problem
     * Birthday Chocolate
     *
     * 초콜렛 바의 각 조각에는 정수가 있고 Ron의 생일의 월 만큼
     * 조각각의 갯수의 정수 합을 Ron의 생일의 일과 같이 나오는 경우의 수를 출력
     *
     * 제약조건
     * 1<= n <= 100
     * 1<=s[i]<=5, 0<=i<n
     * 1<=d<=31
     * 1<=m<=12
     */
    @Test
    public void TestOne(){
        List<Integer> s = new ArrayList<Integer>();//Array.asList(2,2,1,3,2);
        s.add(2);
        s.add(2);
        s.add(1);
        s.add(3);
        s.add(2);

        int d =4;
        int m = 2;
        int ecpected = 2;
        BirthdayChocolate birthdayChocolate = new BirthdayChocolate();
        int result = birthdayChocolate.solve(s, d, m);

        assertThat(result, is(ecpected));
    }

    @Test
    public void TestTwo(){
        List<Integer> s = new ArrayList<Integer>();//Array.asList(2,2,1,3,2);

        s.add(4);

        int d =4;
        int m = 1;
        int ecpected = 1;
        BirthdayChocolate birthdayChocolate = new BirthdayChocolate();
        int result = birthdayChocolate.solve(s, d, m);

        assertThat(result, is(ecpected));
    }

    @Test
    public void TestThree(){
        List<Integer> s = new ArrayList<Integer>();//Array.asList(2,2,1,3,2);

        s.add(1);

        int d =1;
        int m = 1;
        int ecpected = 1;
        BirthdayChocolate birthdayChocolate = new BirthdayChocolate();
        int result = birthdayChocolate.solve(s, d, m);

        assertThat(result, is(ecpected));
    }
}
