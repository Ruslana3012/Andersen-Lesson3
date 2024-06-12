package org.example.service;

import org.example.model.Ticket;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class TicketService {
    public static List<Ticket> tickets;

    public static void main(String[] args) {
        Ticket ticket1 = new Ticket("1234", "Hall 1", "123", Instant.now().getEpochSecond(), true, "A", 154.34, new BigDecimal("43.9"));
        Ticket ticket2 = new Ticket("2134", "Hall 1", "124", Instant.now().getEpochSecond(), true, "A", 154.34, new BigDecimal("43.9"));
        Ticket ticket3 = new Ticket("2314", "Hall 1", "125", Instant.now().getEpochSecond(), true, "A", 154.34, new BigDecimal("43.9"));
        Ticket ticket4 = new Ticket("1324", "Hall 1", "126", Instant.now().getEpochSecond(), true, "A", 154.34, new BigDecimal("43.9"));
        Ticket ticket5 = new Ticket("1342", "Hall 1", "127", Instant.now().getEpochSecond(), true, "A", 154.34, new BigDecimal("43.9"));
        Ticket ticket6 = new Ticket("1243", "Hall 1", "128", Instant.now().getEpochSecond(), true, "A", 154.34, new BigDecimal("43.9"));
        Ticket ticket7 = new Ticket("2341", "Hall 1", "129", Instant.now().getEpochSecond(), true, "A", 154.34, new BigDecimal("43.9"));
        Ticket ticket8 = new Ticket("4321", "Hall 1", "130", Instant.now().getEpochSecond(), true, "A", 154.34, new BigDecimal("43.9"));
        Ticket ticket9 = new Ticket("4213", "Hall 1", "131", Instant.now().getEpochSecond(), true, "A", 154.34, new BigDecimal("43.9"));
        Ticket ticket10 = new Ticket("4231", "Hall 1", "132", Instant.now().getEpochSecond(), true, "A", 154.34, new BigDecimal("43.9"));

        tickets = Arrays.asList(ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9, ticket10);

        System.out.println(getTicketByID("4231"));
    }

    public static Ticket getTicketByID(String ID) {
        return tickets.stream()
                .filter(ticket -> ID.equals(ticket.getID()))
                .findAny()
                .orElse(null);
    }
}
