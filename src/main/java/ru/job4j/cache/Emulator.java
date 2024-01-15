package ru.job4j.cache;

import java.util.Scanner;

public class Emulator {

    private AbstractCache dc;

    public void setDC(String name) {
        String path = String.format("C:\\projects\\job4j_design\\res/%s", name);
        this.dc =  new DirFileCache(path);
    }

    public void init() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие:\n 1. Указать директорию\n "
                    + "2. Загрузить файл\n 3. Получить файл\n 4. Выход");
            String input = in.nextLine();
            if (input.equals("1")) {
                System.out.println("Введите название директории");
                String name = in.nextLine();
                setDC(name);

            }
            if (input.equals("2")) {
                System.out.println("Введите имя файла для загрузки");
                String fileName = in.nextLine();
                dc.load(fileName);
            }
            if (input.equals("3")) {
                System.out.println("Введите имя файла");
                String fileName = in.nextLine();
                System.out.println(dc.get(fileName));
            }
            if (input.equals("4")) {
                break;
            }
        }

    }

    public static void main(String[] args) {
        Emulator em = new Emulator();
        em.init();
    }
}
