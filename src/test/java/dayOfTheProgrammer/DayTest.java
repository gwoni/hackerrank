package dayOfTheProgrammer;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DayTest {

    /**
     * https://www.hackerrank.com/challenges/day-of-the-programmer/problem
     * 프로그래머의날은 매년 256번째로 해당 년도 평년, 윤년을 계산해서 해당 날짜를 구하기
     *   Julian calendar에서 윤년은 4로 나누어 떨어지는 년도
     *   Gregorian calendar 에서 윤년은 400로 나누어 나누어떨어지거나 또 4로 나우어 떨어지면서 100으로 나누어 떨어지지 않는 년도
     *   1918년도는 Julian calendar에서 Gregorian calendar 로 변경되는 시점으로 2월14일이 32일째이다.
     * 제약 조건
     * 1700 <= year <= 2700
     */
    @Test
    public void DayTest(){
        DayOfTheProgrammer dayOfTheProgrammer = new DayOfTheProgrammerImpl();
        int year = 2016;
        String result = dayOfTheProgrammer.solve(year);
        String ecpected ="12.09.2016";
        assertThat(result, is(ecpected));
    }

    @Test
    public void DayTest1(){
        DayOfTheProgrammer dayOfTheProgrammer = new DayOfTheProgrammerImpl();
        int year = 1800;
        String result = dayOfTheProgrammer.solve(year);
        String ecpected ="12.09.1800";
        assertThat(result, is(ecpected));
    }

    @Test
    public void DayTest2(){
        DayOfTheProgrammer dayOfTheProgrammer = new DayOfTheProgrammerImpl();
        int year = 1918;
        String result = dayOfTheProgrammer.solve(year);
        String ecpected ="26.09.1918";
        assertThat(result, is(ecpected));
    }
}
