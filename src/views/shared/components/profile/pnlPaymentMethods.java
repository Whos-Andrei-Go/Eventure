/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views.shared.components.profile;

import controllers.PaymentMethodController;
import java.awt.Frame;
import java.awt.Window;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import utility.Database;
import models.PaymentMethod; // Assuming you have a PaymentMethod model
import utility.Session;
import views.shared.components.dlgAddPaymentMethod; // Import the dialog class

/**
 *
 * @author andre
 */
public class pnlPaymentMethods extends javax.swing.JPanel {

    /**
     * Creates new form pnlOverview
     */
    private List<PaymentMethod> paymentMethods; // List to hold payment methods
    private PaymentMethodController paymentMethodController; // List to hold payment methods
    
    public pnlPaymentMethods() {
        initComponents();
        paymentMethods = new ArrayList<>(); // Initialize the list
        
        refreshPaymentMethods();
    }
    
    public pnlPaymentMethods(Database db) {
        initComponents();
        paymentMethods = new ArrayList<>(); // Initialize the list
        paymentMethodController = new PaymentMethodController(db);
        
        refreshPaymentMethods();
        
        if (!paymentMethods.isEmpty()) {
            PaymentMethod firstMethod = paymentMethods.get(0);
            txtAccountNumber.setText(firstMethod.getAccountNumber());
            if (firstMethod.getExpirationDate() != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
                txtExpirationDate.setText(sdf.format(firstMethod.getExpirationDate()));
            } else {
                txtExpirationDate.setText(""); // Clear if no expiration date
            }
            
            chkIsDefault.setSelected(firstMethod.isDefault());
        } else {
            txtAccountNumber.setText(""); // Clear if no payment methods
            txtExpirationDate.setText(""); // Clear if no payment methods
        }
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
        cmbPaymentMethod = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtAccountNumber = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtExpirationDate = new javax.swing.JTextField();
        chkIsDefault = new javax.swing.JCheckBox();
        btnUpdatePaymentMethod = new javax.swing.JButton();
        lblDeletePaymentMethod = new javax.swing.JLabel();
        lblAddPaymentMethod = new javax.swing.JLabel();

        hdrMain.setFont(new java.awt.Font("Riffic Free Medium", 0, 64)); // NOI18N
        hdrMain.setText("PAYMENT METHODS");
        hdrMain.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        hdrMain.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        cmbPaymentMethod.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbPaymentMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GCash", "Maya", "Credit Card" }));
        cmbPaymentMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPaymentMethodActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Method:");

        lblUsername.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblUsername.setText("Account Number:");

        txtAccountNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtAccountNumber.setPreferredSize(new java.awt.Dimension(500, 31));
        txtAccountNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAccountNumberActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblEmail.setText("Expiration Date:");

        txtExpirationDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtExpirationDate.setPreferredSize(new java.awt.Dimension(500, 31));
        txtExpirationDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExpirationDateActionPerformed(evt);
            }
        });

        chkIsDefault.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        chkIsDefault.setText("Default Payment Method");
        chkIsDefault.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkIsDefaultActionPerformed(evt);
            }
        });

        btnUpdatePaymentMethod.setBackground(new java.awt.Color(153, 0, 153));
        btnUpdatePaymentMethod.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnUpdatePaymentMethod.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdatePaymentMethod.setText("Update Payment Method");
        btnUpdatePaymentMethod.setBorder(null);
        btnUpdatePaymentMethod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdatePaymentMethodMouseClicked(evt);
            }
        });
        btnUpdatePaymentMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePaymentMethodActionPerformed(evt);
            }
        });

        lblDeletePaymentMethod.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDeletePaymentMethod.setForeground(new java.awt.Color(204, 0, 0));
        lblDeletePaymentMethod.setText("Delete Payment Method");
        lblDeletePaymentMethod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDeletePaymentMethodMouseClicked(evt);
            }
        });

        lblAddPaymentMethod.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAddPaymentMethod.setForeground(new java.awt.Color(0, 0, 204));
        lblAddPaymentMethod.setText("Add New Payment Method");
        lblAddPaymentMethod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddPaymentMethodMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(hdrMain)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsername)
                            .addComponent(txtExpirationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAccountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chkIsDefault)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
                                .addComponent(btnUpdatePaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(cmbPaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblAddPaymentMethod))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblDeletePaymentMethod)
                        .addGap(8, 8, 8)))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(hdrMain, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbPaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(lblAddPaymentMethod)))
                .addGap(38, 38, 38)
                .addComponent(lblUsername)
                .addGap(18, 18, 18)
                .addComponent(txtAccountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblEmail)
                .addGap(22, 22, 22)
                .addComponent(txtExpirationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkIsDefault)
                    .addComponent(btnUpdatePaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDeletePaymentMethod)
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtAccountNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAccountNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAccountNumberActionPerformed

    private void txtExpirationDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExpirationDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExpirationDateActionPerformed

    private void chkIsDefaultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkIsDefaultActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkIsDefaultActionPerformed

    private void btnUpdatePaymentMethodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdatePaymentMethodMouseClicked
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
    
        int selectedIndex = cmbPaymentMethod.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(parentWindow, "Please select a payment method to update.");
            return;
        }

        PaymentMethod selectedMethod = paymentMethods.get(selectedIndex);
        String paymentType = selectedMethod.getPaymentType();
        String accountNumber = txtAccountNumber.getText(); // Assuming account number is in txtAccountNumber
        String expirationDateStr = txtExpirationDate.getText(); // Assuming expiration date is in txtExpirationDate

        if (accountNumber.isEmpty()) {
            JOptionPane.showMessageDialog(parentWindow, "Account Number cannot be empty.");
            return;
        }

        // Check if the new method is being set as default
        boolean isDefault = chkIsDefault.isSelected();
        if (isDefault) {
            // Find and update any other payment method that is currently set as default
            for (PaymentMethod method : paymentMethods) {
                if (method.getId() != selectedMethod.getId() && method.isDefault()) {
                    // Prompt user to confirm changing the default payment method
                    int confirmation = JOptionPane.showConfirmDialog(parentWindow,
                            "Another payment method is already set as default. Do you want to change it?",
                            "Confirm Change", JOptionPane.YES_NO_OPTION);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        // Update the previously default payment method
                        method.setDefault(false); // Set the old default to false
                        paymentMethodController.updatePaymentMethod(method); // Update in the database
                    } else {
                        chkIsDefault.setSelected(false); // Uncheck the checkbox if user declines
                        isDefault = false; // Set isDefault to false
                    }
                    break; // Exit the loop after checking
                }
            }
        }

        PaymentMethod updatedPaymentMethod = new PaymentMethod();
        updatedPaymentMethod.setId(selectedMethod.getId());
        updatedPaymentMethod.setUserId(selectedMethod.getUserId());
        updatedPaymentMethod.setPaymentType(paymentType);
        updatedPaymentMethod.setAccountNumber(accountNumber);
        updatedPaymentMethod.setDefault(isDefault); // Set isDefault based on checkbox state

        if (!expirationDateStr.isEmpty()) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
                Date expirationDate = sdf.parse(expirationDateStr);
                updatedPaymentMethod.setExpirationDate(expirationDate);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(parentWindow, "Please enter a valid expiration date in MM/yyyy format.");
                return;
            }
        } else {
            updatedPaymentMethod.setExpirationDate(null);
        }

        int confirmation = JOptionPane.showConfirmDialog(parentWindow,
                "Are you sure you want to update this payment method?\n" +
                "Payment Type: " + paymentType + "\n" +
                "Account Number: " + accountNumber + "\n" +
                "Expiration Date: " + expirationDateStr,
                "Confirm Update", JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            paymentMethodController.updatePaymentMethod(updatedPaymentMethod);
            refreshPaymentMethods();
            JOptionPane.showMessageDialog(parentWindow, "Payment method updated successfully.");
        }
    }//GEN-LAST:event_btnUpdatePaymentMethodMouseClicked

    private void btnUpdatePaymentMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePaymentMethodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdatePaymentMethodActionPerformed

    private void lblDeletePaymentMethodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeletePaymentMethodMouseClicked
        // Open the dialog to add a new payment method
        int selectedIndex = cmbPaymentMethod.getSelectedIndex();
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(parentWindow, "Please select a payment method to delete.");
            return;
        }

        PaymentMethod selectedMethod = paymentMethods.get(selectedIndex);
        int confirmation = JOptionPane.showConfirmDialog(parentWindow,
                "Are you sure you want to delete this payment method?\n" +
                "Payment Type: " + selectedMethod.getPaymentType() + "\n" +
                "Account Number: " + selectedMethod.getAccountNumber(),
                "Confirm Deletion", JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            paymentMethodController.deletePaymentMethod(selectedMethod.getId());
            refreshPaymentMethods();
            JOptionPane.showMessageDialog(parentWindow, "Payment method deleted successfully.");
        }
    }//GEN-LAST:event_lblDeletePaymentMethodMouseClicked

    private void cmbPaymentMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPaymentMethodActionPerformed
        // TODO add your handling code here:
        if (cmbPaymentMethod != null && cmbPaymentMethod.getItemCount() > 0) {
            int selectedIndex = cmbPaymentMethod.getSelectedIndex();
            if (selectedIndex != -1 && !paymentMethods.isEmpty()) {
                PaymentMethod selectedMethod = paymentMethods.get(selectedIndex);
                txtAccountNumber.setText(selectedMethod.getAccountNumber());
                if (selectedMethod.getExpirationDate() != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
                    txtExpirationDate.setText(sdf.format(selectedMethod.getExpirationDate()));
                } else {
                    txtExpirationDate.setText(""); // Clear if no expiration date
                }
            } else {
                // Handle case where no item is selected
                txtAccountNumber.setText(""); // Clear account number
                txtExpirationDate.setText(""); // Clear expiration date
            }
        } else {
            // Handle case where cmbPaymentMethod is empty or null
            txtAccountNumber.setText(""); // Clear account number
            txtExpirationDate.setText(""); // Clear expiration date
        }
    }//GEN-LAST:event_cmbPaymentMethodActionPerformed

    private void lblAddPaymentMethodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddPaymentMethodMouseClicked
        // TODO add your handling code here:
        dlgAddPaymentMethod addPaymentDialog = new dlgAddPaymentMethod((Frame) SwingUtilities.getWindowAncestor(this), paymentMethods, this.paymentMethodController);
        addPaymentDialog.setVisible(true); // Show the dialog

        // Refresh the panel after the dialog is closed
        refreshPaymentMethods();
    }//GEN-LAST:event_lblAddPaymentMethodMouseClicked

    private void refreshPaymentMethods() {
        cmbPaymentMethod.removeAllItems(); // Clear existing items in the combo box

        // Assuming you have a way to get the current user's ID
        int currentUserId = Session.getCurrentUser().getId();

        // Fetch payment methods from the database
        paymentMethods = paymentMethodController.getPaymentMethodsByUserId(currentUserId);

        if (paymentMethods.isEmpty()) {
            cmbPaymentMethod.addItem("None"); // Display "None" if no payment methods are available
        } else {
            for (PaymentMethod method : paymentMethods) {
                cmbPaymentMethod.addItem(method.getPaymentType());
            }
        }
        
        this.revalidate();
        this.repaint();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdatePaymentMethod;
    private javax.swing.JCheckBox chkIsDefault;
    private javax.swing.JComboBox<String> cmbPaymentMethod;
    private javax.swing.JLabel hdrMain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAddPaymentMethod;
    private javax.swing.JLabel lblDeletePaymentMethod;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtAccountNumber;
    private javax.swing.JTextField txtExpirationDate;
    // End of variables declaration//GEN-END:variables
}
