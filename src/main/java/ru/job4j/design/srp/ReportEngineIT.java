package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportEngineIT implements Report {

    private Store store;

    public ReportEngineIT(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<!DOCTYPE html>");
        text.append("<html>");
        text.append("<head><title>Employees</title></head>");
        text.append("<body>");
        text.append("Name; Hired; Fired; Salary;");
        for (Employee employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append("<br>")
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        text.append("</body>");
        text.append("</html>");
        return text.toString();
    }
}