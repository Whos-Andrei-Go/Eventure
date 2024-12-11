/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author andre
 */
public class Event {
    private int id;
    private int creatorId;
    private String name;
    private String location;
    private String description;
    private Timestamp startTimestamp;
    private Timestamp endTimestamp;
    
    
    // Constructor and getters/setters
    // Constructor
    public Event(){
        
    }
    
    public Event(int id, int creatorId, String name, String location, String description, Timestamp startTimestamp, Timestamp endTimestamp) {
        this.id = id;
        this.creatorId = creatorId;
        this.name = name;
        this.location = location;
        this.description = description;
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
    }

    // Getters and Setters
    public int getId() { 
        return id; 
    }
    
    public int getCreatorId() { 
        return creatorId; 
    }
    
    public String getName() { 
        return name; 
    }
    
    public String getLocation() { 
        return location; 
    }
    
    public String getDescription() { 
        return description; 
    }
    
    public Timestamp getStartTimestamp() {
        return startTimestamp;
    }

    public Timestamp getEndTimestamp() {
        return endTimestamp;
    }   
    
    public String getFormattedStartTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(startTimestamp);
    }

    public String getFormattedEndTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(endTimestamp);
    }

    public void setId(int id) { 
        this.id = id; 
    }
    
    public void setCreatorId(int creatorId) { 
        this.creatorId = creatorId; 
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
     public void setLocation(String location) {
        this.location = location;
    }
     
    public void setStartTimestamp(String startDate, String startTime) {
        String dateTimeString = startDate + " " + startTime;
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");

        try {
            java.util.Date parsedDate = sdf.parse(dateTimeString);
            this.startTimestamp = new Timestamp(parsedDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            this.startTimestamp = null;
        }
    }

    public void setEndTimestamp(String endDate, String endTime) {
        String dateTimeString = endDate + " " + endTime;
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");

        try {
            java.util.Date parsedDate = sdf.parse(dateTimeString);
            this.endTimestamp = new Timestamp(parsedDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            this.endTimestamp = null;
        }
    }
}