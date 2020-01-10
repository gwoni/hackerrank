package algorithm.gradingstudents;

public class GradeMultipleCalculation implements GradeCalculation {
    private static final int modulationValue = 5;
    private static final int baseModificationValue = 3;
    private static final int failGrade = 40;

    /**
     * Modify Grade Rule
     * - 실제성적과 성정의 다음 5의 배수값의 차가 3미만 일 경우 성적을 다음 5의 배수값으로 조정한다.
     * - 40점 미만은 낙제 점수 이다.
     *
     * @param orignalGrade 실제성적
     * @return 조정된 설정
     */
    public int calculateGrade(int orignalGrade) {
        if (orignalGrade <= failGrade - baseModificationValue)
            return orignalGrade;

        int result = orignalGrade;
        int modular = (orignalGrade % modulationValue);
        if (modular >= baseModificationValue) {
            result = orignalGrade + modulationValue - modular;
        }
        return result;
    }
}
