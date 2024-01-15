package ru.job4j.food;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ControlQualityTest {

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
        ControlQuality cq = new ControlQuality(sl);
        Food milk = new Milk("Milk", LocalDate.now().minusDays(1),
                LocalDate.now().minusDays(15), 100, 20);
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
        ControlQuality cq = new ControlQuality(sl);
        Food milk = new Milk("Milk", LocalDate.now().plusDays(14),
                LocalDate.now(), 100, 0);
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
        ControlQuality cq = new ControlQuality(sl);
        Food bread = new Bread("Bread", LocalDate.now().plusDays(4),
                LocalDate.now().minusDays(4), 100, 0);
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
        ControlQuality cq = new ControlQuality(sl);
        Food bread = new Bread("Bread", LocalDate.now().plusDays(1),
                LocalDate.now().minusDays(5), 100, 0);
        cq.allocate(bread);
        exp.add(bread);
        assertEquals(exp, shop.getAll());
        assertEquals(50, bread.getDiscount());
    }
}