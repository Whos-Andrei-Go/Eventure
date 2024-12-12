/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author andre
 */

import java.math.BigDecimal;
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
    
    public Event getEventByTicketTypeId(int ticketTypeId) {
        Event event = null;

        // SQL query to fetch the event associated with the ticket type
        String sql = "SELECT e.* FROM events e "
                + "JOIN TicketTypes tt ON e.id = tt.event_id "
                + "WHERE tt.id = ?";

        try (PreparedStatement stmt = db.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, ticketTypeId);  // Set the ticketTypeId parameter in the query
            ResultSet rs = stmt.executeQuery();

            // Check if the result set contains data
            if (rs.next()) {
                // Create an Event object and populate it from the result set
                int id = rs.getInt("id");
                int creatorId = rs.getInt("creator_id");
                String name = rs.getString("name");
                String location = rs.getString("location");
                String description = rs.getString("description");
                Timestamp startTime = rs.getTimestamp("start_time");
                Timestamp endTime = rs.getTimestamp("end_time");
                
                event = new Event(id, creatorId, name, location, description, startTime, endTime);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Handle any SQL exceptions
        }

        return event;  // Return the event or null if not found
    }

    public Event getEventById(int eventId) {
        Event event = null;

        // SQL query to fetch the event by ID
        String sql = "SELECT * FROM events WHERE id = ?";

        try (PreparedStatement stmt = db.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, eventId);  // Set the eventId parameter in the query
            ResultSet rs = stmt.executeQuery();

            // Check if the result set contains data
            if (rs.next()) {
                // Create an Event object and populate it from the result set
                int id = rs.getInt("id");
                int creatorId = rs.getInt("creator_id");
                String name = rs.getString("name");
                String location = rs.getString("location");
                String description = rs.getString("description");
                Timestamp startTime = rs.getTimestamp("start_time");
                Timestamp endTime = rs.getTimestamp("end_time");

                event = new Event(id, creatorId, name, location, description, startTime, endTime);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Handle any SQL exceptions
        }

        return event;  // Return the event or null if not found
    }
    
    public BigDecimal getEventRevenue(int eventId) {
        BigDecimal revenue = BigDecimal.ZERO;

        // SQL query to fetch tickets for the specified event_id
        String sql = "SELECT t.id, tt.price FROM tickets t "
                + "JOIN ticketTypes tt ON t.ticket_type_id = tt.id "
                + "WHERE tt.event_id = ?";

        try (PreparedStatement stmt = db.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, eventId);  // Set the eventId parameter in the query
            ResultSet rs = stmt.executeQuery();

            // Process the result set
            while (rs.next()) {
                // Add the ticket type's price to the revenue
                revenue = revenue.add(rs.getBigDecimal("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Handle any SQL exceptions
        }

        return revenue;  // Return the event revenue
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
    
    public Event updateEvent(Event event) {
        String query = "UPDATE events SET creator_id = ?, name = ?, location = ?, description = ?, start_time = ?, end_time = ? WHERE id = ?";

        try (Connection conn = db.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, event.getCreatorId());
            pstmt.setString(2, event.getName());
            pstmt.setString(3, event.getLocation());
            pstmt.setString(4, event.getDescription());
            pstmt.setTimestamp(5, new java.sql.Timestamp(event.getStartTimestamp().getTime()));
            pstmt.setTimestamp(6, new java.sql.Timestamp(event.getEndTimestamp().getTime()));
            pstmt.setInt(7, event.getId());  // Update the event with the correct ID

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                return event; // Return the created event with the ID
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    //Wow...
    public boolean deleteEvent(int eventId) {
        Connection conn = null;
        PreparedStatement deleteTicketsStmt = null;
        PreparedStatement deleteTicketTypesStmt = null;
        PreparedStatement deleteEventStmt = null;
        PreparedStatement selectTicketTypesStmt = null;
        ResultSet ticketTypesResultSet = null;

        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);  // Begin transaction

            // Step 1: Get all ticket types for this event
            String selectTicketTypesSql = "SELECT id FROM TicketTypes WHERE event_id = ?";
            selectTicketTypesStmt = conn.prepareStatement(selectTicketTypesSql);
            selectTicketTypesStmt.setInt(1, eventId);
            ticketTypesResultSet = selectTicketTypesStmt.executeQuery();

            // Collect all ticket type IDs for deleting related tickets
            List<Integer> ticketTypeIds = new ArrayList<>();
            while (ticketTypesResultSet.next()) {
                ticketTypeIds.add(ticketTypesResultSet.getInt("id"));
            }

            // Step 2: If there are ticket types, delete tickets related to them
            if (!ticketTypeIds.isEmpty()) {
                String deleteTicketsSql = "DELETE FROM Tickets WHERE ticket_type_id = ?";
                deleteTicketsStmt = conn.prepareStatement(deleteTicketsSql);

                for (int ticketTypeId : ticketTypeIds) {
                    deleteTicketsStmt.setInt(1, ticketTypeId);
                    deleteTicketsStmt.executeUpdate();
                }
            }

            // Step 3: Delete ticket types for this event
            String deleteTicketTypesSql = "DELETE FROM TicketTypes WHERE event_id = ?";
            deleteTicketTypesStmt = conn.prepareStatement(deleteTicketTypesSql);
            deleteTicketTypesStmt.setInt(1, eventId);
            int ticketTypesDeleted = deleteTicketTypesStmt.executeUpdate();

            // Step 4: Delete the event itself
            String deleteEventSql = "DELETE FROM events WHERE id = ?";
            deleteEventStmt = conn.prepareStatement(deleteEventSql);
            deleteEventStmt.setInt(1, eventId);
            int eventDeleted = deleteEventStmt.executeUpdate();

            // If all deletions were successful, commit the transaction
            if (ticketTypesDeleted > 0 || ticketTypeIds.isEmpty()) {  // If there are no ticket types, still commit
                if (eventDeleted > 0) {
                    conn.commit();
                    return true;  // Event and related records were deleted successfully
                }
            }

            conn.rollback();  // Rollback in case something went wrong
            return false;  // Deletion failed

        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();  // Rollback in case of error
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            return false;  // Return false if deletion failed
        } finally {
            try {
                if (deleteTicketsStmt != null) {
                    deleteTicketsStmt.close();
                }
                if (deleteTicketTypesStmt != null) {
                    deleteTicketTypesStmt.close();
                }
                if (deleteEventStmt != null) {
                    deleteEventStmt.close();
                }
                if (selectTicketTypesStmt != null) {
                    selectTicketTypesStmt.close();
                }
                if (ticketTypesResultSet != null) {
                    ticketTypesResultSet.close();
                }
                if (conn != null) {
                    conn.setAutoCommit(true);  // Restore default auto-commit mode
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
