/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import views.*;

/**
 *
 * @author andre
 */
public class ProfileView extends BaseView {

    /**
     * Creates new form DashboardView
     */
    public ProfileView() {
        initComponents();
        myInitComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlNavBar = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblNBDashboard = new javax.swing.JLabel();
        lblNBEvents = new javax.swing.JLabel();
        lblNBProfile = new javax.swing.JLabel();
        lblNBCheckout = new javax.swing.JLabel();
        txtDashboardSub1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        hdrDashboard1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Eventure - Dashboard");
        setResizable(false);

        pnlNavBar.setBackground(new java.awt.Color(155, 0, 155));
        pnlNavBar.setMinimumSize(new java.awt.Dimension(75, 23));
        pnlNavBar.setPreferredSize(new java.awt.Dimension(320, 720));
        pnlNavBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo.setText("THE LOGO SHOULD BE HERE");
        lblLogo.setPreferredSize(new java.awt.Dimension(225, 55));
        pnlNavBar.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 25, -1, -1));

        lblNBDashboard.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        lblNBDashboard.setForeground(new java.awt.Color(255, 255, 255));
        lblNBDashboard.setText("Dashboard");
        lblNBDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNBDashboardMouseClicked(evt);
            }
        });
        pnlNavBar.add(lblNBDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 35, -1, -1));

        lblNBEvents.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        lblNBEvents.setForeground(new java.awt.Color(255, 255, 255));
        lblNBEvents.setText("Events");
        lblNBEvents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNBEventsMouseClicked(evt);
            }
        });
        pnlNavBar.add(lblNBEvents, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 35, -1, -1));

        lblNBProfile.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        lblNBProfile.setForeground(new java.awt.Color(255, 255, 255));
        lblNBProfile.setText("Profile");
        lblNBProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNBProfileMouseClicked(evt);
            }
        });
        pnlNavBar.add(lblNBProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 35, -1, -1));

        lblNBCheckout.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        lblNBCheckout.setForeground(new java.awt.Color(255, 255, 255));
        lblNBCheckout.setText("Checkout");
        lblNBCheckout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNBCheckoutMouseClicked(evt);
            }
        });
        pnlNavBar.add(lblNBCheckout, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 35, -1, -1));

        txtDashboardSub1.setFont(new java.awt.Font("Riffic Free Medium", 0, 36)); // NOI18N
        txtDashboardSub1.setText("Upcoming Events:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setPreferredSize(new java.awt.Dimension(900, 80));
        jScrollPane1.setViewportView(jTable1);

        hdrDashboard1.setFont(new java.awt.Font("Riffic Free Medium", 0, 64)); // NOI18N
        hdrDashboard1.setText("PROFILE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlNavBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 883, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDashboardSub1)
                            .addComponent(hdrDashboard1))))
                .addContainerGap(378, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlNavBar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(hdrDashboard1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(txtDashboardSub1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblNBEventsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNBEventsMouseClicked
        // TODO add your handling code here:
        // Open the Events page when Events label is clicked
        EventsView view = new EventsView(); // Create a new page for Events
        view.setVisible(true);
        this.dispose(); // Close the current window (Dashboard)
        
    }//GEN-LAST:event_lblNBEventsMouseClicked

    private void lblNBDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNBDashboardMouseClicked
        // TODO add your handling code here:
        DashboardView view = new DashboardView(); // Create a new page for Events
        view.setVisible(true);
        this.dispose(); // Close the current window (Dashboard)
    }//GEN-LAST:event_lblNBDashboardMouseClicked

    private void lblNBCheckoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNBCheckoutMouseClicked
        // TODO add your handling code here:
        CheckoutView view = new CheckoutView(); // Create a new page for Events
        view.setVisible(true);
        this.dispose(); // Close the current window (Dashboard)
    }//GEN-LAST:event_lblNBCheckoutMouseClicked

    private void lblNBProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNBProfileMouseClicked
        // TODO add your handling code here:
        ProfileView view = new ProfileView(); // Create a new page for Events
        view.setVisible(true);
        this.dispose(); // Close the current window (Dashboard)
    }//GEN-LAST:event_lblNBProfileMouseClicked

    public void myInitComponents() {
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
    private javax.swing.JLabel hdrDashboard1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNBCheckout;
    private javax.swing.JLabel lblNBDashboard;
    private javax.swing.JLabel lblNBEvents;
    private javax.swing.JLabel lblNBProfile;
    private javax.swing.JPanel pnlNavBar;
    private javax.swing.JLabel txtDashboardSub1;
    // End of variables declaration//GEN-END:variables
}
