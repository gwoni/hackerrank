package catsAndMouse;

public class CatsAndMouse {
    /**
     *
     * @param x A 고양이 위치
     * @param y B 고양이 위치
     * @param z C 쥐 위치
     * @return 먼저 쥐에 도달한 고양이 출력, 동시에 도달시 쥐 출력
     */
    public String solve(int x, int y, int z) {
        validator(x);
        validator(y);
        validator(z);
        return isEscapeMouse(x, y, z) ? "Mouse C" : getFirstReachCat(x, y, z);
    }

    /**
     *
     * @param pos 위치가 제약사항에 부합하는지 체크 ( 1 <= x, y, z <= 100 )
     */
    private void validator(int pos) {
        if (pos < 0 || pos > 100)
            throw new RuntimeException("POSITION_OUT_OF_LIMIT");
    }

    /**
     *
     * @param x A 고양이 위치
     * @param y B 고양이 위치
     * @param z C 쥐 위치
     * @return A, B 고양이가 동시에 C 쥐에 도달하여 쥐가 도망친 경우 체크
     */
    private Boolean isEscapeMouse(int x, int y, int z){
        return Math.abs(x-z) == Math.abs(y-z);
    }

    /**
     *
     * @param x A 고양이 위치
     * @param y B 고양이 위치
     * @param z C 쥐 위치
     * @return C 쥐 위치에 가까워서 먼저 도달한 고양이 출력
     */
    private String getFirstReachCat(int x, int y, int z){
        return Math.abs(x-z) < Math.abs(y-z) ? "Cat A" : "Cat B";
    }
}
