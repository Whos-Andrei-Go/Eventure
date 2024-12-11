/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author andre
 */
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import models.Ticket;
import models.TicketType;
import models.User;
import utility.Database;

public class CartController {

    // A list to store the tickets in the cart
    private List<Ticket> cart;
    private TicketController ticketController;

    public CartController() {
        this.cart = new ArrayList<>();  // Initialize the cart
    }
    
    public CartController(Database db) {
        this.cart = new ArrayList<>();  // Initialize the cart
        ticketController = new TicketController(db);
    }

    // Method to add a ticket to the cart
    public void addTicketToCart(Ticket ticket) {
        cart.add(ticket);
    }

    // Method to remove a ticket from the cart by ticket ID
    public boolean removeTicketFromCart(int ticketId) {
        for (Ticket ticket : cart) {
            if (ticket.getId() == ticketId) {
                cart.remove(ticket);
                return true;  // Successfully removed
            }
        }
        return false;  // Ticket with the given ID not found in the cart
    }

    // Method to get the total number of tickets in the cart
    public int getTotalTickets() {
        return cart.size();
    }

    // Method to get the total price of all tickets in the cart
    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = BigDecimal.ZERO;

        for (Ticket ticket : cart) {
            TicketType ticketType = ticketController.getTicketTypeById(ticket.getTicketTypeId());  // Replace with actual method to fetch TicketType
        
            if (ticketType != null) {
                totalPrice = totalPrice.add(ticketType.getPrice());  // Add the price from the TicketType
            }
        }

        return totalPrice;
    }

    // Method to view the current cart contents
    public List<Ticket> getCartContents() {
        return cart;
    }

    // Method to clear all items in the cart
    public void clearCart() {
        cart.clear();
    }

    // Method to perform checkout (could involve creating an order, etc.)
    public boolean checkout(User user) {
        if (cart.isEmpty()) {
            return false;  // Cart is empty, can't proceed with checkout
        }

        // Logic to process the checkout (e.g., save the order, reduce ticket availability, etc.)
        for (Ticket ticket : cart) {
            // This is where you'd save ticket purchases to the database
            // For example, you might save the ticket to a database or mark it as purchased
            // Also, update ticket status and reduce the quantity of the ticket type
        }

        // Clear the cart after checkout is successful
        clearCart();
        return true;
    }
}
