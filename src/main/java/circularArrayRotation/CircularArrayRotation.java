package circularArrayRotation;

public class CircularArrayRotation {
    /**
     * 배열에서 특정 회전 수 만큼 돌았을 때 특정 인덱스의 값을 보고 하는 출력합니다
     * @param a 회전할 정수 배열
     * @param k 회전 수
     * @param queries 정수 배열 보고할 인덱스
     * @return
     */
    public int[] solve(int[] a, int k, int[] queries) {
        int circularSize = a.length;
        int leftShift = k%circularSize;
        int askSize =  queries.length;
        int[] result = new int[askSize];

        for(int idx =0; idx< askSize; idx++){
            result[idx] = a[indexArray(queries[idx], circularSize, leftShift)];
        }
        return result;
    }

    /**
     * 보고 할 인덱스가 회전 이후 가르기는 값 출력
     * @param askIndex 보고할 인덱스
     * @param circularSize  회절 할 배열 크기
     * @param leftShift 왼쪽으로 이동 할 횟수
     * @return 회전 이후 가르키는 값
     */
    private int indexArray(int askIndex, int circularSize, int leftShift){
        return (askIndex-leftShift+circularSize)%circularSize;
    }
}
