package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public List<String> filter(String file) {

        List<String> list = new LinkedList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            list = in.lines().filter(s -> {
                String[] array = s.split(" ");
                return array.length > 1 && array[array.length - 2].equals("404");
            }).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter();
        List<String> log = logFilter.filter("log.txt");
        log.forEach(System.out::println);
    }
}
