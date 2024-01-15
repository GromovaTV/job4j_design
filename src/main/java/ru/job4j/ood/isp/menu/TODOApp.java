package ru.job4j.ood.isp.menu;

import java.util.Scanner;

public class TODOApp {

    public static final ActionDelegate STUB_ACTION = System.out::println;

    public static void main(String[] args) {
        Menu menu = new SimpleMenu();
        MenuPrinter printer = new SimpleMenuPrinter(menu);
        Scanner scanner = new Scanner(System.in);
        String task;
        String action;
        while (true) {
            System.out.print("1. Добавить задачу" + System.lineSeparator()
                + "2. Добавить действие" + System.lineSeparator() + "3. Выход"
            );
            String in = scanner.nextLine();
            if (in.equals("1")) {
                System.out.println("Введите название задачи");
                 task = scanner.nextLine();
                menu.add(Menu.ROOT, task, STUB_ACTION);
            }
            if (in.equals("2")) {
                System.out.println("Введите название задачи");
                task = scanner.nextLine();
                System.out.println("Введите название действия");
                action = scanner.nextLine();
                menu.add(task, action, STUB_ACTION);
            }
            if (in.equals("3")) {
                break;
            }
            printer.print(menu);
        }
    }
}
