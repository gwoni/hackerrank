package legoBlocks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Sample Input
 *
 * 4
 * 2 2
 * 3 2
 * 2 3
 * 4 4
 *
 * 6
 * 4 5
 * 4 6
 * 4 7
 * 5 4
 * 6 4
 * 7 4
 *
 * Sample Output
 *
 * 3
 * 7
 * 9
 * 3375
 *
 * 35714
 * 447902
 * 5562914
 * 29791
 * 250047
 * 2048383
 */
public class LegoBlocks {
    private Logger logger = LogManager.getLogger(this.getClass());

    /**
     * 4 4
     * 3375
     * @param n 높이
     * @param m 너비
     * @return
     */
    public int legoBlocks(int n, int m) {
        int modulo = (int)Math.pow(10, 9) + 7;
        n = n % modulo;
        m = m % modulo;
        int count = (int)Math.pow(2, (m-1)); //2의 3승 8 한 줄에 레고를 배치할 수 있는 경우의 수
        int total = (int)Math.pow(count, (n)); //8의 4승 전체 n 줄 레고를 배치 경우의 수 8*8*8*8 = 4096
        int start = (int)Math.pow(2, m-1); // 한 줄에 표현식 m이 4일때 4칸짜리 레고 하나 부터 배치 이진수 방법 1000 십진수표현 8
        int end = (int)Math.pow(2, m); // 한 줄에  표현식 m이 4일때 1칸짜리 레고 4개 배치 형태 이진수 1111 십진수 표현 15
        int badCount = 0; // Bad layouts 의 경우 수
        int mod = n % 4; //줄 수에 따른 for 적용 수 모드
        switch (mod){
            case 0: //4중 for문
                badCount =  cal04(start, end);
                break;
            case 1: //한 줄로 bad layouts 없음
                badCount = 0;
                break;
            case 2: // 2중 for문
               badCount = cal02(start, end);
                break;
            case 3: //3중 for문
                badCount = cal03(start, end);
                break;
        }
        logger.debug("badCount: " + badCount);
        logger.debug("total - badCount: " + (total - badCount));
        return total - badCount;
    }


    /**
     * 4행을 기준으로 레고 표현방법
     * 1111     1칸 레코 4개 표현 십진수 15 (end)
     * 1110     1칸 레고2개, 2칸 레고 1개
     * 1101     1칸 레고, 2칸 레고, 1칸 레고
     * 1100     1칸 레고, 3칸 레고
     * 1011     2칸 레고, 1칸 레고 2개
     * 1010     2칸 레고 두개
     * 1001     3칸 레코, 1칸 레고
     * 1000     4칸 레고 하나 표현 십진수 8 (start)
     *
     * 비트연산자 & 이용
     * 0&0=0
     * 0&1=0
     * 1&0=0
     * 1&1=1
     * @param start 레고 표현방법 시작
     * @param end  레고 표현 방법 끝
     * @return bad layers 수 출력
     */
    private int cal02(int start, int end){
        int badCount = 0;
        for(int i = start - start; i < end - start; i++){ // 4열를 예로 start는 이진표현으로 1000에서 1000 빼면 앞에 1을 없애는 효과가 있다
            for(int j = start - start; j < end - start; j++){ //4열를 예로 end는 이진표현으로 1111에서 start를 빼면 맨 앞1을 없애 0111 과 같아진다
                if((i & j) > 0){                                //for문으로 숫자가 1씩 올라가면서 0000에서 0001, 0010 으로 상승해 0111까지 올라간다
                    badCount++;     //윗행과 아래 행 비교에서 0이 아닌 부분은 이진표현에서 위아래로 1이 있는 경우뿐이다.
                }                   //즉 1은 레고의 틈으로 생각하면 이해가 빠르다, 틈이 있으면 badCount 증가
            }
        }
        return badCount;
    }

    private int cal03(int start, int end){
        int badCount = 0;
        for(int i = start - start; i < end - start; i++){
            for(int j = start - start; j < end - start; j++){
                for(int k = start - start; k < end - start; k++){
                    logger.debug(i + ": " + Integer.toBinaryString(i));
                    logger.debug(j +" : " + Integer.toBinaryString(j));
                    logger.debug(k +" : " + Integer.toBinaryString(k));
                    if((i & j & k) > 0){
                        badCount++;
                    }
                    logger.debug("(i & j & k): " + (i & j & k));
                }
            }
        }
        logger.debug("badCount: " + badCount);
        return badCount;
    }

    private int cal04(int start, int end){
        int badCount = 0;
        for(int i = start - start; i < end - start; i++){
            for(int j = start - start; j < end - start; j++){
                for(int k = start - start; k < end - start; k++){
                    for(int l = start - start; l < end - start; l++){
                        if((i & j & k & l) > 0){
                            badCount++;
                        }
                    }
                }
            }
        }
        return badCount;
    }
}
