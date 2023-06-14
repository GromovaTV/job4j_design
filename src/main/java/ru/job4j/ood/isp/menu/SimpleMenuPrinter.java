package ru.job4j.ood.isp.menu;

public class SimpleMenuPrinter implements MenuPrinter {
    private Menu menu;

    public SimpleMenuPrinter(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void print(Menu menu) {
        menu.forEach(i -> {
            String[] num = i.getNumber().split("\\.");
            String line = "";
            for (int j = 0; j < num.length - 1; j++) {
                line = line.concat("----");
            }
            System.out.println(line + i.getName());
        });
    }
}
