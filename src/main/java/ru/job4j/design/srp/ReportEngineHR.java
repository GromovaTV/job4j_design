package ru.job4j.design.srp;

import java.util.List;
import java.util.function.Predicate;

public class ReportEngineHR implements Report {

    private Store store;

    public ReportEngineHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> list = store.findBy(filter);
        list.sort((x, y) -> Double.compare(y.getSalary(), x.getSalary()));
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        for (Employee employee : list) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}