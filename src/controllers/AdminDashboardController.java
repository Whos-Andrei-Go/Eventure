/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.Dimension;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.Box;
import models.Event;
import models.Ticket;
import models.TicketType;
import utility.Database;
import utility.Session;
import views.shared.components.pnlEvent;

/**
 *
 * @author andre
 */
public class AdminDashboardController {
    private Database db;
    private EventController eventController;
    private TicketController ticketController;
    
    public AdminDashboardController(Database db){
        this.db = db;
        eventController = new EventController(db);
        ticketController = new TicketController(db);
        
    }
    
    public int getTotalTicketsSold() {
        // SQL query to fetch tickets for the specified user_id
        String sql = "SELECT COUNT(*) FROM Tickets";

        try (PreparedStatement stmt = db.getConnection().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Handle any SQL exceptions
        }

        return 0;  // Return the list of tickets
    }

    public BigDecimal getTotalRevenue() {
        // SQL query to calculate total revenue from ticket sales
        String sql = "SELECT SUM(tt.price) AS total_revenue "
                + "FROM Tickets t "
                + "JOIN TicketTypes tt ON t.ticket_type_id = tt.id";

        try (PreparedStatement stmt = db.getConnection().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getBigDecimal("total_revenue");
            } else {
                return BigDecimal.ZERO;  // Return 0 if no revenue is found
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Handle any SQL exceptions
        }

        return BigDecimal.ZERO;  // Return 0 in case of an exception
    }

    public int getUpcomingEventsCount() {
        // Just stole this from my events table
        int eventCount = 0;

        // Fetch the user's tickets from the database
        List<Ticket> userTickets = ticketController.getTickets();

        // Use a Set to track added event IDs (to ensure uniqueness)
        Set<Integer> addedEventIds = new HashSet<>();

        for (Ticket ticket : userTickets) {
            TicketType ticketType = ticketController.getTicketTypeById(ticket.getTicketTypeId());

            if (ticketType != null) {
                Event event = eventController.getEventByTicketTypeId(ticketType.getId());

                if (event != null) {
                    if (addedEventIds.contains(event.getId())) {
                        continue;
                    }

                    eventCount++;
                }
            }
        }
        
        return eventCount;
    }

    public String getTopSellingEventName() {
        // SQL query to fetch tickets for the specified user_id
        String sql = "SELECT e.name, COUNT(t.id) AS total_tickets_sold "
                + "FROM Events e "
                + "JOIN TicketTypes tt ON e.id = tt.event_id "
                + "JOIN Tickets t ON tt.id = t.ticket_type_id "
                + "GROUP BY e.name "
                + "HAVING COUNT(t.id) = ( "
                + "  SELECT MAX(total_tickets_sold) "
                + "  FROM ( "
                + "    SELECT e.name, COUNT(t.id) AS total_tickets_sold "
                + "    FROM Events e "
                + "    JOIN TicketTypes tt ON e.id = tt.event_id "
                + "    JOIN Tickets t ON tt.id = t.ticket_type_id "
                + "    GROUP BY e.name "
                + "  ) AS subquery "
                + ")";

        try (PreparedStatement stmt = db.getConnection().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString(1);
            } else {
                return "";
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Handle any SQL exceptions
        }

        return "";  // Return the list of tickets
    }

    public int getTotalRegisteredUsers() {
        // implementation
        String sql = "SELECT COUNT(*) FROM Users";

        try (PreparedStatement stmt = db.getConnection().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Handle any SQL exceptions
        }

        return 0;  // Return the list of tickets

    }
}
