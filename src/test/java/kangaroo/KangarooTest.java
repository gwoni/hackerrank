package kangaroo;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class KangarooTest {
    private Kangaroo kangaroo;

    @Before
    public void init() {
        this.kangaroo = new Kangaroo();
    }

    /**
     * https://www.hackerrank.com/challenges/kangaroo/problem
     * 캥거루 1은 x1 위치에서 v1 미터를 점프하여 이동
     * 캥거루 2는 x2 위치에서 v2 미터를 점프하여 이동
     * 두 캥거루가 같은 점프 횟수로 같은 위치에 있으면 YES 값을 아니면 NO 값을 출력
     *
     * 제약 조건
     * 0<=x1<x2<=10000
     * 1<=v1<=10000
     * 1<=v2<=10000
     */
    @Test
    public void kangarooTest() {
        int x1 = 0, v1 = 3; // 캥거루1의 위치와 한번 점프 이동거리
        int x2 = 4, v2 = 2; // 캥거루2의 위치와 한번 점프 이동거리

        int [] intArray = {x1, v1, x2, v2};
        String result = kangaroo.solve(intArray[0], intArray[1], intArray[2], intArray[3]);
        String ecpected = "YES";
        assertThat(result, is(ecpected));
    }

/* 간결 코드 모드
    private String kangaroo(int x1, int v1, int x2, int v2) {
        if(v1 < v2 || v1 == v2) return "NO";
        if((x2 - x1) % (v1 - v2) == 0 ) return "YES";
        return "NO";
    }
    */
}
