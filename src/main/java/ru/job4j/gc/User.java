package ru.job4j.gc;

public class User {

    private String name;
    private int id;

    public User() {
    }

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s%n", id, name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
