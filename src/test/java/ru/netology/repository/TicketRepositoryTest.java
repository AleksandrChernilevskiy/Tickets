package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Ticket;

public class TicketRepositoryTest {

    TicketRepository repo = new TicketRepository();

    Ticket ticket1 = new Ticket(1, "SPB", "MSK", 200, 65);
    Ticket ticket2 = new Ticket(3, "MSK", "KAZ", 250, 75);
    Ticket ticket3 = new Ticket(5, "TVE", "VOL", 50, 85);
    Ticket ticket4 = new Ticket(7, "SPB", "MSK", 400, 95);
    Ticket ticket5 = new Ticket(9, "KAZ", "UFA", 220, 105);
    Ticket ticket6 = new Ticket(11, "SPB", "MSK", 100, 45);

    @BeforeEach
    public void setup() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
    }

    @Test

    public void shouldAddTicket() {
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldDeleteTicket() {

        repo.removeById(3);
        Ticket[] expected = {ticket1, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}
