package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {

    public <T> T search(List<T> value, BiPredicate<T, T> pred) {
        T res = value.get(0);
        for (T v : value) {
            if (pred.test(res, v)) {
                res = v;
            }
        }
        return res;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return search(value, (t1, t2) -> comparator.compare(t1, t2) < 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return search(value, (t1, t2) -> comparator.compare(t1, t2) > 0);
    }
}