package ru.job4j.food;

import java.time.LocalDate;

public class Food {

    protected String name;
    protected LocalDate expiryDate;
    protected LocalDate createDate;
    protected int price;
    protected int discount;

    public Food(String name, LocalDate expiryDate,
                LocalDate createDate, int price, int discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
