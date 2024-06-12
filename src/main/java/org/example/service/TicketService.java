package org.example.service;

import org.example.model.Ticket;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;


public class TicketService {
    static List<Ticket> ticketList;
    public static void main(String[] args) {
        Ticket firstTicket = new Ticket("1234", "Hall 1", "123", Instant.now().getEpochSecond(), true, "A", 154.34, new BigDecimal("43.9"));

        Ticket secondTicket = new Ticket("2", "Hall 2", "002", false, "B", 154.35, new BigDecimal("222"));

        Ticket thirdTicket = new Ticket("3", "Hall 2", "123", Instant.now().getEpochSecond(), true, "C", 154.34, new BigDecimal("43.9"));

        ticketList = Arrays.asList(firstTicket, secondTicket, thirdTicket);

        System.out.println("Find ticket by sector: " + getTicketByStadiumSector("a"));

    }
    public static Ticket getTicketByStadiumSector (String stadiumSector){
        return ticketList.stream()
                .filter(ticket -> ticket.getStadiumSector().equalsIgnoreCase(stadiumSector))
                .findAny()
                .orElse(null);
    }
}
