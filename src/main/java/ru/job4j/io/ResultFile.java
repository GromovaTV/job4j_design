package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {

    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("src/main/java/multiplicationTable.txt")) {
            int[][] data = new int[10][10];
            for (int row = 1; row < 10; row++) {
                for (int cell = 1; cell < 10; cell++) {
                    out.write((row * cell + " ").getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
