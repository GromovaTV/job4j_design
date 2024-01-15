package ru.job4j.parking;

public class TruckPlace implements Place {

    private boolean occupied;

    public TruckPlace() {
        this.occupied = false;
    }

    @Override
    public void setOccupied(boolean o) {
        this.occupied = o;
    }

    @Override
    public boolean occupied() {
        return this.occupied;
    }

    @Override
    public boolean accept(Car car) {
        boolean res = car.getSize() > 1 && !this.occupied();
        if (res) {
            System.out.println("Найдено место для грузовой машины");
        }
        return res;
    }
}