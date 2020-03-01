package electronicsShop;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ElectronicsShopTest {
    private ElectronicsShop electronicsShop;

    @Before
    public void init(){
        electronicsShop = new ElectronicsShop();
    }
    @Test
    public void testOne(){
        int[] test = {10, 2, 3};
        int[] keyboard = {3, 1};
        int[] drives = {5, 2, 8};
        int ecpected = 9;
        int result = electronicsShop.getMoneySpent(keyboard, drives, test[0]);
        assertThat(result, is(ecpected));
    }
}
