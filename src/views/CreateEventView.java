/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import views.shared.components.dlgAddTicketType;
import controllers.EventController;
import controllers.TicketController;
import controllers.UserController;
import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.*;
import models.Event;
import models.TicketType;
import models.User;
import raven.datetime.component.date.DatePicker;
import raven.datetime.component.time.TimePicker;
import utility.Session;
import views.*;
import views.shared.components.pnlEvent;

/**
 *
 * @author andre
 */
public class CreateEventView extends BaseView {

    /**
     * Creates new form DashboardView
     */
    
    private EventController eventController;
    private TicketController ticketController;
    private DefaultListModel<String> ticketListModel;
    private UserController userController;
    
    public CreateEventView() {
        userController =  new UserController(db);
        ticketListModel = new DefaultListModel<>();
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

        pnlNavBar1 = new views.shared.components.pnlNavBar();
        scrlMain = new javax.swing.JScrollPane();
        pnlMain = new javax.swing.JPanel();
        hdrMain = new javax.swing.JLabel();
        txtEventName = new javax.swing.JTextField();
        lblStartDate = new javax.swing.JLabel();
        lblEventName1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        btnSubmit = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        frmTxtStartDate = new javax.swing.JFormattedTextField();
        lblEventName2 = new javax.swing.JLabel();
        lblEndDate = new javax.swing.JLabel();
        frmTxtEndDate = new javax.swing.JFormattedTextField();
        lblStartTime = new javax.swing.JLabel();
        frmTxtStartTime = new javax.swing.JFormattedTextField();
        lblEndTime = new javax.swing.JLabel();
        frmTxtEndTime = new javax.swing.JFormattedTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        listTicketType = new javax.swing.JList<>();
        lblEndDate1 = new javax.swing.JLabel();
        btnAddTicketType = new javax.swing.JButton();
        lblEventLocation = new javax.swing.JLabel();
        txtEventLocation = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Eventure - Events");
        setResizable(false);

        pnlMain.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));

        hdrMain.setFont(new java.awt.Font("Riffic Free Medium", 0, 64)); // NOI18N
        hdrMain.setText("CREATE EVENT");
        hdrMain.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        hdrMain.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        txtEventName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtEventName.setPreferredSize(new java.awt.Dimension(225, 30));
        txtEventName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEventNameActionPerformed(evt);
            }
        });

        lblStartDate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblStartDate.setText("Event Start Date:");
        lblStartDate.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 20, 20));

        lblEventName1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblEventName1.setText("Event Description:");
        lblEventName1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 20, 20));

        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        btnSubmit.setBackground(new java.awt.Color(153, 0, 153));
        btnSubmit.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Submit");
        btnSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSubmitMouseClicked(evt);
            }
        });
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(153, 0, 153));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back to Events");
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
        });
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        frmTxtStartDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        frmTxtStartDate.setPreferredSize(new java.awt.Dimension(225, 30));

        lblEventName2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblEventName2.setText("Event Name:");
        lblEventName2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 20, 20));

        lblEndDate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblEndDate.setText("Event End Date:");
        lblEndDate.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 20, 20));

        frmTxtEndDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        frmTxtEndDate.setPreferredSize(new java.awt.Dimension(225, 30));

        lblStartTime.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblStartTime.setText("Event Start Time:");
        lblStartTime.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 20, 20));

        frmTxtStartTime.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        frmTxtStartTime.setPreferredSize(new java.awt.Dimension(225, 30));

        lblEndTime.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblEndTime.setText("Event End Time:");
        lblEndTime.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 20, 20));

        frmTxtEndTime.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        frmTxtEndTime.setPreferredSize(new java.awt.Dimension(225, 30));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        listTicketType.setModel(ticketListModel);
        jScrollPane2.setViewportView(listTicketType);

        lblEndDate1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblEndDate1.setText("Event Ticket Types:");
        lblEndDate1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 20, 20));

        btnAddTicketType.setBackground(new java.awt.Color(153, 0, 153));
        btnAddTicketType.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAddTicketType.setForeground(new java.awt.Color(255, 255, 255));
        btnAddTicketType.setText("+");
        btnAddTicketType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddTicketTypeMouseClicked(evt);
            }
        });
        btnAddTicketType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTicketTypeActionPerformed(evt);
            }
        });

        lblEventLocation.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblEventLocation.setText("Event Location:");
        lblEventLocation.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 20, 20));

        txtEventLocation.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtEventLocation.setPreferredSize(new java.awt.Dimension(225, 30));
        txtEventLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEventLocationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtEventName, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(hdrMain)
                                .addComponent(txtEventLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblEventName2))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblEventName1)
                    .addComponent(lblEventLocation))
                .addGap(55, 55, 55)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEndDate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(frmTxtStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(frmTxtEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStartDate))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(0, 77, Short.MAX_VALUE)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblStartTime)
                            .addComponent(lblEndTime)
                            .addComponent(frmTxtStartTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(frmTxtEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(btnAddTicketType)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(hdrMain, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblEventName2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEventName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblEventLocation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEventLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(lblEventName1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1)))
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblStartDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(frmTxtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblStartTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(frmTxtStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEndDate)
                    .addComponent(lblEndTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(frmTxtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(frmTxtEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(235, 235, 235))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEndDate1)
                            .addComponent(btnAddTicketType))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        scrlMain.setViewportView(pnlMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNavBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(scrlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlNavBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtEventNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEventNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEventNameActionPerformed

    private void btnSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseClicked
        // TODO add your handling code here:
        // Gather input data
        String eventName = txtEventName.getText();
        String eventLocation = txtEventLocation.getText();
        String eventDescription = txtDescription.getText();
        String startDate = frmTxtStartDate.getText();
        String endDate = frmTxtEndDate.getText();
        String startTime = frmTxtStartTime.getText();
        String endTime = frmTxtEndTime.getText();

        // Gather ticket types from the list
        List<String> ticketTypes = new ArrayList<>();
            Iterator<String> iterator = ticketListModel.elements().asIterator();
            while (iterator.hasNext()) {
                ticketTypes.add(iterator.next());
            }

        // Create an Event object
        Event event = new Event();
        event.setName(eventName);
        event.setLocation(eventLocation);
        event.setDescription(eventDescription);
        event.setStartTimestamp(startDate, startTime);
        event.setEndTimestamp(endDate, endTime);
        event.setCreatorId(Session.getCurrentUser().getId());
        
        // Use the controller to save the event
        Event createdEvent  = eventController.createEvent(event); // Assuming createEvent returns a boolean

        // Provide feedback to the user
        if (createdEvent != null) {
            // Now add ticket types to the TicketTypes table
            boolean ticketSuccess = true;
            for (String ticketType : ticketTypes) {
                TicketType ticket = new TicketType();
                String[] parts = ticketType.split(" - ");

                if (parts.length == 2) {
                    String ticketName = parts[0].trim();
                    String pricePart = parts[1].trim();
                    String priceString = pricePart.replaceAll("[^0-9.]", "");
                    BigDecimal ticketPrice = new BigDecimal(priceString.isEmpty() ? "0.00" : priceString);

                    ticket.setEventId(createdEvent.getId());
                    ticket.setTicketName(ticketName);
                    ticket.setTicketPrice(ticketPrice);

                    ticketSuccess &= ticketController.createTicketType(ticket);
                }
            }


            // Provide feedback to the user
            if (ticketSuccess) {
                if (!"Organizer".equals(Session.getCurrentUser().getRole())){
                    User updatedUser = Session.getCurrentUser();
                    updatedUser.setRole("Organizer");
                    
                    userController.updateUser(updatedUser);
                    Session.setCurrentUser(updatedUser);
                }
                
                JOptionPane.showMessageDialog(this, "Event and ticket types created successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Event created, but failed to add ticket types. Please try again.");
            }

            this.dispose(); // Close the dialog or navigate to another view
            
            EventsView eventsView = new EventsView();
            eventsView.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Failed to create event. Please try again.");
        }
    }//GEN-LAST:event_btnSubmitMouseClicked

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        // TODO add your handling code here:
        this.dispose();
        EventsView eventsView = new EventsView();
        // Optionally pass the database connection or user info if needed
        //DashboardController dashboardController = new DashboardController(dashboardView, dbConnection);
        eventsView.setVisible(true);
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddTicketTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTicketTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddTicketTypeActionPerformed

    private void btnAddTicketTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddTicketTypeMouseClicked
        // TODO add your handling code here:
        dlgAddTicketType dialog = new dlgAddTicketType(CreateEventView.this, ticketListModel);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnAddTicketTypeMouseClicked

    private void txtEventLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEventLocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEventLocationActionPerformed

    public void myInitComponents() {  
        eventController = new EventController(db);
        ticketController = new TicketController(db);
        
        //Creates the DatePickers
        DatePicker dpStartDate = new DatePicker();
        dpStartDate.setEditor(frmTxtStartDate);
        dpStartDate.setDateFormat("MM/dd/yyyy");
        
        DatePicker dpEndDate = new DatePicker();
        dpEndDate.setEditor(frmTxtEndDate);
        dpEndDate.setDateFormat("MM/dd/yyyy");
        
        //Creates the TimePickers
        TimePicker tpStartTime = new TimePicker();
        tpStartTime.setEditor(frmTxtStartTime);
        tpStartTime.setColor(new Color(128, 0, 128));
        
        TimePicker tpEndTime = new TimePicker();
        tpEndTime.setEditor(frmTxtEndTime);
        tpEndTime.setColor(new Color(128, 0, 128));
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
            java.util.logging.Logger.getLogger(CreateEventView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateEventView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateEventView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateEventView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
          
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateEventView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddTicketType;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JFormattedTextField frmTxtEndDate;
    private javax.swing.JFormattedTextField frmTxtEndTime;
    private javax.swing.JFormattedTextField frmTxtStartDate;
    private javax.swing.JFormattedTextField frmTxtStartTime;
    private javax.swing.JLabel hdrMain;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblEndDate;
    private javax.swing.JLabel lblEndDate1;
    private javax.swing.JLabel lblEndTime;
    private javax.swing.JLabel lblEventLocation;
    private javax.swing.JLabel lblEventName1;
    private javax.swing.JLabel lblEventName2;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JLabel lblStartTime;
    private javax.swing.JList<String> listTicketType;
    private javax.swing.JPanel pnlMain;
    private views.shared.components.pnlNavBar pnlNavBar1;
    private javax.swing.JScrollPane scrlMain;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtEventLocation;
    private javax.swing.JTextField txtEventName;
    // End of variables declaration//GEN-END:variables
}
