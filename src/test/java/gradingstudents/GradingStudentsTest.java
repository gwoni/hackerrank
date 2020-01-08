package gradingstudents;

import org.junit.Before;
import org.junit.Test;
import utils.TestUtil;

import java.util.Arrays;
import java.util.List;

public class GradingStudentsTest {
    private GradingStudents gradingStudents;

    @Before
    public void init() {
        this.gradingStudents = new GradingStudents();
    }

    @Test
    public void gradingStudents() {
        List<Integer> param = Arrays.asList(73, 67, 38, 33);
        List<Integer> expected = Arrays.asList(75, 67, 40, 33);
        List<Integer> result = gradingStudents.solve(param);
        TestUtil.listComparator(expected, result);
    }
}
