package ru.job4j.kiss;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxMinTest {

    @Test
    public void max() {
        MaxMin mm = new MaxMin();
        List<Integer> numbers = Arrays.asList(5, 2, 8, 3, 9);
        Integer res = mm.max(numbers, Integer::compareTo);
        Integer exp = 9;
        assertThat(res, is(exp));
    }

    @Test
    public void min() {
        MaxMin mm = new MaxMin();
        List<Integer> numbers = Arrays.asList(5, 2, 8, 3, 9);
        Integer res = mm.min(numbers, Integer::compareTo);
        Integer exp = 2;
        assertThat(res, is(exp));
    }
}