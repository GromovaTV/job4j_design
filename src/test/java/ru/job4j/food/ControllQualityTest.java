package ru.job4j.food;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ControllQualityTest {

    @Test
    public void whenTrash() {
        List<Storage> sl = new ArrayList<>();
        List<Food> exp = new ArrayList<>();
        Trash trash = new Trash();
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        sl.add(warehouse);
        sl.add(shop);
        sl.add(trash);
        ControllQuality cq = new ControllQuality(sl);
        Food milk = new Milk("Milk", LocalDate.of(2023, 6, 10),
                LocalDate.of(2023, 6, 5), 100, 0);
        cq.allocate(milk);
        exp.add(milk);
        assertEquals(exp, trash.getAll());
    }

    @Test
    public void whenWarehouse() {
        List<Storage> sl = new ArrayList<>();
        List<Food> exp = new ArrayList<>();
        Trash trash = new Trash();
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        sl.add(warehouse);
        sl.add(shop);
        sl.add(trash);
        ControllQuality cq = new ControllQuality(sl);
        Food milk = new Milk("Milk", LocalDate.of(2023, 6, 30),
                LocalDate.of(2023, 6, 11), 100, 0);
        cq.allocate(milk);
        exp.add(milk);
        assertEquals(exp, warehouse.getAll());
    }

    @Test
    public void whenShopWithoutDiscount() {
        List<Storage> sl = new ArrayList<>();
        List<Food> exp = new ArrayList<>();
        Trash trash = new Trash();
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        sl.add(warehouse);
        sl.add(shop);
        sl.add(trash);
        ControllQuality cq = new ControllQuality(sl);
        Food bread = new Bread("Bread", LocalDate.of(2023, 6, 30),
                LocalDate.of(2023, 6, 1), 100, 0);
        cq.allocate(bread);
        exp.add(bread);
        assertEquals(exp, shop.getAll());
        assertEquals(0, bread.getDiscount());
    }

    @Test
    public void whenShopWithDiscount() {
        List<Storage> sl = new ArrayList<>();
        List<Food> exp = new ArrayList<>();
        Trash trash = new Trash();
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        sl.add(warehouse);
        sl.add(shop);
        sl.add(trash);
        ControllQuality cq = new ControllQuality(sl);
        Food bread = new Bread("Bread", LocalDate.of(2023, 6, 12),
                LocalDate.of(2023, 6, 1), 100, 0);
        cq.allocate(bread);
        exp.add(bread);
        assertEquals(exp, shop.getAll());
        assertEquals(50, bread.getDiscount());
    }
}