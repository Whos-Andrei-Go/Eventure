/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author andre
 */
import java.math.BigDecimal;

public class TicketType {
    private int id;                // Assuming id is an integer
    private int eventId;           // Assuming event_id is an integer
    private String name;      // Assuming ticket_name is a string
    private BigDecimal price; // Assuming ticket_price is a decimal
    private int quantity;           // Assuming event_id is an integer

    // Constructor
    public TicketType(){
        
    }
    
    public TicketType(int id, int eventId, String name, BigDecimal price, int quantity) {
        this.id = id;
        this.eventId = eventId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public TicketType(String name, BigDecimal price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
     public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "TicketType{" +
                "id=" + id +
                ", eventId=" + eventId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}