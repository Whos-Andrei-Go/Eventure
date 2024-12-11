package models;

public class CartItem {
    private int ticketTypeId;
    private int quantity;

    public CartItem(int ticketTypeId, int quantity) {
        this.ticketTypeId = ticketTypeId;
        this.quantity = quantity;
    }

    public int getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(int ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
