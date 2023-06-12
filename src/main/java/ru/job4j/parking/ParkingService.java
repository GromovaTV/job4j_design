package ru.job4j.parking;

public interface ParkingService {
    boolean findFreePlaces(int number);
    boolean takeCar(Car car);
}
