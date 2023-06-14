package ru.job4j.ood.isp.menu;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class SimpleMenuPrinterTest {
    @Test
    public void testPrint() {
        final ActionDelegate STUB_ACTION = System.out::println;
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalPrintStream = System.out;
        System.setOut(printStream);
        SimpleMenuPrinter smp = new SimpleMenuPrinter(menu);
        smp.print(menu);
        System.out.flush();
        System.setOut(originalPrintStream);
        String exp = "Сходить в магазин"
                + System.lineSeparator()
                + "----Купить продукты"
                + System.lineSeparator()
                + "--------Купить хлеб"
                + System.lineSeparator()
                + "--------Купить молоко"
                + System.lineSeparator()
                + "Покормить собаку"
                + System.lineSeparator();
        String actualOutput = outputStream.toString();
        assertEquals(exp, actualOutput);
    }
}