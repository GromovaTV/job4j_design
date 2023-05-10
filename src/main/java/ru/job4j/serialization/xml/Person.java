package ru.job4j.serialization.xml;

public class Person {
    private String name;
    private int age;
    private boolean gender;
    private Contact contact;
    private String[] kids;

    public Person(String name, int age, boolean gender, Contact contact, String[] kids) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
        this.kids = kids;
    }
}
