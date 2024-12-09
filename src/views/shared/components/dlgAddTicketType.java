package views.shared.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dlgAddTicketType extends JDialog {
    private JTextField txtTicketName;
    private JTextField txtTicketPrice;
    private JButton btnAdd;
    private DefaultListModel<String> ticketListModel;

    public dlgAddTicketType(Frame parent, DefaultListModel<String> ticketListModel) {
        super(parent, "Add Ticket Type", true);
        this.ticketListModel = ticketListModel;

        // Initialize components
        txtTicketName = new JTextField(15);
        txtTicketPrice = new JTextField(15);
        btnAdd = new JButton("Add");

        // Set up layout with GridBagLayout for better control over padding
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding (top, left, bottom, right)

        // Add components with padding
        gbc.gridx = 0; // Column 0
        gbc.gridy = 0; // Row 0
        gbc.anchor = GridBagConstraints.EAST; // Align label to the east (right)
        add(new JLabel("Ticket Name:"), gbc);

        gbc.gridx = 1; // Column 1
        gbc.gridy = 0; // Row 0
        gbc.anchor = GridBagConstraints.WEST; // Align text field to the west (left)
        add(txtTicketName, gbc);

        gbc.gridx = 0; // Column 0
        gbc.gridy = 1; // Row 1
        gbc.anchor = GridBagConstraints.EAST; // Align label to the east (right)
        add(new JLabel("Ticket Price:"), gbc);

        gbc.gridx = 1; // Column 1
        gbc.gridy = 1; // Row 1
        gbc.anchor = GridBagConstraints.WEST; // Align text field to the west (left)
        add(txtTicketPrice, gbc);

        gbc.gridx = 0; // Column 0
        gbc.gridy = 2; // Row 2
        gbc.gridwidth = 2; // Span across two columns
        gbc.anchor = GridBagConstraints.CENTER; // Center the button
        add(btnAdd, gbc);

        // Add action listener for the Add button
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ticketName = txtTicketName.getText();
                String ticketPrice = txtTicketPrice.getText();
                if (!ticketName.isEmpty() && !ticketPrice.isEmpty()) {
                    ticketListModel.addElement(ticketName + " - PHP " + ticketPrice);
                    txtTicketName.setText("");
                    txtTicketPrice.setText("");
                    dispose(); // Close the dialog
                } else {
                    JOptionPane.showMessageDialog(dlgAddTicketType.this, "Please enter both ticket name and price.");
                }
            }
        });

        // Set dialog properties
        pack();
        setLocationRelativeTo(parent);
    }
}