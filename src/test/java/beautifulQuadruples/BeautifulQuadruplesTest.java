package beautifulQuadruples;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class beautifulQuadruplesTest {
    private BeautifulQuadruples beautifulQuadruples;

    @Before
    public void init(){
        beautifulQuadruples = new BeautifulQuadruples();
    }

    @Test
    public void testOne(){
        int[] test = {1,2,3,4};
        int ecpected = 11;
        int result = beautifulQuadruples.beautifulQuadruples(test[0], test[1], test[2], test[3]);
        assertThat(result, is(ecpected));
    }

    @Test
    public void testTwo(){
        int[] test = {2,2,2,3};
        int ecpected = 11;
        int result = beautifulQuadruples.beautifulQuadruples2(test[0], test[1], test[2], test[3]);
        assertThat(result, is(ecpected));
    }

}
