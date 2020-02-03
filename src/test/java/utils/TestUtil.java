package utils;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;

import java.util.List;

public class TestUtil<T> {

    public static<T> void listComparator(List<T> expected, List<T> result) {
        MatcherAssert.assertThat(result.size(), CoreMatchers.is(expected.size()));
        for (int idx = 0; idx < expected.size(); idx++) {
            MatcherAssert.assertThat(result.get(idx), CoreMatchers.is(expected.get(idx)));
        }
    }

    public static void intComparator(int[] expected, int[] result) {
        MatcherAssert.assertThat(result.length, CoreMatchers.is(expected.length));
        for (int idx = 0; idx < expected.length; idx++) {
            MatcherAssert.assertThat(result[idx], CoreMatchers.is(expected[idx]));
        }
    }
}