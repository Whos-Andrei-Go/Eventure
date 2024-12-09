/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.TicketType;
import utility.Database;

/**
 *
 * @author andre
 */
public class TicketController {
    private Database db;

    // Constructor to initialize the database connection
    public TicketController(Database db) {
        this.db = db;
    }
    
    public boolean createTicketType(TicketType ticketType) {
        // Validate the ticket type (you can add more validation as needed)
        if (ticketType == null || ticketType.getEventId() <= 0 || ticketType.getTicketName() == null || ticketType.getTicketName().isEmpty()) {
            return false; // Invalid ticket type
        }

        String sql = "INSERT INTO TicketTypes (event_id, ticket_name, ticket_price) VALUES (?, ?, ?)";

        try (Connection conn = db.getConnection(); PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, ticketType.getEventId());
            preparedStatement.setString(2, ticketType.getTicketName());
            preparedStatement.setBigDecimal(3, ticketType.getTicketPrice());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; // Return true if at least one row was inserted
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately
            return false; // Return false if there was an error
        }
    }
}
