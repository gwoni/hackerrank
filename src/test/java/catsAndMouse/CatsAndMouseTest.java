package catsAndMouse;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 *  https://www.hackerrank.com/challenges/cats-and-a-mouse/problem
 *  CatSAndMouse
 *  A, B 고양이와 C 쥐가 가 있고 각각 위치가 INPUT 된다.
 *  A, B 고양이의 이동 속도는 같고 C 쥐는 이동하지 않고 A, B 고양이가 동시에 왔을 때 도망친다
 *  먼저 도착한 고양이의 를 OUTPUT으로 출력, 동시 도착시 쥐를 출력 한다.
 *
 *  제약조건
 *  1 <= x, y, z <= 100 //  고양이와 쥐의 위치
 */
public class CatsAndMouseTest {
    private CatsAndMouse catsAndMouse;

    @Before
    public void init() {
        this.catsAndMouse = new CatsAndMouse();
    }
    @Test
    public void TestOne(){
        List<Integer> posArr = Arrays.asList(1, 2, 3); //A ,B 고양이와 C 쥐의 위치 값
        String ecpected="Cat B";
        String result = catsAndMouse.solve(posArr.get(0), posArr.get(1), posArr.get(2));
        assertThat(result, is(ecpected));
    }

    @Test
    public void TestTwo(){
        List<Integer> posArr = Arrays.asList(1, 3, 2); //A ,B 고양이와 C 쥐의 위치 값
        String ecpected="Mouse C";
        String result = catsAndMouse.solve(posArr.get(0), posArr.get(1), posArr.get(2));
        assertThat(result, is(ecpected));
    }

    @Test(expected = RuntimeException.class)
    public void TestThreeHigherException(){
        List<Integer> posArr = Arrays.asList(101, 3, 2); //A ,B 고양이와 C 쥐의 위치 값
        String result = catsAndMouse.solve(posArr.get(0), posArr.get(1), posArr.get(2));
    }
}
