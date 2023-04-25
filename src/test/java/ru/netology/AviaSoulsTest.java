package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.SortedMap;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Воронеж", "Астрахань", 8_700, 20, 3);
    Ticket ticket2 = new Ticket("Санкт-петербург", "Краснодар", 10_400, 11, 13);
    Ticket ticket3 = new Ticket("Бердск", "Берёзовский", 10_400, 9, 10);
    Ticket ticket4 = new Ticket("Москва", "Архангельск", 5_600, 10, 12);
    Ticket ticket5 = new Ticket("Асино", "Армавир", 3_750, 4, 7);
    Ticket ticket6 = new Ticket("Бердск", "Берёзовский", 15_450, 15, 17);
    Ticket ticket7 = new Ticket("Бийск", "Белоярский", 9_750, 16, 17);
    Ticket ticket8 = new Ticket("Бердск", "Берёзовский", 16_500, 18, 19);
    AviaSouls aviaSouls = new AviaSouls();

    @BeforeEach
    public void setup() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
    }

    @Test
    public void functionCompareToTestFirst() {
        int expected = -1;
        int actual = ticket1.compareTo(ticket8);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void functionCompareToTestSecond() {
        int expected = 1;
        int actual = ticket6.compareTo(ticket4);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void functionCompareToTestThird() {
        int expected = 0;
        int actual = ticket3.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void functionSearchTestFourth() {
        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("Курск", "Париж");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void functionSearchTestFifth() {
        Ticket[] expected = {ticket4};
        Ticket[] actual = aviaSouls.search("Москва", "Архангельск");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void functionSearchTestSixth() {
        Ticket[] expected = {ticket3, ticket6, ticket8};
        Ticket[] actual = aviaSouls.search("Бердск", "Берёзовский");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void functionComparatorTestSeventh() {
        TicketTimeComparator comparator = new TicketTimeComparator();
        int expected = 1;
        int actual = comparator.compare(ticket1, ticket4);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void functionComparatorTestEighth() {
        TicketTimeComparator comparator = new TicketTimeComparator();
        int expected = -1;
        int actual = comparator.compare(ticket3, ticket5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void functionComparatorTestNinth() {
        TicketTimeComparator comparator = new TicketTimeComparator();
        int expected = 0;
        int actual = comparator.compare(ticket4, ticket6);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void functionSearchAndSortByTestTenth() {
        TicketTimeComparator comparator = new TicketTimeComparator();
        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.searchAndSortBy("Курск", "Париж", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void functionSearchAndSortByTestEleventh() {
        TicketTimeComparator comparator = new TicketTimeComparator();
        Ticket[] expected = {ticket7};
        Ticket[] actual = aviaSouls.searchAndSortBy("Бийск", "Белоярский", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void functionSearchAndSortByTestTwelfth() {
        TicketTimeComparator comparator = new TicketTimeComparator();
        Ticket[] expected = {ticket3, ticket8, ticket6};
        Ticket[] actual = aviaSouls.searchAndSortBy("Бердск", "Берёзовский", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void functionFindAllTestThirteenth() {
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8};
        Ticket[] actual = aviaSouls.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}