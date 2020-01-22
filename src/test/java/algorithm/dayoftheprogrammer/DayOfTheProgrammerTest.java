package algorithm.dayoftheprogrammer;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DayOfTheProgrammerTest {

    private DayOfTheProgrammer dayOfTheProgrammer;

    @Before
    public void init() {
        this.dayOfTheProgrammer = new DayOfTheProgrammer();
    }

    @Test
    public void gradingStudents() {
        List<Integer> params = Arrays.asList(2017, 2016, 1800);
        List<String> expected = Arrays.asList("13.09.2017", "12.09.2016", "12.09.1800");
        for (int index = 0; index < params.size(); index++) {
            assertThat(dayOfTheProgrammer.dayOfProgrammer(params.get(index)), is(expected.get(index)));
        }
    }

    @Test(expected = RuntimeException.class)
    public void gradingStudentsLowerException() {
        dayOfTheProgrammer.dayOfProgrammer(1699);
    }

    @Test(expected = RuntimeException.class)
    public void gradingStudentsHigherException() {
        dayOfTheProgrammer.dayOfProgrammer(2701);
    }
}