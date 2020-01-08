package gradingstudents;

import java.util.ArrayList;
import java.util.List;

public class GradingStudents {

    public List<Integer> solve(List<Integer> grades) {
        List<Integer> modifiedGrade = new ArrayList<>();
        for (Integer grade : grades) {
            modifiedGrade.add(GradeCalculationFactory.getGradeCalcurator().calculateGrade(grade));
        }
        return modifiedGrade;
    }

}
