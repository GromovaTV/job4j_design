package ru.job4j.serialization.json;

public class Address {
    private String city;
    private String street;
    private int flat;

    public Address(String city, String street, int flat) {
        this.city = city;
        this.street = street;
        this.flat = flat;
    }

    @Override
    public String toString() {
        return "Address{"
                + "city='" + city + '\''
                + ", street='" + street + '\''
                + ", flat=" + flat + '}';
    }
}
