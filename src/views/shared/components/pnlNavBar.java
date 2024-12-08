/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views.shared.components;
import java.awt.Dimension;
import java.awt.Image;
import views.*;
import javax.swing.*;

/**
 *
 * @author andre
 */
public class pnlNavBar extends javax.swing.JPanel {

    /**
     * Creates new form pnlNavBar
     */
    public pnlNavBar() {
        initComponents();
        setupLogo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblLogo = new javax.swing.JLabel();
        lblNBDashboard = new javax.swing.JLabel();
        lblNBEvents = new javax.swing.JLabel();
        lblNBCheckout = new javax.swing.JLabel();
        lblNBProfile = new javax.swing.JLabel();

        setBackground(new java.awt.Color(155, 0, 155));
        setPreferredSize(new java.awt.Dimension(1280, 120));
        setLayout(new java.awt.GridBagLayout());

        lblLogo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(255, 255, 255));
        lblLogo.setText("THE LOGO IS HERE");
        lblLogo.setPreferredSize(new java.awt.Dimension(225, 55));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 0);
        add(lblLogo, gridBagConstraints);

        lblNBDashboard.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        lblNBDashboard.setForeground(new java.awt.Color(255, 255, 255));
        lblNBDashboard.setText("Dashboard");
        lblNBDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNBDashboardMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 0);
        add(lblNBDashboard, gridBagConstraints);

        lblNBEvents.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        lblNBEvents.setForeground(new java.awt.Color(255, 255, 255));
        lblNBEvents.setText("Events");
        lblNBEvents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNBEventsMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 0);
        add(lblNBEvents, gridBagConstraints);

        lblNBCheckout.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        lblNBCheckout.setForeground(new java.awt.Color(255, 255, 255));
        lblNBCheckout.setText("Checkout");
        lblNBCheckout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNBCheckoutMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 0);
        add(lblNBCheckout, gridBagConstraints);

        lblNBProfile.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        lblNBProfile.setForeground(new java.awt.Color(255, 255, 255));
        lblNBProfile.setText("Profile");
        lblNBProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNBProfileMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 0);
        add(lblNBProfile, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void lblNBDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNBDashboardMouseClicked
        // TODO add your handling code here:
        DashboardView view = new DashboardView(); // Create a new page for Events
        view.setVisible(true);
        closeParentWindow();
    }//GEN-LAST:event_lblNBDashboardMouseClicked

    private void lblNBEventsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNBEventsMouseClicked
        // TODO add your handling code here:
        // Open the Events page when Events label is clicked
        EventsView view = new EventsView(); // Create a new page for Events
        view.setVisible(true);
        closeParentWindow();
    }//GEN-LAST:event_lblNBEventsMouseClicked

    private void lblNBCheckoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNBCheckoutMouseClicked
        // TODO add your handling code here:
        CheckoutView view = new CheckoutView(); // Create a new page for Events
        view.setVisible(true);
        closeParentWindow();
    }//GEN-LAST:event_lblNBCheckoutMouseClicked

    private void lblNBProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNBProfileMouseClicked
        // TODO add your handling code here:
        ProfileView view = new ProfileView(); // Create a new page for Events
        view.setVisible(true);
        closeParentWindow();
    }//GEN-LAST:event_lblNBProfileMouseClicked

    private void closeParentWindow() {
        java.awt.Window parentWindow = javax.swing.SwingUtilities.getWindowAncestor(this);
        if (parentWindow != null) {
            parentWindow.dispose(); // Close the window
        }
    }
    
    private void setupLogo(){
        lblLogo.setText("");
        lblLogo.setSize(new Dimension(225, 55)); // Set desired width and height
        lblLogo.revalidate();
        lblLogo.repaint();
        
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/storage/images/logo.png"));
        
        Image img = logoIcon.getImage();
        Image imgScale = img.getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        
        lblLogo.setIcon(scaledIcon); // NOI18N
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNBCheckout;
    private javax.swing.JLabel lblNBDashboard;
    private javax.swing.JLabel lblNBEvents;
    private javax.swing.JLabel lblNBProfile;
    // End of variables declaration//GEN-END:variables
}
