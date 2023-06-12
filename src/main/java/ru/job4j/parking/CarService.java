package ru.job4j.parking;

public interface CarService {
    boolean findFreePlaces(int number);
    boolean takeCar(Car car);
}
