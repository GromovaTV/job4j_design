package ru.job4j.food;

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
}
