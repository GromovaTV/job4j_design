package ru.job4j.iterator;
import org.hamcrest.core.Is;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
public class ListUtilsTest {
    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenRemoveNegative() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, -2, 2, 3, -4));
        ListUtils.removeIf(input, s -> s < 0);
        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void whenReplaceNegative() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, -2, 2, 3, -4));
        ListUtils.replaceIf(input, s -> s < 0, 0);
        assertThat(input, is(Arrays.asList(1, 0, 2, 3, 0)));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> remove = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.removeAll(input, remove);
        assertThat(input, is(Arrays.asList(2, 4)));
    }
}