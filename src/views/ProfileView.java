/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controllers.EventController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.List;
import javax.swing.*;
import models.Event;
import views.*;
import views.shared.components.pnlEvent;

/**
 *
 * @author andre
 */
public class ProfileView extends BaseView {

    /**
     * Creates new form DashboardView
     */
    
    private EventController eventController;
    
    public ProfileView() {
        initComponents();
        
        eventController = new EventController(db);
        loadUpcomingCards();  // Load events and display them as cards
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlNavBar1 = new views.shared.components.pnlNavBar();
        scrlMain = new javax.swing.JScrollPane();
        pnlMain = new javax.swing.JPanel();
        pnlUpcoming = new javax.swing.JPanel();
        hdrUpcoming = new javax.swing.JLabel();
        scrlUpcomingCards = new javax.swing.JScrollPane();
        pnlUpcomingCards = new javax.swing.JPanel();
        hdrMain = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Eventure - Dashboard");
        setResizable(false);

        pnlMain.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        pnlMain.setPreferredSize(new java.awt.Dimension(1280, 720));

        pnlUpcoming.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));

        hdrUpcoming.setFont(new java.awt.Font("Riffic Free Medium", 0, 36)); // NOI18N
        hdrUpcoming.setText("Upcoming Events:");
        hdrUpcoming.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        hdrUpcoming.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        scrlUpcomingCards.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrlUpcomingCards.setPreferredSize(new java.awt.Dimension(0, 0));

        pnlUpcomingCards.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        scrlUpcomingCards.setViewportView(pnlUpcomingCards);

        javax.swing.GroupLayout pnlUpcomingLayout = new javax.swing.GroupLayout(pnlUpcoming);
        pnlUpcoming.setLayout(pnlUpcomingLayout);
        pnlUpcomingLayout.setHorizontalGroup(
            pnlUpcomingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUpcomingLayout.createSequentialGroup()
                .addComponent(hdrUpcoming)
                .addGap(0, 872, Short.MAX_VALUE))
            .addGroup(pnlUpcomingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrlUpcomingCards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlUpcomingLayout.setVerticalGroup(
            pnlUpcomingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUpcomingLayout.createSequentialGroup()
                .addComponent(hdrUpcoming, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrlUpcomingCards, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(293, Short.MAX_VALUE))
        );

        hdrMain.setFont(new java.awt.Font("Riffic Free Medium", 0, 64)); // NOI18N
        hdrMain.setText("PROFILE");
        hdrMain.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        hdrMain.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlUpcoming, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlMainLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(hdrMain)
                    .addContainerGap(941, Short.MAX_VALUE)))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(pnlUpcoming, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlMainLayout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(hdrMain, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(750, Short.MAX_VALUE)))
        );

        scrlMain.setViewportView(pnlMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlNavBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlNavBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(scrlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void loadUpcomingCards() {
        List<Event> events = eventController.getEvents();

        if (events == null || events.isEmpty()) {
            System.out.println("No events to display.");
        } else {
            System.out.println("Events fetched: " + events.size());
        }

        pnlUpcomingCards.removeAll();

        int x;
        
        for (x = 0; x < events.size(); x++) {
            Event event = events.get(x);
            pnlEvent eventPanel = new pnlEvent(event.getName(), event.getDescription(), event.getFormattedStartTime(), event.getFormattedEndTime());
            eventPanel.setPreferredSize(new Dimension(250, 250));

            pnlUpcomingCards.add(eventPanel);

            if (x < events.size() - 1) {
                pnlUpcomingCards.add(Box.createHorizontalStrut(20));
            }
        }
        

        pnlUpcomingCards.revalidate();
        pnlUpcomingCards.repaint();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProfileView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfileView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfileView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfileView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
          
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfileView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hdrMain;
    private javax.swing.JLabel hdrUpcoming;
    private javax.swing.JPanel pnlMain;
    private views.shared.components.pnlNavBar pnlNavBar1;
    private javax.swing.JPanel pnlUpcoming;
    private javax.swing.JPanel pnlUpcomingCards;
    private javax.swing.JScrollPane scrlMain;
    private javax.swing.JScrollPane scrlUpcomingCards;
    // End of variables declaration//GEN-END:variables
}
