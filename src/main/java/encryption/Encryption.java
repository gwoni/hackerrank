package encryption;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Encryption implements EncryptionImpl {
    private Logger logger = LogManager.getLogger(this.getClass());
    static int LIMITCOLUMN =81; //열 제한
    String result; //암화화 된 결과
    String[] temp;  //암호에 필요한 임시 배열
    String trimText ;   //공백 제거된 암호화될 텍스트
    int textSize;       //텍스트 길이
    int columns;       //  암호화에 사용되는 컬럼 수, 텍스트 길이의 루트 값

    public Encryption(){
        result = "";
        temp = new String[LIMITCOLUMN];
    }

    /**
     *  한 눈에 보기 쉬운 코드, 해커랭크 테스트용 함수
     * @param s 암호화 할 텍스트
     * @return 암호화 된 텍스트
     */
    public String encryption(String s) {
        trimText = s.trim();
        textSize = trimText.length();

        columns = (int) Math.sqrt(textSize);
        columns = (columns*columns == textSize) ? columns : columns+1;

        for(int idx = 0; idx < textSize; idx++){
            if(temp[idx%columns] ==null)
                temp[idx%columns]="";
            temp[idx%columns] += trimText.substring(idx, idx+1);
        }

        for(int idx=0; idx < columns; idx++){
            result += temp[idx] + " ";
        }
        result = result.substring(0, result.length()-1);
        return result;
    }

    /**
     *  함수 리펙토리된 암화화 함수
     * @param s 암호화 할 텍스트
     * @return 암호화 된 텍스트
     */
    @Override
    public String solve(String s) {
        init(s);
        calculateEncoding();
        return getEncodeText();
    }

    /**
     * 암호화 하기 전 초기화 및 텍스트 제약조건 확인
     * @param s 암호화 할 텍스트
     */
    private void init(String s){
        logger.debug("input text: " + s);
        validatorText(s);
        trimText = s.trim();
        textSize = trimText.length();
        columns = getColumns(textSize);
        validatorColumns(columns);
    }

    /**
     * 텍스트 제약조건
     * @param s 암호화 할 텍스트
     */
    private void validatorText(String s) {
        if (s == null) {
            logger.error("TEXT_IS_NULL");
            throw new RuntimeException("TEXT_IS_NULL");
        }else if(s.equals("")){
            logger.error("TEXT_IS_SPACE");
            throw new RuntimeException("TEXT_IS_SPACE");
        }
    }

    /**
     * 암호화 컬럼 수 제약조건 확인
     * @param columns 암호화 할 텍스트
     */
    private void validatorColumns(int columns) {
        if (columns > LIMITCOLUMN) {
            logger.error("COLUMNS_OUT_OF_LIMIT");
            throw new RuntimeException("COLUMNS_OUT_OF_LIMIT");
        }
    }

    /**
     * 암호화 할 텍스트 크기의 컬럼 수 구하기
     * @param textSize
     */
    private int getColumns(int textSize){
        int columns = (int) Math.sqrt(textSize);
        return (columns*columns == textSize) ? columns : columns+1;
    }

    /**
     * 암화화에 사용되는 컬럼 계산
     */
    private void calculateEncoding(){
        for(int idx = 0; idx < textSize; idx++){
            if(temp[idx%columns] ==null) temp[idx%columns]="";
            temp[idx%columns] += trimText.substring(idx, idx+1);
        }
    }

    /**
     *
     * @return 암호화 된 컬럼을 모두 붙여서 암화텍스트로 출력
     */
    private String getEncodeText(){
        for(int idx=0; idx < columns; idx++){
            //암호화된 컬럼과 컬럼 사이 공백 추가
            result += temp[idx] + " ";
        }
        logger.debug("output result: " + result);
        //마지막 공백 제거
        return result.substring(0, result.length()-1);
    }
}
