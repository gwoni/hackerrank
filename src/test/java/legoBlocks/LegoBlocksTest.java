package legoBlocks;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LegoBlocksTest {
    private LegoBlocks legoBlocks;

    @Before
    public void init(){
        legoBlocks = new LegoBlocks();
    }

    @Test
    public void testOne(){
        int[] test1 = {2,2};
        int[] test2 = {3,2};
        int[] test3 = {2,3};
        int[] test4 = {4,4};

        int ecpected1 = 3;
        int ecpected2 = 7;
        int ecpected3 = 9;
        int ecpected4 = 3375;

        int result = legoBlocks.legoBlocks(test2[0], test2[1]);
        assertThat(result, is(ecpected2));
    }

    @Test
    public void testTwo(){
        int[] test1 = {4,5};
        int[] test2 = {4,6};
        int[] test3 = {4,7};
        int[] test4 = {5,4};
        int[] test5 = {6,4};
        int[] test6 = {7,4};

        int ecpected1 = 35714;
        int ecpected2 = 447902;
        int ecpected3 = 5562914;
        int ecpected4 = 29791;
        int ecpected5 = 250047;
        int ecpected6 = 2048383;

        int result = legoBlocks.legoBlocks(test2[0], test2[1]);
        assertThat(result, is(ecpected2));
    }
}
