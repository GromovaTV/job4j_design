package ru.job4j.parking;

import java.util.LinkedList;
import java.util.List;

public class Parking implements ParkingService {

    private List<Place> places;

    public Parking(List<Place> places) {
        this.places = places;
    }

    @Override
    public boolean findFreePlaces(int num) {
        int count = 0;
        List<Place> list = new LinkedList<>();
        for (Place place : places) {
            if (!place.occupied()) {
                count++;
                list.add(place);
                if (count == num) {
                    for (Place l : list) {
                        l.setOccupied(true);
                    }
                    return true;
                }
            } else {
                count = 0;
                list.removeAll(list);
            }
        }
        return false;
    }

    @Override
    public boolean takeCar(Car car) {
        for (Place place : places) {
            if (place.accept(car)) {
                place.setOccupied(true);
                return true;
            }
        }
        if (car.getSize() > 1 && findFreePlaces(car.getSize())) {
            System.out.println("Найдено место для грузовой машины");
            return true;
        }
        System.out.println("Свободных мест нет");
        return false;
    }
}
