package ru.job4j.parking;

public class AutoPlace implements Place {
    private boolean occupied;

    public AutoPlace() {
        this.occupied = false;
    }

    @Override
    public void setOccupied(boolean o) {
        this.occupied = o;
    }

    @Override
    public boolean occupied() {
        return occupied;
    }

    @Override
    public boolean accept(Car car) {
        boolean res = car.getSize() == 1 && !this.occupied();
        if (res) {
            this.setOccupied(true);
            System.out.println("Найдено место для легковой машины");
        }
        return res;
    }
}
