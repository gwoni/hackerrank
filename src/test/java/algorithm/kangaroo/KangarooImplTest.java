package algorithm.kangaroo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class KangarooImplTest {

    @Test
    public void KangarooTest() {
        Kangaroo kangaroo = new KangarooImpl();
        int x1 = 0;
        int v1 = 3;
        int x2 = 4;
        int v2 = 2;
        String expected = "YES";

        String result = kangaroo.solve(x1, v1, x2, v2);
        assertThat(result, is(expected));
    }
}
