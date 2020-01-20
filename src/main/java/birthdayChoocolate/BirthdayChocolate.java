package birthdayChoocolate;

import java.util.List;

public class BirthdayChocolate {
    /**
     *
     * @param s : an array of integers, the numbers on each of the squares of chocolate
     * @param d : an integer, Ron's birth day
     * @param m : an integer, Ron's birth month
     * @return result : Print an integer denoting the total number of ways that Lily can portion her chocolate bar to share with Ron.
     */
    public int solve(List<Integer> s, int d, int m) {
        int result = 0; // 나누어 줄 수있는 방법의 수
        for(int idx = 0; idx <= s.size()-m; idx++){
            List<Integer> segmentBar = s.subList(idx, idx+m); //선택된 초콜렛 조각바
            result += checkRonBirthday(segmentBar, d);
        }
        return result;
    }

    /**
     *
     * @param chocolateBar 선택된 초콜렛 바
     * @param day Ron 의 생일의 날
     * @return 선택된 초콜렛에 적힌 숫자의 합이 Ron 의 생일의 날과 같은면 1, 아니면 0
     */
    private int checkRonBirthday(List<Integer> chocolateBar, int day){
        return chocolateBar.stream().mapToInt(Integer::intValue).sum() == day ? 1 : 0; // 선택된 초콜렛에 적힌 숫자의 합이 Ron 의 생일의 날과 같은지 확인
    }
}
