package ru.job4j.tdd;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CinemaTest {
    @Test
    public void whenBuy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test
    public void whenFind() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenColumnInvalid() {
        Cinema cinema = new Cinema3D();
        Account account = new AccountCinema();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 10, -1, date);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenRowInvalid() {
        Cinema cinema = new Cinema3D();
        Account account = new AccountCinema();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, -1, 10, date);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenDateInvalid() {
        Cinema cinema = new Cinema3D();
        Account account = new AccountCinema();
        Calendar date = Calendar.getInstance();
        date.set(2000, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 10, 1, date);
    }
}