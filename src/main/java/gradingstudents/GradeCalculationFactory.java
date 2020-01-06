package algorithm.gradingstudents;

class GradeCalculationFactory {
    static GradeCalculation getGradeCalcurator() {
        return new GradeMultipleCalculation();
    }
}
