package ru.job4j.food;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {

    private List<Food> foodList = new ArrayList<>();

    @Override
    public boolean accept(Food food) {
        LocalDate now = LocalDate.now();
        LocalDate exp = food.getExpiryDate();
        LocalDate cr = food.getCreateDate();
        var storeLife = ChronoUnit.DAYS.between(cr, exp);
        var daysPast = ChronoUnit.DAYS.between(cr, now);
        boolean res = daysPast * 100 / storeLife < 25;
        return res;
    }

    @Override
    public void add(Food food) {
        if (accept(food)) {
            this.foodList.add(food);
            System.out.println("Product " + food.getName() + " was added to Warehouse");
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
