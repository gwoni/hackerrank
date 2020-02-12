package encryption;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * https://www.hackerrank.com/challenges/encryption/problem
 * 텍스트는 다음 암호화 체계를 사용하여 암호화
 */
public class EncryptionTest {
    private Encryption encryption;

    @Before
    public void init(){
        encryption = new Encryption();
    }

    @Test
    public void testOne(){
        String testSring = "haveaniceday";
        String ecpected = "hae and via ecy";
        String result = encryption.encryption(testSring);
        assertThat(result, is(ecpected));
    }

    @Test
    public void testTwo(){
        String testSring = "haveaniceday";
        String ecpected = "hae and via ecy";
        String result = encryption.solve(testSring);
        assertThat(result, is(ecpected));
    }


}
