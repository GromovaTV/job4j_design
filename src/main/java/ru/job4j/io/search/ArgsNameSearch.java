package ru.job4j.io.search;
import java.util.HashMap;
import java.util.Map;

public class ArgsNameSearch {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException();
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        for (String arg : args) {
            var split = arg.split("-", 2);
            var keyValue = split[1].split("=", 2);
            var key = keyValue[0];
            var value = keyValue[1];
            if (key.isEmpty() || value.isEmpty()) {
                throw new IllegalArgumentException();
            }
            values.put(key, value);
        }
    }

    public static ArgsNameSearch of(String[] args) {
        ArgsNameSearch names = new ArgsNameSearch();
        names.parse(args);
        return names;
    }

//    public static void main(String[] args) {
//        ArgsNameSearch jvm = ArgsNameSearch.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
//        System.out.println(jvm.get("Xmx"));
//        ArgsNameSearch zip = ArgsNameSearch.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
//        System.out.println(zip.get("out"));
//    }
}