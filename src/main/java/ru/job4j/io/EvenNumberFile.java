package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            String separator = System.lineSeparator();
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] array = text.toString().split(separator);
            for (String cell: array) {
                System.out.println(Integer.parseInt(cell) % 2 == 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
