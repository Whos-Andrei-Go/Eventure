/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author andre
 */
public class Event {
    private int id;
    private String name;
    private String description;
    private String date;
    
    // Constructor and getters/setters
    // Constructor
    public Event(int id, String name, String description, String date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
    }

    // Getters and Setters
    public int getId() { 
        return id; 
    }
    public String getName() { 
        return name; 
    }
    public String getDescription() { 
        return description; 
    }
    public String getDate() { 
        return date; 
    }
    
}