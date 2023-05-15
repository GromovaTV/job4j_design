package ru.job4j.io.search;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SearchFiles {

    public static void main(String[] args) throws IOException {
        ArgsNameSearch keys = ArgsNameSearch.of(args);
        Path start = Paths.get(keys.get("d"));
        String target =  Paths.get(keys.get("o")).toString();
        validation(args, start);
        List<Path> list = search(start, keys);
        try (PrintWriter pw = new PrintWriter(new FileWriter(target, Charset.forName("WINDOWS-1251"), true))) {
            list.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Path> search(Path root, ArgsNameSearch keys) throws IOException {
        SearchVisitor searcher = new SearchVisitor(keys);
        Files.walkFileTree(root, searcher);
        return searcher.getList();

    }

    public static void validation(String[] args, Path start) {
        if (args.length < 4) {
            throw new IllegalArgumentException("Insufficient number of input parameters. Usage java -jar dir.jar ROOT_FOLDER SEARCH_PARAMETER.");
        }
        if (!start.toFile().exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", start.toFile().getAbsoluteFile()));
        }
        if (!start.toFile().isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", start.toFile().getAbsoluteFile()));
        }
    }
}