/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author andre
 */
public class OldEventView extends javax.swing.JFrame {

    /**
     * Creates new form DashboardView
     */
    public OldEventView() {
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

        pnlSidebar = new javax.swing.JPanel();
        pnlLogo = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        menuItemDashboard = new javax.swing.JPanel();
        lblSBHome = new javax.swing.JLabel();
        lblSBDashboardLogo = new javax.swing.JLabel();
        menuItemEvents = new javax.swing.JPanel();
        lblSBHome1 = new javax.swing.JLabel();
        lblSBDashboardLogo1 = new javax.swing.JLabel();
        menuItemProfile = new javax.swing.JPanel();
        lblSBHome2 = new javax.swing.JLabel();
        lblSBDashboardLogo2 = new javax.swing.JLabel();
        menuItemTickets = new javax.swing.JPanel();
        lblSBHome3 = new javax.swing.JLabel();
        lblSBDashboardLogo3 = new javax.swing.JLabel();
        menuItemCheckout = new javax.swing.JPanel();
        lblSBHome4 = new javax.swing.JLabel();
        lblSBDashboardLogo4 = new javax.swing.JLabel();
        txtDashboardSub1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        hdrDashboard1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Eventure - Dashboard");
        setResizable(false);

        pnlSidebar.setBackground(new java.awt.Color(155, 0, 155));
        pnlSidebar.setMinimumSize(new java.awt.Dimension(75, 23));
        pnlSidebar.setPreferredSize(new java.awt.Dimension(320, 720));
        pnlSidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlLogo.setBackground(new java.awt.Color(102, 0, 102));

        lblLogo.setPreferredSize(new java.awt.Dimension(225, 55));

        javax.swing.GroupLayout pnlLogoLayout = new javax.swing.GroupLayout(pnlLogo);
        pnlLogo.setLayout(pnlLogoLayout);
        pnlLogoLayout.setHorizontalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogoLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        pnlLogoLayout.setVerticalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pnlSidebar.add(pnlLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        menuItemDashboard.setBackground(new java.awt.Color(155, 0, 155));
        menuItemDashboard.setPreferredSize(new java.awt.Dimension(320, 60));

        lblSBHome.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        lblSBHome.setForeground(new java.awt.Color(255, 255, 255));
        lblSBHome.setText("Dashboard");

        lblSBDashboardLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storage/images/icons/dashboard.png"))); // NOI18N

        javax.swing.GroupLayout menuItemDashboardLayout = new javax.swing.GroupLayout(menuItemDashboard);
        menuItemDashboard.setLayout(menuItemDashboardLayout);
        menuItemDashboardLayout.setHorizontalGroup(
            menuItemDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuItemDashboardLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblSBDashboardLogo)
                .addGap(35, 35, 35)
                .addComponent(lblSBHome)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        menuItemDashboardLayout.setVerticalGroup(
            menuItemDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuItemDashboardLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(menuItemDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSBHome)
                    .addComponent(lblSBDashboardLogo))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pnlSidebar.add(menuItemDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, -1, -1));

        menuItemEvents.setBackground(new java.awt.Color(155, 0, 155));
        menuItemEvents.setPreferredSize(new java.awt.Dimension(320, 60));

        lblSBHome1.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        lblSBHome1.setForeground(new java.awt.Color(255, 255, 255));
        lblSBHome1.setText("Events");

        lblSBDashboardLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storage/images/icons/dashboard.png"))); // NOI18N

        javax.swing.GroupLayout menuItemEventsLayout = new javax.swing.GroupLayout(menuItemEvents);
        menuItemEvents.setLayout(menuItemEventsLayout);
        menuItemEventsLayout.setHorizontalGroup(
            menuItemEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuItemEventsLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblSBDashboardLogo1)
                .addGap(35, 35, 35)
                .addComponent(lblSBHome1)
                .addContainerGap(124, Short.MAX_VALUE))
        );
        menuItemEventsLayout.setVerticalGroup(
            menuItemEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuItemEventsLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(menuItemEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSBHome1)
                    .addComponent(lblSBDashboardLogo1))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pnlSidebar.add(menuItemEvents, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, -1, -1));

        menuItemProfile.setBackground(new java.awt.Color(155, 0, 155));

        lblSBHome2.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        lblSBHome2.setForeground(new java.awt.Color(255, 255, 255));
        lblSBHome2.setText("Profile");

        lblSBDashboardLogo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storage/images/icons/dashboard.png"))); // NOI18N

        javax.swing.GroupLayout menuItemProfileLayout = new javax.swing.GroupLayout(menuItemProfile);
        menuItemProfile.setLayout(menuItemProfileLayout);
        menuItemProfileLayout.setHorizontalGroup(
            menuItemProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuItemProfileLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblSBDashboardLogo2)
                .addGap(35, 35, 35)
                .addComponent(lblSBHome2)
                .addContainerGap(125, Short.MAX_VALUE))
        );
        menuItemProfileLayout.setVerticalGroup(
            menuItemProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuItemProfileLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(menuItemProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSBHome2)
                    .addComponent(lblSBDashboardLogo2))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pnlSidebar.add(menuItemProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 320, -1));

        menuItemTickets.setBackground(new java.awt.Color(155, 0, 155));

        lblSBHome3.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        lblSBHome3.setForeground(new java.awt.Color(255, 255, 255));
        lblSBHome3.setText("Tickets");

        lblSBDashboardLogo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storage/images/icons/dashboard.png"))); // NOI18N

        javax.swing.GroupLayout menuItemTicketsLayout = new javax.swing.GroupLayout(menuItemTickets);
        menuItemTickets.setLayout(menuItemTicketsLayout);
        menuItemTicketsLayout.setHorizontalGroup(
            menuItemTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuItemTicketsLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblSBDashboardLogo3)
                .addGap(35, 35, 35)
                .addComponent(lblSBHome3)
                .addContainerGap(118, Short.MAX_VALUE))
        );
        menuItemTicketsLayout.setVerticalGroup(
            menuItemTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuItemTicketsLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(menuItemTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSBHome3)
                    .addComponent(lblSBDashboardLogo3))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pnlSidebar.add(menuItemTickets, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 320, -1));

        menuItemCheckout.setBackground(new java.awt.Color(155, 0, 155));

        lblSBHome4.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        lblSBHome4.setForeground(new java.awt.Color(255, 255, 255));
        lblSBHome4.setText("Checkout");

        lblSBDashboardLogo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storage/images/icons/dashboard.png"))); // NOI18N

        javax.swing.GroupLayout menuItemCheckoutLayout = new javax.swing.GroupLayout(menuItemCheckout);
        menuItemCheckout.setLayout(menuItemCheckoutLayout);
        menuItemCheckoutLayout.setHorizontalGroup(
            menuItemCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuItemCheckoutLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblSBDashboardLogo4)
                .addGap(35, 35, 35)
                .addComponent(lblSBHome4)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        menuItemCheckoutLayout.setVerticalGroup(
            menuItemCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuItemCheckoutLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(menuItemCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSBHome4)
                    .addComponent(lblSBDashboardLogo4))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pnlSidebar.add(menuItemCheckout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 320, -1));

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
        hdrDashboard1.setText("Dashboard");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 883, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hdrDashboard1))
                    .addComponent(txtDashboardSub1))
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSidebar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(hdrDashboard1)
                .addGap(31, 31, 31)
                .addComponent(txtDashboardSub1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void myInitComponents() {
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
            java.util.logging.Logger.getLogger(OldEventView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OldEventView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OldEventView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OldEventView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
          
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OldEventView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hdrDashboard1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblSBDashboardLogo;
    private javax.swing.JLabel lblSBDashboardLogo1;
    private javax.swing.JLabel lblSBDashboardLogo2;
    private javax.swing.JLabel lblSBDashboardLogo3;
    private javax.swing.JLabel lblSBDashboardLogo4;
    private javax.swing.JLabel lblSBHome;
    private javax.swing.JLabel lblSBHome1;
    private javax.swing.JLabel lblSBHome2;
    private javax.swing.JLabel lblSBHome3;
    private javax.swing.JLabel lblSBHome4;
    private javax.swing.JPanel menuItemCheckout;
    private javax.swing.JPanel menuItemDashboard;
    private javax.swing.JPanel menuItemEvents;
    private javax.swing.JPanel menuItemProfile;
    private javax.swing.JPanel menuItemTickets;
    private javax.swing.JPanel pnlLogo;
    private javax.swing.JPanel pnlSidebar;
    private javax.swing.JLabel txtDashboardSub1;
    // End of variables declaration//GEN-END:variables
}
