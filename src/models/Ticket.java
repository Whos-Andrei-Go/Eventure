/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author andre
 */
import java.util.Date;

public class Ticket {

    private int id;  // Ticket ID
    private int userId;  // The ID of the user who purchased the ticket
    private int ticketTypeId;  // The ID of the ticket type
    private Date purchaseDate;  // Date when the ticket was purchased
    private String status;  // The status of the ticket (e.g., "Active", "Used")
    private String qrCode;  // The QR code associated with the ticket

    // Default constructor
    public Ticket() {
    }

    // Constructor with parameters
    public Ticket(int id, int userId, int ticketTypeId, Date purchaseDate, String status, String qrCode) {
        this.id = id;
        this.userId = userId;
        this.ticketTypeId = ticketTypeId;
        this.purchaseDate = purchaseDate;
        this.status = status;
        this.qrCode = qrCode;
    }

    // Getter and setter methods for each field

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(int ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", userId=" + userId +
                ", ticketTypeId=" + ticketTypeId +
                ", purchaseDate=" + purchaseDate +
                ", status='" + status + '\'' +
                ", qrCode='" + qrCode + '\'' +
                '}';
    }
}
