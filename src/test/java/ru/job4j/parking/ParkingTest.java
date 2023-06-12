package ru.job4j.parking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void whenTakeAutoToAutoPlace() {
        Car bmw = new Auto();
        List<Place> places = new LinkedList<>();
        Place p = new AutoPlace();
        places.add(p);
        Parking parking = new Parking(places);
        assertTrue(parking.takeCar(bmw));
    }

    @Test
    public void whenTruckToTruckPlace() {
        Car truck = new Truck(3);
        List<Place> places = new LinkedList<>();
        Place p = new TruckPlace();
        places.add(p);
        Parking parking = new Parking(places);
        assertTrue(parking.takeCar(truck));
    }

    @Test
    public void whenTruckToAutoPlace() {
        Car truck = new Truck(3);
        List<Place> places = new LinkedList<>();
        Place p = new AutoPlace();
        places.add(p);
        places.add(p);
        places.add(p);
        Parking parking = new Parking(places);
        assertTrue(parking.takeCar(truck));
    }

    @Test
    public void whenTrucksToAutoAndTruckPlaces() {
        Car truck = new Truck(3);
        List<Place> places = new LinkedList<>();
        Place p = new AutoPlace();
        Place t = new TruckPlace();
        places.add(t);
        places.add(p);
        places.add(p);
        places.add(p);
        Parking parking = new Parking(places);
        assertTrue(parking.takeCar(truck));
        assertTrue(parking.takeCar(truck));
    }

    @Test
    public void whenTruckAndAutoToAutoPlace() {
        Car truck = new Truck(3);
        List<Place> places = new LinkedList<>();
        Place p = new AutoPlace();
        places.add(p);
        places.add(p);
        places.add(p);
        Parking parking = new Parking(places);
        assertTrue(parking.takeCar(truck));
    }

    @Test
    public void whenNoPlaceToTruck() {
        Car truck = new Truck(4);
        List<Place> places = new LinkedList<>();
        Place p = new AutoPlace();
        places.add(p);
        places.add(p);
        places.add(p);
        Parking parking = new Parking(places);
        assertFalse(parking.takeCar(truck));
    }

    @Test
    public void whenNoPlaceToAuto() {
        Car bmw = new Auto();
        Car truck = new Truck(3);
        List<Place> places = new LinkedList<>();
        Place p = new AutoPlace();
        places.add(p);
        places.add(p);
        places.add(p);
        Parking parking = new Parking(places);
        parking.takeCar(truck);
        assertFalse(parking.takeCar(bmw));
    }

    @Test
    public void whenTake10AutoToAutoPlace() {
        Car bmw = new Auto();
        List<Place> places = new ArrayList<>(10);
        Place p = new AutoPlace();
        for (int i = 0; i < places.size(); i++) {
            places.add(p);
        }
        Parking parking = new Parking(places);
        for (int i = 0; i < places.size(); i++) {
            parking.takeCar(bmw);
        }
        assertFalse(parking.takeCar(bmw));
    }
}