/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author andre
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Event;
import models.TicketType;
import utility.Database;

public class EventController {

    private Database db;

    // Constructor to initialize the database connection
    public EventController(Database db) {
        this.db = db;
    }
    
    public EventController(){}
    
    public List<Event> getEvents() {
        List<Event> events = new ArrayList<>();
        String query = "SELECT * FROM events";  // Adjust the SQL query if needed

        try (Connection conn = db.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Timestamp startTime = rs.getTimestamp("start_time");
                Timestamp endTime = rs.getTimestamp("end_time");

                Event event = new Event(id, name, description, startTime, endTime);
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Handle exception properly
        }

        return events;
    }
    
    public Event createEvent(Event event) {
        String query = "INSERT INTO events (name, description, location, start_time, end_time) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = db.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, event.getName());
            pstmt.setString(2, event.getDescription());
            pstmt.setString(3, event.getLocation());
            pstmt.setTimestamp(4, new java.sql.Timestamp(event.getStartTimestamp().getTime()));
            pstmt.setTimestamp(5, new java.sql.Timestamp(event.getEndTimestamp().getTime()));

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                // Retrieve the generated keys (event ID)
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        event.setId(generatedKeys.getInt(1)); // Set the generated ID
                        return event; // Return the created event with the ID
                    }
                } 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
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
