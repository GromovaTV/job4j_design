package ru.job4j.design.srp;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.function.Predicate;

public class ReportEngineJSON implements Report {
    private Store store;

    public ReportEngineJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        var resList = new ArrayList<>();
        for (Employee employee : store.findBy(filter)) {
            resList.add(employee);
        }
        var res = new GsonBuilder().create();
        return res.toJson(resList);
    }
}