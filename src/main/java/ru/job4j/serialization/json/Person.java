package ru.job4j.serialization.json;

import java.util.Arrays;

public class Person {
    private final boolean gender;
    private final int age;
    private final Address address;
    private final String[] property;

    public Person(boolean gender, int age, Address address, String[] property) {
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.property = property;
    }

    public boolean isGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{"
                + "gender=" + gender
                + ", age=" + age
                + ", address=" + address
                + ", property=" + Arrays.toString(property)
                + '}';
    }
}
