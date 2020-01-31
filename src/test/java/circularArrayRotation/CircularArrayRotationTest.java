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
        //List<Integer> posArr = Arrays.asList(1, 2, 3);
       // String ecpected = "Cat B";
       // String result = "";


        int n = 3;

        int k = 2;

        int q = 3;

        int[] a = new int[] {1, 2, 3};

        int[] queries = new int[] {0, 1, 2};

        int[] result = CircularArrayRotation.circularArrayRotation(a, k, queries);

        int[] ecpected = new int[] {2, 3, 1};


    }
}
