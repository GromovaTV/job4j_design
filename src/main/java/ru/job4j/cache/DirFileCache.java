package ru.job4j.cache;

import java.nio.file.Files;
import java.nio.file.Paths;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        System.out.println("Загрузка файла в кеш");
        try {
            String content = Files.readString(Paths.get(String.format("%s/%s",
                        this.cachingDir, key)));
            return content;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}