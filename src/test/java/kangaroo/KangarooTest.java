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

    @Test
    public void kangarooTest() {
        int [] intArray = { 0, 3, 4, 2 };
        String result = kangaroo.solve(intArray[0], intArray[1], intArray[2], intArray[3]);
        String ecpected = "YES";
        assertThat(result, is(ecpected));
    }
/*
    private String kangaroo(int x1, int v1, int x2, int v2) {
        if(v1 < v2 || v1 == v2) return "NO";
        if((x2 - x1) % (v1 - v2) == 0 ) return "YES";
        return "NO";
    }
    */
}
