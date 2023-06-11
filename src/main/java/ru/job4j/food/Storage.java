package ru.job4j.food;

import java.util.List;

public interface Storage {
    boolean accept(Food food);
    void add(Food food);
    List<Food> getAll();
}
