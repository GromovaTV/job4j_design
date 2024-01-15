package ru.job4j.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimpleMapTest {

    SimpleMap<Integer, Integer> simpleMap;

    @Before
    public void initData() {
        simpleMap = new SimpleMap<>();
        simpleMap.put(1, 1);
        simpleMap.put(2, 2);
        simpleMap.put(3, 3);
        simpleMap.put(4, 4);
        simpleMap.put(5, 5);
        simpleMap.put(6, 6);

    }

    @Test
    public void put() {
        simpleMap.put(1, 2);
        Assert.assertEquals(Integer.valueOf(2), simpleMap.get(1));
        Assert.assertEquals(Integer.valueOf(2), simpleMap.get(2));
    }


    @Test
    public void remove() {
        simpleMap.remove(1);
        Assert.assertNull(simpleMap.get(1));
        Assert.assertFalse(simpleMap.remove(1));
        Assert.assertFalse(simpleMap.remove(7));
    }

    @Test
    public void putWhenExpand() {
        simpleMap.put(7, 7);
        Assert.assertEquals(16, simpleMap.getCapacity());
    }
}