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
                int creatorId = rs.getInt("creator_id");
                String name = rs.getString("name");
                String location = rs.getString("location");
                String description = rs.getString("description");
                Timestamp startTime = rs.getTimestamp("start_time");
                Timestamp endTime = rs.getTimestamp("end_time");

                Event event = new Event(id, creatorId, name, location, description, startTime, endTime);
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Handle exception properly
        }

        return events;
    }
    
    public Event createEvent(Event event) {
        String query = "INSERT INTO events (creator_id, name, location, description, start_time, end_time) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = db.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, event.getCreatorId());
            pstmt.setString(2, event.getName());
            pstmt.setString(3, event.getLocation());
            pstmt.setString(4, event.getDescription());
            pstmt.setTimestamp(5, new java.sql.Timestamp(event.getStartTimestamp().getTime()));
            pstmt.setTimestamp(6, new java.sql.Timestamp(event.getEndTimestamp().getTime()));

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
}
