package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Ticket;
import ru.netology.repository.TicketRepository;

public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, "SPB", "MSK", 200, 65);
    Ticket ticket2 = new Ticket(3, "MSK", "KAZ", 250, 75);
    Ticket ticket3 = new Ticket(5, "TVE", "VOL", 50, 85);
    Ticket ticket4 = new Ticket(7, "SPB", "MSK", 400, 95);
    Ticket ticket5 = new Ticket(9, "KAZ", "UFA", 220, 105);
    Ticket ticket6 = new Ticket(11, "SPB", "MSK", 100, 45);


    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
    }

    @Test
    public void shouldSortTicket() {
        Ticket[] expected = {ticket6, ticket1, ticket4};
        Ticket[] actual = manager.findAll("SPB", "MSK");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNoTicket() {
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("SPB", "EKB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSmallTicket() {
        Ticket[] expected = {ticket2};
        Ticket[] actual = manager.findAll("MSK", "KAZ");

        Assertions.assertArrayEquals(expected, actual);
    }
}
