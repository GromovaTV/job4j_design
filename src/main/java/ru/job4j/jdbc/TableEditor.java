package ru.job4j.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;
    private Properties properties;


    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws Exception {
        Class.forName(properties.getProperty("hibernate.connection.driver_class"));
        String url = properties.getProperty("hibernate.connection.url");
        String login = properties.getProperty("hibernate.connection.username");
        String password = properties.getProperty("hibernate.connection.password");
        connection = DriverManager.getConnection(url, login, password);

    }

    public void execute(String sql) throws Exception {
        Statement statement = connection.createStatement();
        statement.execute(sql);
    }

    public void createTable(String tableName) throws Exception {
        String sql = String.format(
                        "create table %s();", tableName
                );
        execute(sql);
        System.out.println(TableEditor.getTableScheme(connection, tableName));

    }

    public void dropTable(String tableName) throws Exception {
        String sql = String.format(
                "DROP TABLE %s;", tableName
        );
        execute(sql);
        System.out.printf("Table %s has been deleted", tableName);
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        String sql = String.format(
                "ALTER TABLE %s ADD COLUMN %s %s;", tableName, columnName, type
        );
        execute(sql);
        System.out.println(TableEditor.getTableScheme(connection, tableName));
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        String sql = String.format(
                "ALTER TABLE %s DROP COLUMN %s;", tableName, columnName
        );
        execute(sql);
        System.out.println(TableEditor.getTableScheme(connection, tableName));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        String sql = String.format(
                "ALTER TABLE %s RENAME COLUMN %s TO %s;", tableName, columnName, newColumnName
        );
        execute(sql);
        System.out.println(TableEditor.getTableScheme(connection, tableName));
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}