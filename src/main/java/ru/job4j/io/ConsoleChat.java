package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleChat {

    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        List<String> list = readPhrases();
        List<String> log = new LinkedList<>();
        System.out.println("Добро пожаловать в чат!");
        String str = scan.nextLine();
        log.add(str);
        boolean keepOnAnswering = true;
        while (!str.equals(OUT)) {
            if (keepOnAnswering) {
                int num = (int) (Math.random() * list.size());
                System.out.println(list.get(num));
                log.add(list.get(num));
            }
            str = scan.nextLine();
            log.add(str);
            if (str.equals(STOP)) {
                keepOnAnswering = false;
            }
            if (str.equals(CONTINUE)) {
                keepOnAnswering = true;
            }
        }
        System.out.println("Чат закончен.");
        saveLog(log);
    }

    private List<String> readPhrases() {
        List<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers,
                Charset.forName("WINDOWS-1251")))) {
            list = in.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("chat.txt", "answers.txt");
        cc.run();
    }
}
