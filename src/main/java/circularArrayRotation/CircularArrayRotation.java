package circularArrayRotation;

public class CircularArrayRotation {
    /**
     *
     * @param a 회전할 정수 배열
     * @param k 회전 수
     * @param queries 정수 배열 보고할 인덱스
     * @return
     */
    public int[] solve(int[] a, int k, int[] queries) {
        int aSize = a.length;
        int change = k%aSize;
        int[] result = new int[queries.length];
        for(int idx =0; idx< queries.length; idx++){
            result[idx] = a[indexArray(queries[idx], aSize, change)];
        }
        return result;
    }

    private int indexArray(int x, int aSize, int change){
        return (x-change+aSize)%aSize;
    }
}
