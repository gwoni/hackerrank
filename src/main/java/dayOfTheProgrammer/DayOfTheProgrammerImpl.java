package dayOfTheProgrammer;

public class DayOfTheProgrammerImpl implements DayOfTheProgrammer {
    @Override
    public String solve(int year) {
        if(year <= 1918){
            return outputJulianDay(year);
        }else{
            return outputGregorianDay(year);
        }
    }

    /**
     *
     * @param year 입력 년도
     * @param deepYearDay 평년 0, 윤년 1
     * @return 프로그래머의날
     */
    private String toProrammerDay(int year, int deepYearDay) {
        final int DAYOFTHEPRORAMMER = 256; // 프로그래머날
        final int DAYOFNORMAL = 31+28+31+30+31+30+31+31; // 평년을 기줄으로 1월부터 8월까지 일수
        int adjustDay =0; //1918년 조정 날짜
        if(year == 1918) adjustDay = 13; // 1918년엔 2월 14일이 32번째 날이므로 조정 날짜 추가
        return String.valueOf(DAYOFTHEPRORAMMER - DAYOFNORMAL - deepYearDay + adjustDay) + ".09." +String.valueOf(year);
    }

    /**
     * Gregorian calendar leap years 연산
     * @param year Gregorian 입력 년도
     * @return 프로그래머의 날
     */
    private String outputGregorianDay(int year) {
        if(year % 400 == 0 || (year % 4 ==0 && year % 100 !=0))
            return toProrammerDay(year,1); //"12.09."+String.valueOf(year);
        else
            return toProrammerDay(year,0); //"13.09."+String.valueOf(year);
    }

    /**
     *  Julian calendar leap years 연산
     * @param year Julian 입력년도
     * @return 프로그래머의 날
     */
    private String outputJulianDay(int year) {
        if(year % 4 == 0)
            return toProrammerDay(year,1);
        else
            return toProrammerDay(year,0);
    }
}
