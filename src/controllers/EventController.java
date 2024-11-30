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
                String date = rs.getString("date");

                Event event = new Event(id, name, description, date);
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Handle exception properly
        }

        return events;
    }
}
