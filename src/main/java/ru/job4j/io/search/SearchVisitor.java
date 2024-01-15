package ru.job4j.io.search;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class SearchVisitor  extends SimpleFileVisitor<Path> {

    private String typeSearch;
    private String key;
    private List<Path> list = new LinkedList<>();

    public SearchVisitor(ArgsNameSearch keys) {
        this.typeSearch = keys.get("t");
        this.key = keys.get("n");
    }

    public List<Path> getList() {
        return list;
    }

    public Predicate<String> predicate = s -> {
        if (typeSearch.equals("name")) {
            return s.equals(key);
        }
        if (typeSearch.equals("regex")) {
            return s.contains(key);
        }
        if (typeSearch.equals("mask")) {
            int j = 0;
            int i;
            boolean skip = false;
            char[] arrKey = key.toCharArray();
            char[] arrName = s.toCharArray();
            for (i = 0; i < arrKey.length; i++) {
                if (String.valueOf(arrKey[i]).equals("*")) {
                    skip = true;
                    continue;
                }
                if (skip) {
                    while (j < arrName.length) {
                        if (arrKey[i] == arrName[j]) {
                            skip = false;
                            break;
                        }
                        j++;
                    }
                    if (j >= arrName.length) {
                        return false;
                    }
                }
                if (String.valueOf(arrKey[i]).equals("?")) {
                    j++;
                    if (j >= arrName.length) {
                        return false;
                    }
                    continue;
                }
                if (arrKey[i] == arrName[j]) {
                    j++;
                } else {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalArgumentException("Invalid data type specified.".concat(
                " Available argument \"name\" or \"mask\" or \"regex\"."));
    };

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (predicate.test(file.toFile().getName())) {
            list.add(file.toAbsolutePath());
            System.out.println(file.toAbsolutePath());
        }
        return super.visitFile(file, attrs);
    }
}