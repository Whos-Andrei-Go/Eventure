/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.shared.components;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import models.TicketType; // Assuming you have a TicketType model
import controllers.TicketController; // Assuming you have a TicketController to fetch tickets

public class dlgEventDetails extends JDialog {

    public dlgEventDetails(Frame parent, String name, String location, String description, String startTime, String endTime) {
        super(parent, "Event Details", true); // true for modal dialog
        setLayout(new BorderLayout());
        setSize(400, 300);
        setLocationRelativeTo(parent); // Center the dialog

        // Create the details panel
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add event details
        detailsPanel.add(new JLabel("Event: " + name));
        detailsPanel.add(new JLabel("Location: " + location));
        detailsPanel.add(new JLabel("Description: " + description));
        detailsPanel.add(new JLabel("Start: " + startTime));
        detailsPanel.add(new JLabel("End: " + endTime));

        // Fetch and display user's tickets for the event
        /*List<TicketType> userTickets = ticketController.getUserTicketsForEvent(name); // Assuming this method exists
        if (userTickets != null && !userTickets.isEmpty()) {
            detailsPanel.add(new JLabel("Your Tickets:"));
            for (TicketType ticket : userTickets) {
                detailsPanel.add(new JLabel(ticket.getTicketName() + " - $" + ticket.getTicketPrice()));
            }
        } else {
            detailsPanel.add(new JLabel("No tickets purchased for this event."));
        }*/

        // Add a close button
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose()); // Close the dialog
        detailsPanel.add(closeButton);

        // Add the details panel to the dialog
        add(detailsPanel, BorderLayout.CENTER);
    }
}