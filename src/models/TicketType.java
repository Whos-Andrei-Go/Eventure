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
    private String ticketName;      // Assuming ticket_name is a string
    private BigDecimal ticketPrice; // Assuming ticket_price is a decimal

    // Constructor
    public TicketType(){
        
    }
    
    public TicketType(int id, int eventId, String ticketName, BigDecimal ticketPrice) {
        this.id = id;
        this.eventId = eventId;
        this.ticketName = ticketName;
        this.ticketPrice = ticketPrice;
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

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "TicketType{" +
                "id=" + id +
                ", eventId=" + eventId +
                ", ticketName='" + ticketName + '\'' +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}