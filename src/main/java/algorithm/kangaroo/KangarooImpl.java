package algorithm.kangaroo;

/**
 * @url https://www.hackerrank.com/challenges/kangaroo/problem
 */
public class KangarooImpl implements Kangaroo {
    @Override
    public String solve(int x1, int v1, int x2, int v2) {
        if (canChangePosition(x1, x2, v1, v2)) return "NO";
        return canLocatedSamePosition(x1, x2, v1, v2);
    }

    private String canLocatedSamePosition(int x1, int x2, int v1, int v2) {
        int positionFirst = x1;
        int positionSecond = x2;
        boolean firstLocatedBefore = x1 < x2;
        boolean isPositionChange = false;
        while (!isPositionChange) {
            positionFirst = positionFirst + v1;
            positionSecond = positionSecond + v2;
            if ( (positionFirst < positionSecond) != firstLocatedBefore) {
                isPositionChange = true;
            }
        }
        return (positionFirst == positionSecond) ? "YES" : "NO";
    }

    private boolean canChangePosition(int x1, int x2, int v1, int v2) {
        if( x1 > x2)
            return (v1 > v2);
        else if (x1 < x2)
            return v1 < v2;

        return false;
    }
}
