/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
        if (ticketType == null || ticketType.getEventId() <= 0 || ticketType.getName() == null || ticketType.getName().isEmpty()) {
            return false; // Invalid ticket type
        }

        String sql = "INSERT INTO TicketTypes (event_id, name, price, quantity) VALUES (?, ?, ?, ?)";

        try (Connection conn = db.getConnection(); PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, ticketType.getEventId());
            preparedStatement.setString(2, ticketType.getName());
            preparedStatement.setBigDecimal(3, ticketType.getPrice());
            preparedStatement.setInt(4, ticketType.getQuantity());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; // Return true if at least one row was inserted
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately
            return false; // Return false if there was an error
        }
    }
    
    public boolean updateTicketType(TicketType ticketType) {
        // Validate the ticket type
        if (ticketType == null || ticketType.getId() <= 0 || ticketType.getEventId() <= 0 || ticketType.getName() == null || ticketType.getName().isEmpty()) {
            return false; // Invalid ticket type
        }

        String sql = "UPDATE TicketTypes SET name = ?, price = ?, quantity = ? WHERE id = ? AND event_id = ?";

        try (Connection conn = db.getConnection(); PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, ticketType.getName());
            preparedStatement.setBigDecimal(2, ticketType.getPrice());
            preparedStatement.setInt(3, ticketType.getQuantity());
            preparedStatement.setInt(4, ticketType.getId());
            preparedStatement.setInt(5, ticketType.getEventId());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public TicketType getTicketTypeById(int ticketTypeId) {        
        TicketType ticketType = null;
        String sql = "SELECT * FROM TicketTypes WHERE id = ?";

        try (Connection conn = db.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, ticketTypeId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    ticketType = new TicketType();
                    ticketType.setId(rs.getInt("id"));
                    ticketType.setName(rs.getString("name"));
                    ticketType.setPrice(rs.getBigDecimal("price"));
                    ticketType.setQuantity(rs.getInt("quantity"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ticketType;
    }
    
    public TicketType getTicketTypeByName(String ticketTypeName) {
        TicketType ticketType = null;
        String sql = "SELECT * FROM TicketTypes WHERE name = ?";

        try (Connection conn = db.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, ticketTypeName);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    ticketType = new TicketType();
                    ticketType.setId(rs.getInt("id"));
                    ticketType.setName(rs.getString("name"));
                    ticketType.setPrice(rs.getBigDecimal("price"));
                    ticketType.setQuantity(rs.getInt("quantity"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ticketType;
    }


    public List<TicketType> getTicketTypesByEventId(int eventId) {
        List<TicketType> ticketTypes = new ArrayList<>();

        String sql = "SELECT * FROM tickettypes WHERE event_id = ?";

        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, eventId);

            // Execute the query
            ResultSet rs = stmt.executeQuery();

            // Process the result set and populate the ticketTypes list
            while (rs.next()) {
                TicketType ticketType = new TicketType();
                ticketType.setId(rs.getInt("id"));
                ticketType.setEventId(rs.getInt("event_id"));
                ticketType.setName(rs.getString("name"));
                ticketType.setPrice(rs.getBigDecimal("price"));
                ticketType.setQuantity(rs.getInt("quantity"));

                ticketTypes.add(ticketType);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ticketTypes;
    }
}
