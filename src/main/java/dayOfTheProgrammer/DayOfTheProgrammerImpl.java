package dayOfTheProgrammer;

public class DayOfTheProgrammer {
    public String solve(int year) {
        if(year <= 1918){
            return outputJulianDay(year);
        }else{
            return outputGregorianDay(year);
        }
    }

    private String toProrammerDay(int year, int deepYearDay) {
        final int DAYOFTHEPRORAMMER = 256;
        final int DAYOFNORMAL = 31+28+31+30+31+30+31+31;
        int adjustDay =0;
        if(year == 1918) adjustDay = 13; // 1918년엔 2월 14일이 32번째 날이므로 조정 날짜 추가
        return String.valueOf(DAYOFTHEPRORAMMER - DAYOFNORMAL - deepYearDay + adjustDay) + ".09." +String.valueOf(year);
    }

    private String outputGregorianDay(int year) {
        if(year % 400 == 0 || (year % 4 ==0 && year % 100 !=0))
            return toProrammerDay(year,1); //"12.09."+String.valueOf(year);
        else
            return toProrammerDay(year,0); //"13.09."+String.valueOf(year);
    }

    private String outputJulianDay(int year) {
        if(year % 4 == 0)
            return toProrammerDay(year,1);
        else
            return toProrammerDay(year,0);
    }




}
