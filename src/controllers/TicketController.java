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
import models.Ticket;
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
    
    public boolean addTicketsToDatabase(int ticketTypeId, int quantity, int userId) {
        // Assuming you have a method to retrieve the TicketType
        TicketType ticketType = getTicketTypeById(ticketTypeId);  // Get the ticket type from DB
        if (ticketType == null) {
            return false;  // Ticket type not found
        }

        // Get the current date for the purchase
        java.sql.Date purchaseDate = new java.sql.Date(System.currentTimeMillis());

        // Now insert N tickets into the database with the user_id and current purchase date
        try {
            String sql = "INSERT INTO tickets (user_id, ticket_type_id, purchase_date) VALUES (?, ?, ?)";
            PreparedStatement stmt = db.getConnection().prepareStatement(sql);

            // Insert the tickets one by one
            for (int i = 0; i < quantity; i++) {
                stmt.setInt(1, userId);  // Set the user_id
                stmt.setInt(2, ticketTypeId);  // Set the ticket_type_id
                stmt.setDate(3, purchaseDate);  // Set the current date as purchase date
                stmt.addBatch();  // Add to batch
            }

            // Execute the batch insert
            int[] rowsAffected = stmt.executeBatch();

            return rowsAffected.length == quantity;  // If all rows were inserted, return true
        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Return false if there's an error
        }
    }

    public List<Ticket> getTickets() {
        List<Ticket> tickets = new ArrayList<>();

        // SQL query to fetch tickets for the specified user_id
        String sql = "SELECT * FROM tickets";

        try (PreparedStatement stmt = db.getConnection().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            // Process the result set
            while (rs.next()) {
                // Create a Ticket object and populate it from the result set
                Ticket ticket = new Ticket();
                ticket.setId(rs.getInt("id"));
                ticket.setUserId(rs.getInt("user_id"));
                ticket.setTicketTypeId(rs.getInt("ticket_type_id"));
                ticket.setPurchaseDate(rs.getTimestamp("purchase_date"));

                // Add the ticket to the list
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Handle any SQL exceptions
        }

        return tickets;  // Return the list of tickets
    }
    
    public List<Ticket> getTicketsByUserId(int userId) {
        List<Ticket> tickets = new ArrayList<>();

        // SQL query to fetch tickets for the specified user_id
        String sql = "SELECT * FROM tickets WHERE user_id = ?";

        try (PreparedStatement stmt = db.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, userId);  // Set the userId parameter in the query
            ResultSet rs = stmt.executeQuery();

            // Process the result set
            while (rs.next()) {
                // Create a Ticket object and populate it from the result set
                Ticket ticket = new Ticket();
                ticket.setId(rs.getInt("id"));
                ticket.setUserId(rs.getInt("user_id"));
                ticket.setTicketTypeId(rs.getInt("ticket_type_id"));
                ticket.setPurchaseDate(rs.getTimestamp("purchase_date"));

                // Add the ticket to the list
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Handle any SQL exceptions
        }

        return tickets;  // Return the list of tickets
    }
    
    public List<Ticket> getTicketsByEventId(int eventId) {
        List<Ticket> tickets = new ArrayList<>();

        // SQL query to fetch tickets for the specified event_id
        String sql = "SELECT t.* FROM tickets t "
                + "JOIN ticketTypes tt ON t.ticket_type_id = tt.id "
                + "WHERE tt.event_id = ?";

        try (PreparedStatement stmt = db.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, eventId);  // Set the eventId parameter in the query
            ResultSet rs = stmt.executeQuery();

            // Process the result set
            while (rs.next()) {
                // Create a Ticket object and populate it from the result set
                Ticket ticket = new Ticket();
                ticket.setId(rs.getInt("id"));
                ticket.setUserId(rs.getInt("user_id"));
                ticket.setTicketTypeId(rs.getInt("ticket_type_id"));
                ticket.setPurchaseDate(rs.getTimestamp("purchase_date"));

                // Add the ticket to the list
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Handle any SQL exceptions
        }

        return tickets;  // Return the list of tickets
    }
    
    public int getEventTicketsSold(int eventId) {
        int ticketsSold = 0;

        // SQL query to fetch tickets for the specified event_id
        String sql = "SELECT COUNT(t.id) FROM tickets t "
                + "JOIN ticketTypes tt ON t.ticket_type_id = tt.id "
                + "WHERE tt.event_id = ?";

        try (PreparedStatement stmt = db.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, eventId);  // Set the eventId parameter in the query
            ResultSet rs = stmt.executeQuery();

            // Process the result set
            if (rs.next()) {
                // Get the count of tickets sold
                ticketsSold = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Handle any SQL exceptions
        }

        return ticketsSold;  // Return the number of tickets sold
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
