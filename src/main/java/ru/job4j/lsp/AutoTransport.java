package ru.job4j.lsp;

class AutoTransport {

    protected float fuel;

    public AutoTransport(float fuel) {
        this.fuel = fuel;
    }

    public void move() {
        if (fuel < 5) { // <= предусловие
            throw new IllegalArgumentException("Need more fuel!");
        } else {
            System.out.println("Move!");
        }
    }
}

