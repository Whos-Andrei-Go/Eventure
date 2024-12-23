/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views.shared.components.profile;

import controllers.EventController;
import java.awt.Dimension;
import java.util.List;
import javax.swing.Box;
import models.Event;
import utility.Database;
import utility.Session;
import views.shared.components.pnlEvent;

/**
 *
 * @author andre
 */
public class pnlMyEvents extends javax.swing.JPanel {

    /**
     * Creates new form pnlOverview
     */
    private EventController eventController;
    
    public pnlMyEvents() {
        initComponents();
    }
    
    public pnlMyEvents(Database db) {
        eventController = new EventController(db);
        initComponents();
        refreshData();
    }
    
    public void refreshData(){
        loadMyEvents();  // Load events and display them as cards
    }

    public void loadMyEvents() {
        List<Event> events = eventController.getEvents();

        if (events == null || events.isEmpty()) {
            System.out.println("No events to display.");
        } else {
            System.out.println("Events fetched: " + events.size());
        }

        pnlCards.removeAll();

        int x;
        
        for (x = 0; x < events.size(); x++) {
            Event event = events.get(x);
            if (event.getCreatorId() != Session.getCurrentUser().getId()){
                continue;
            }
            
            pnlEvent eventPanel = new pnlEvent(event);

            eventPanel.setPreferredSize(new Dimension(250, 250));
            pnlCards.add(eventPanel);
            
            if (x < events.size() - 1) {
                pnlCards.add(Box.createHorizontalStrut(53));
            }
        }

        pnlCards.revalidate();
        pnlCards.repaint();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hdrMain = new javax.swing.JLabel();
        scrlCards = new javax.swing.JScrollPane();
        pnlCards = new javax.swing.JPanel();

        hdrMain.setFont(new java.awt.Font("Riffic Free Medium", 0, 64)); // NOI18N
        hdrMain.setText("MY EVENTS");
        hdrMain.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        hdrMain.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        pnlCards.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));
        scrlCards.setViewportView(pnlCards);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(hdrMain))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(scrlCards, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(hdrMain, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addComponent(scrlCards, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hdrMain;
    private javax.swing.JPanel pnlCards;
    private javax.swing.JScrollPane scrlCards;
    // End of variables declaration//GEN-END:variables
}
