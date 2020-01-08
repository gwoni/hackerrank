package kangaroo;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Kangaroo {
    private Kangaroo kangaroo;

    @Before
    public void init() {
        this.kangaroo = new Kangaroo();
    }

    @Test
    public void kangarooTest() {
        int x1 = 0;
        int v1 = 3;
        int x2 = 4;
        int v2 = 2;
        String result = kangaroo.solve(x1, v1, x2, v2);
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
