package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Person person = new Person(false, 28,
             new Address("Moscow", "Lenin", 20), new String[] {"Flat", "Car"});
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person));
        final String personJson = "{\"gender\":false,"
                        + "\"age\":30,"
                        + "\"address\":"
                        + "{"
                        + "\"city\":\"St. Petersburg\","
                        + "\"street\":\"Nevsky prospect\","
                        + "\"flat\":10"
                        + "},"
                        + "\"property\":"
                        + "[\"Flat\",\"Car\"]"
                        + "}";
        final Person personMod = gson.fromJson(personJson, Person.class);
        System.out.println(personMod);
    }
}
