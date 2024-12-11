package models;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Integer, Integer> tickets; // Maps TicketTypeId to quantity
    private static Cart instance;

    private Cart() {
        tickets = new HashMap<>();
    }

    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    // Returns the current ticket counts as a Map
    public Map<Integer, Integer> getTickets() {
        return tickets;
    }

    // Adds tickets to the cart, updating the quantity for the given TicketTypeId
    public boolean addTicket(int ticketTypeId, int quantity) {
        if (quantity <= 0) {
            return false; // Do not allow invalid quantities
        }
        tickets.put(ticketTypeId, tickets.getOrDefault(ticketTypeId, 0) + quantity);
        return true;
    }

    // Clears all tickets from the cart
    public void clearCart() {
        tickets.clear();
    }

    // Calculates the total quantity of tickets in the cart
    public int getTotalQuantity() {
        int totalQuantity = 0;
        for (int quantity : tickets.values()) {
            totalQuantity += quantity;
        }
        return totalQuantity;
    }
}
