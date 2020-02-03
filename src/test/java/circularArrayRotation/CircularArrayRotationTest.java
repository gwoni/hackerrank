package circularArrayRotation;

import org.junit.Test;
import utils.TestUtil;

import java.util.Arrays;
import java.util.List;

public class CircularArrayRotationTest {

    @Test
    /**
     * input
     * 3 2 3
     * 1 2 3
     * 0
     * 1
     * 2
     *
     * output
     * 2
     * 3
     * 1
     */
    public void TestOne() {
        CircularArrayRotation circularArrayRotation = new CircularArrayRotation();
        int n = 3;
        int k = 2;
        int q = 3;

        int[] a = new int[] {1, 2, 3};  //회전 할 정수 배열
        int[] queries = new int[] {0, 1, 2};    //정수 배열 보고할 인덱스
        int[] ecpected = new int[] {2, 3, 1};   // 예상되는 값
        int[] result = circularArrayRotation.solve(a, k, queries);

        TestUtil.intComparator(ecpected, result);
    }
}
