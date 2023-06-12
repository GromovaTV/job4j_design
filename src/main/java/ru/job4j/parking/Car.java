package ru.job4j.parking;

public abstract class Car {
    private int size;

    public Car(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
