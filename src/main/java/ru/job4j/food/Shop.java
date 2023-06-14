package ru.job4j.food;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {
    private List<Food> foodList = new ArrayList<Food>();

    @Override
    public boolean accept(Food food) {
        boolean res = false;
        LocalDate now = LocalDate.now();
        LocalDate exp = food.getExpiryDate();
        LocalDate cr = food.getCreateDate();
        var storeLife = ChronoUnit.DAYS.between(cr, exp);
        var daysPast = ChronoUnit.DAYS.between(cr, now);
        double daysExp = daysPast * 100 / storeLife;
        if (daysExp > 75 && daysExp <= 100) {
            food.setDiscount(50);
            res = true;
        }
        if (daysExp > 25 && daysExp <= 75) {
            res = true;
        }
        return res;
    }

    @Override
    public void add(Food food) {
        if (accept(food)) {
            foodList.add(food);
            System.out.println("Product " + food.getName()
                    + " was added to Shop with discount " + food.getDiscount());
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
