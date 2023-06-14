package ru.job4j.food;

import java.util.LinkedList;
import java.util.List;

public class ControllQuality {
    private List<Storage> storeList;

    public ControllQuality(List<Storage> storeList) {
        this.storeList = storeList;
    }
    
    public void allocate(Food food) {
        for (Storage store : storeList) {
            store.add(food);
        }
    }

    public void resort() {
        List<Food> tmp = new LinkedList<>();
        for (Storage store : storeList) {
            tmp.addAll(store.getAll());
            store.removeAll();
        }
        for (Food food : tmp) {
            allocate(food);
        }
    }
}
