package views.shared.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import models.TicketType;

public class dlgAddTicketType extends JDialog {
    private JTextField txtTicketName;
    private JTextField txtTicketPrice;
    private JTextField txtTicketQuantity;
    private JButton btnAdd;
    private List<TicketType> ticketTypes;

    public dlgAddTicketType(Frame parent, List<TicketType> ticketTypes) {
        super(parent, "Add Ticket Type", true);
        this.ticketTypes = ticketTypes;

        // Initialize components
        txtTicketName = new JTextField(15);
        txtTicketPrice = new JTextField(15);
        txtTicketQuantity = new JTextField(15);
        btnAdd = new JButton("Add");

        // Set up layout with GridBagLayout for better control over padding
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Add Ticket Name label and field
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Ticket Name:"), gbc);

        gbc.gridx = 1;
        add(txtTicketName, gbc);

        // Add Ticket Price label and field
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Ticket Price:"), gbc);

        gbc.gridx = 1;
        add(txtTicketPrice, gbc);

        // Add Ticket Quantity label and field
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Ticket Quantity:"), gbc);

        gbc.gridx = 1;
        add(txtTicketQuantity, gbc);

        // Add Add button
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnAdd, gbc);

        // Add action listener for Add button
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ticketName = txtTicketName.getText();
                String ticketPrice = txtTicketPrice.getText();
                String ticketQuantity = txtTicketQuantity.getText();

                if (!ticketName.isEmpty() && !ticketPrice.isEmpty() && !ticketQuantity.isEmpty()) {
                    try {
                        BigDecimal price = new BigDecimal(ticketPrice);
                        int quantity = Integer.parseInt(ticketQuantity);

                        // Create new TicketType object and add it to the list
                        TicketType ticket = new TicketType(ticketName, price, quantity);
                        ticketTypes.add(ticket);

                        // Clear input fields
                        txtTicketName.setText("");
                        txtTicketPrice.setText("");
                        txtTicketQuantity.setText("");

                        dispose(); // Close the dialog
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(dlgAddTicketType.this,
                                "Please enter a valid price and quantity.");
                    }
                } else {
                    JOptionPane.showMessageDialog(dlgAddTicketType.this,
                            "Please enter all ticket details.");
                }
            }
        });

        // Set dialog properties
        pack();
        setLocationRelativeTo(parent);
    }
}
