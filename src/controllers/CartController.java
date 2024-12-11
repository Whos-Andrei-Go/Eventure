package controllers;

import models.Cart;
import models.Ticket;
import models.TicketType;
import utility.Database;
import java.math.BigDecimal;
import java.util.Map;

public class CartController {
    private TicketController ticketController;
    private Cart cart;

    public CartController(Database db) {
        this.ticketController = new TicketController(new Database());
        this.cart = Cart.getInstance();
    }

    public boolean addTicketToCart(int ticketTypeId, int quantity) {
        // Add or update the quantity of the ticket type in the cart
        return cart.addTicket(ticketTypeId, quantity);
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Map.Entry<Integer, Integer> entry : cart.getTickets().entrySet()) {
            int ticketTypeId = entry.getKey();
            int quantity = entry.getValue();

            TicketType ticketType = ticketController.getTicketTypeById(ticketTypeId);
            if (ticketType != null) {
                BigDecimal ticketTotalPrice = ticketType.getPrice().multiply(BigDecimal.valueOf(quantity));
                totalPrice = totalPrice.add(ticketTotalPrice);
            }
        }
        return totalPrice;
    }

    public void clearCart() {
        cart.clearCart();
    }

    public int getTotalQuantity() {
        return cart.getTotalQuantity();
    }
}
