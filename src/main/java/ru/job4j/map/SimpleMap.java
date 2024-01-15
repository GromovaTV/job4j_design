package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean put(K key, V value) {
        if (count >= LOAD_FACTOR * capacity) {
            expand();
        }
        if (table[indexFor(hash(Objects.hash(key)))] == null) {
            count++;
        }
        table[indexFor(hash(Objects.hash(key)))] = new MapEntry(key, value);
        modCount++;
        return true;
    }

    private int hash(int hashCode) {
        return (hashCode == 0) ? 0 : hashCode % capacity;
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        MapEntry<K, V>[] tmpTable = new MapEntry[capacity];
        System.arraycopy(table, 0, tmpTable, 0, capacity);
        capacity = capacity * 2;
        table = new MapEntry[capacity];
        count = 0;
        for (MapEntry<K, V> cell : tmpTable) {
            if (cell != null) {
                put(cell.key, cell.value);
            }
        }
    }

    @Override
    public V get(K key) {
        MapEntry<K, V> cell = table[indexFor(hash(Objects.hash(key)))];
        if (cell == null) {
            return null;
        }
        return cell.value;
    }

    @Override
    public boolean remove(K key) {
        MapEntry<K, V> cell = table[indexFor(hash(Objects.hash(key)))];
        if (cell == null || cell.key == null) {
            return false;
        }
        cell.value = null;
        cell.key = null;
        count--;
        modCount++;
        return true;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {

            private int index = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return index < count;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}