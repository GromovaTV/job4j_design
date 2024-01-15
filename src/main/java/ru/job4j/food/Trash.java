package ru.job4j.food;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {

    private List<Food> foodList = new ArrayList<Food>();

    @Override
    public boolean accept(Food food) {
        LocalDate now = LocalDate.now();
        LocalDate exp = food.getExpiryDate();
        boolean res = ChronoUnit.DAYS.between(now, exp) < 0;
        return res;
    }

    @Override
    public void add(Food food) {
        if (accept(food)) {
            this.foodList.add(food);
            System.out.println("Product " + food.getName() + " was added to Trash");
        }
    }

    @Override
    public List<Food> getAll() {
        return new ArrayList<>(foodList);
    }

    @Override
    public void removeAll() {
        foodList.clear();
    }
}

