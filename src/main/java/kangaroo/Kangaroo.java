package kangaroo;

public class Kangaroo {

    /**
     * 두 캥거루가 만날수 있는지 확인
     * @param x1 캥거루1의 위치
     * @param v1 캥거루1의 점프거리
     * @param x2 캥거루2의 위치
     * @param v2 캥거루2의 점프거리
     * @return 두 캥거루가 만나면  YES, 만날수 없으면  NO값 출력
     */
    public String solve(int x1, int v1, int x2, int v2) {
        if(limitationCheck(v1,v2)) return "NO";
        if(sameTimeSite(x1, v1, x2, v2)) return "YES";
        return "NO";
    }

    /**
     * 제약조건에서 캥거루2의 점프거리가 캥거루1보다 커야되며 같은 위치이지 속도가 달라야지 두 캥거루가 만날수 있다
     * @param v1 캥거루 1의 점프거리
     * @param v2 캥거루 2의 점프 거리
     * @return  두 캥거루가 만날 조건 확인
     */
    public boolean limitationCheck(int v1, int v2){
        return(v1 < v2 || v1 == v2);
    }

    /**
     * 두 캥거루가 만날수 있는지 계산
     * @param x1 캥거루1의 위치
     * @param v1 캥거루1의 점프거리
     * @param x2 캥거루2의 위치
     * @param v2 캥거루2의 점프거리
     * @return 두 캥거루가 만날 수 있는지  true, false
     */
    public boolean sameTimeSite(int x1, int v1, int x2, int v2){
        return ((x2 - x1) % (v1 - v2) == 0);
    }
}
