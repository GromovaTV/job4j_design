package ru.job4j.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.*;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        Set<Integer> filterSet = new HashSet<>();
        List<String> list = new LinkedList<>();
        boolean firstLine = true;
        try (var scanner = new Scanner(Path.of(argsName.get("path")))) {
            while (scanner.hasNextLine()) {
                String search = "";
                List<String> tmpList = new LinkedList<>();
                String s = scanner.nextLine();
                var line = s.split(argsName.get("delimiter"));
                if (firstLine) {
                    for (int index = 0; index < line.length; index++) {
                    if (argsName.get("filter").contains(line[index])) {
                        filterSet.add(index);
                    }
                }
                firstLine = false;
                }
                for (int index = 0; index < line.length; index++) {
                    if (filterSet.contains(index)) {
                        tmpList.add(line[index]);
                    }
                }
                search = String.join(";", tmpList);
                System.out.println(search);
                list.add(search);
            }
        }
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(new FileOutputStream(argsName.get("out"))))) {
            out.println(String.join(System.lineSeparator(), list));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

