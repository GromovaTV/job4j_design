package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /* JSONObject из json-строки строки */
        JSONObject jsonAddress = new JSONObject("{"
                + "\"city\":\"St. Petersburg\","
                + "\"street\":\"Nevsky prospect\","
                + "\"flat\":10"
                + "}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("Flat");
        list.add("Car");
        JSONArray jsonProperties = new JSONArray(list);

        /* JSONObject напрямую методом put */
        final Person person = new Person(false, 28,
             new Address("Moscow", "Lenin", 20), new String[] {"Flat", "Car"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("gender", person.isGender());
        jsonObject.put("age", person.getAge());
        jsonObject.put("address", jsonAddress);
        jsonObject.put("properties", jsonProperties);

        /* Выведем результат в консоль */
        System.out.println(jsonObject.toString());
        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(person).toString());
    }
}
