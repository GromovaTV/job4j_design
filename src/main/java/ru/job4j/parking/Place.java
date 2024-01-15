package ru.job4j.parking;

public interface Place {

    boolean accept(Car car);

    boolean occupied();

    void setOccupied(boolean o);
}
