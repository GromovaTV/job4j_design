package ru.job4j.jdbc;

import java.io.FileInputStream;
import java.util.Properties;

public class StatementDemo {

    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("C:\\projects\\job4j_design\\app.properties");
        Properties properties = new Properties();
        properties.load(in);
        TableEditor te = new TableEditor(properties);
        te.createTable("newTable");
        te.addColumn("newTable", "number", "text");
        te.renameColumn("newTable", "number", "name");
        te.dropColumn("newTable", "name");
        te.dropTable("newTable");
    }
}
