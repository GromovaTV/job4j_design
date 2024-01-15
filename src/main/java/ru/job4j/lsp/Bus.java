package ru.job4j.lsp;

class Bus extends AutoTransport {

    public Bus(float fuel) {
        super(fuel);
    }

    public void move() {
        if (fuel < 0) { // условие усилено
            throw new IllegalArgumentException("Need more fuel!");
        } else {
            System.out.println("Bus moves!");
        }
    }
}
