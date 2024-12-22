/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controllers.PaymentMethodController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Window;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import models.Cart;
import models.Event;
import models.PaymentMethod;
import models.Ticket;
import models.TicketType;
import utility.Session;
import views.*;
import views.shared.components.dlgAddPaymentMethod;
import views.shared.components.pnlCheckoutItem;
import views.shared.components.pnlEvent;

/**
 *
 * @author andre
 */
public class EnterPaymentMethodView extends BaseView {

    /**
     * Creates new form DashboardView
     */
    
    private BigDecimal totalPrice;
    private List<PaymentMethod> paymentMethods; // List to hold payment methods
    
    public EnterPaymentMethodView() {
        initComponents();
    }
    
     public EnterPaymentMethodView(BigDecimal totalPrice) {
        initComponents();
        
        this.totalPrice = totalPrice;
        pnlFinalCheckoutDetails1.getLblTotalPrice().setText(totalPrice.toString());
        
        paymentMethods = new ArrayList<>(); // Initialize the list
        
        refreshPaymentMethods();
        loadFirstPaymentMethod();
    }
     
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
     
    public final void loadFirstPaymentMethod(){
        if (!paymentMethods.isEmpty()) {
            PaymentMethod firstMethod = paymentMethods.get(0);
            txtAccountNumber.setText(firstMethod.getAccountNumber());
            if (firstMethod.getExpirationDate() != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
                txtExpirationDate.setText(sdf.format(firstMethod.getExpirationDate()));
            } else {
                txtExpirationDate.setText(""); // Clear if no expiration date
            }
        } else {
            txtAccountNumber.setText(""); // Clear if no payment methods
            txtExpirationDate.setText(""); // Clear if no payment methods
        }
    }
    
    private void displayTickets() {
        // Retrieve the tickets from the cart
        BigDecimal cartTotal = new BigDecimal("0.00");
        
        Map<Integer, Integer> cartTickets = Cart.getInstance().getTickets();
        pnlCart.removeAll(); // Clear the panel before adding new ticket components
    
        // Check if there are tickets in the cart
        if (cartTickets.isEmpty()) {
            
        } else {
            int row = 0;
            
            // Loop through the grouped tickets and display one panel per ticket type
            for (Map.Entry<Integer, Integer> entry : cartTickets.entrySet()) {
                int ticketTypeId = entry.getKey();
                int totalQuantity = entry.getValue();

                // Retrieve the ticket type details
                TicketType ticketType = ticketController.getTicketTypeById(ticketTypeId);

                if (ticketType != null) {
                    // Calculate the total price for this ticket type
                    BigDecimal totalPrice = ticketType.getPrice().multiply(BigDecimal.valueOf(totalQuantity));
                    cartTotal = cartTotal.add(totalPrice);

                    // Create and configure the pnlCheckoutItem for this ticket type
                    pnlCheckoutItem ticketPanel = new pnlCheckoutItem(
                            ticketType.getName(),
                            ticketType.getPrice(),
                            totalQuantity
                    );
                    
                    ticketPanel.setPreferredSize(new Dimension(ticketPanel.getPreferredSize().width, ticketPanel.getPreferredSize().height));

                    // Add the ticket panel to the cart panel
                    pnlCart.add(ticketPanel);
                    pnlCart.add(Box.createVerticalStrut(10));
                }
            }
        }

        pnlCart.revalidate();  // Revalidate the layout to ensure the components are displayed
        pnlCart.repaint();  // Repaint the panel
        
        //set txtTotal in pnlCheckoutDetails2 to cartTotal
        System.out.println("TOTAL PRICE IS" + cartTotal.toString());
        pnlFinalCheckoutDetails1.getLblTotalPrice().setText(cartTotal.toString());
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
        hdrMain = new javax.swing.JLabel();
        scrlCart = new javax.swing.JScrollPane();
        pnlCart = new javax.swing.JPanel();
        cmbPaymentMethod = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtAccountNumber = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtExpirationDate = new javax.swing.JTextField();
        btnAddPaymentMethod = new javax.swing.JButton();
        pnlFinalCheckoutDetails1 = new views.shared.components.pnlFinalCheckoutDetails();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Eventure - Enter Payment Method");
        setResizable(false);

        pnlMain.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        pnlMain.setPreferredSize(new java.awt.Dimension(1280, 920));

        hdrMain.setFont(new java.awt.Font("Riffic Free Medium", 0, 64)); // NOI18N
        hdrMain.setText("ENTER PAYMENT METHOD");
        hdrMain.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        hdrMain.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        scrlCart.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrlCart.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        pnlCart.setBackground(new java.awt.Color(155, 0, 155));
        pnlCart.setPreferredSize(new java.awt.Dimension(724, 434));

        cmbPaymentMethod.setBackground(new java.awt.Color(155, 0, 155));
        cmbPaymentMethod.setEditable(true);
        cmbPaymentMethod.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        cmbPaymentMethod.setForeground(new java.awt.Color(255, 255, 255));
        cmbPaymentMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GCash", "Maya", "Credit Card", " " }));
        cmbPaymentMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPaymentMethodActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Method of Payment:");

        lblUsername.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("Account Number:");

        txtAccountNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtAccountNumber.setPreferredSize(new java.awt.Dimension(500, 31));
        txtAccountNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAccountNumberActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Expiration Date:");

        txtExpirationDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtExpirationDate.setPreferredSize(new java.awt.Dimension(500, 31));
        txtExpirationDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExpirationDateActionPerformed(evt);
            }
        });

        btnAddPaymentMethod.setBackground(new java.awt.Color(102, 0, 102));
        btnAddPaymentMethod.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnAddPaymentMethod.setForeground(new java.awt.Color(255, 255, 255));
        btnAddPaymentMethod.setText("Add Payment Method");
        btnAddPaymentMethod.setBorder(null);
        btnAddPaymentMethod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddPaymentMethodMouseClicked(evt);
            }
        });
        btnAddPaymentMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPaymentMethodActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCartLayout = new javax.swing.GroupLayout(pnlCart);
        pnlCart.setLayout(pnlCartLayout);
        pnlCartLayout.setHorizontalGroup(
            pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCartLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsername)
                    .addComponent(txtExpirationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAccountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail)
                    .addGroup(pnlCartLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(49, 49, 49)
                        .addComponent(cmbPaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(85, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCartLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddPaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        pnlCartLayout.setVerticalGroup(
            pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCartLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbPaymentMethod))
                .addGap(39, 39, 39)
                .addComponent(lblUsername)
                .addGap(18, 18, 18)
                .addComponent(txtAccountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblEmail)
                .addGap(22, 22, 22)
                .addComponent(txtExpirationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(btnAddPaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        scrlCart.setViewportView(pnlCart);

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(hdrMain)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(scrlCart, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(pnlFinalCheckoutDetails1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(hdrMain, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFinalCheckoutDetails1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrlCart, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(288, Short.MAX_VALUE))
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

    private void txtAccountNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAccountNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAccountNumberActionPerformed

    private void txtExpirationDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExpirationDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExpirationDateActionPerformed

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

    private void btnAddPaymentMethodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddPaymentMethodMouseClicked
        dlgAddPaymentMethod addPaymentDialog = new dlgAddPaymentMethod((Frame) SwingUtilities.getWindowAncestor(this), paymentMethods, this.paymentMethodController);
        addPaymentDialog.setVisible(true); // Show the dialog

        // Refresh the panel after the dialog is closed
        refreshPaymentMethods();
    }//GEN-LAST:event_btnAddPaymentMethodMouseClicked

    private void btnAddPaymentMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPaymentMethodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddPaymentMethodActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPaymentMethod;
    private javax.swing.JComboBox<String> cmbPaymentMethod;
    private javax.swing.JLabel hdrMain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlCart;
    private views.shared.components.pnlFinalCheckoutDetails pnlFinalCheckoutDetails1;
    private javax.swing.JPanel pnlMain;
    private views.shared.components.pnlNavBar pnlNavBar1;
    private javax.swing.JScrollPane scrlCart;
    private javax.swing.JScrollPane scrlMain;
    private javax.swing.JTextField txtAccountNumber;
    private javax.swing.JTextField txtExpirationDate;
    // End of variables declaration//GEN-END:variables
}
