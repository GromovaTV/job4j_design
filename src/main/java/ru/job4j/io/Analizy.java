package ru.job4j.io;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Analizy {

    public void unavailable(String source, String target) {
        List<String> list = new LinkedList<>();
        String begin = "";
        String end = "";
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                String[] str = line.split(" ");
                if (begin.equals("") && (str[0].equals("400") || str[0].equals("500"))) {
                    begin = str[1];
                }
                if (!begin.equals("") && (str[0].equals("200") || str[0].equals("300"))) {
                     end = str[1];
                }
                if (!end.equals("")) {
                    list.add(begin + ";" + end + ";");
                    begin = "";
                    end = "";
                }
            }
            if (!begin.equals("") && end.equals("")) {
                list.add(begin + ";");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            list.stream().forEach(out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}