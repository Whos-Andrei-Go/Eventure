/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views.shared.components;

import javax.swing.JLabel;

/**
 *
 * @author andre
 */
public class pnlCheckoutDetails extends javax.swing.JPanel {

    /**
     * Creates new form pnlCheckoutDetails
     */
    public pnlCheckoutDetails() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnProceed = new javax.swing.JButton();
        lblTotalPrice = new javax.swing.JLabel();
        lblSummary = new javax.swing.JLabel();
        lblTotal1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(102, 0, 102));

        btnProceed.setBackground(new java.awt.Color(153, 0, 153));
        btnProceed.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnProceed.setForeground(new java.awt.Color(255, 255, 255));
        btnProceed.setText("Proceed to Checkout");
        btnProceed.setBorder(null);
        btnProceed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProceedMouseClicked(evt);
            }
        });
        btnProceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProceedActionPerformed(evt);
            }
        });

        lblTotalPrice.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTotalPrice.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalPrice.setText("Total Price");
        lblTotalPrice.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lblSummary.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblSummary.setForeground(new java.awt.Color(255, 255, 255));
        lblSummary.setText("Summary:");

        lblTotal1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTotal1.setForeground(new java.awt.Color(255, 255, 255));
        lblTotal1.setText("Total:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSummary)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnProceed, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblTotal1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTotalPrice))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblSummary)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalPrice)
                    .addComponent(lblTotal1))
                .addGap(42, 42, 42)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProceed, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnProceedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProceedMouseClicked
        // TODO add your handling code here:
       

    }//GEN-LAST:event_btnProceedMouseClicked

    private void btnProceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProceedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProceedActionPerformed

    public JLabel getLblTotalPrice() {
        return lblTotalPrice;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProceed;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblSummary;
    private javax.swing.JLabel lblTotal1;
    private javax.swing.JLabel lblTotalPrice;
    // End of variables declaration//GEN-END:variables
}
