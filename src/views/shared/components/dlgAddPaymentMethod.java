package views.shared.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import models.PaymentMethod;
import controllers.PaymentMethodController; // Import the PaymentMethodController
import utility.Session;

public class dlgAddPaymentMethod extends JDialog {
    private JTextField txtPaymentType;
    private JTextField txtAccountNumber;
    private JTextField txtExpirationDate;
    private JButton btnAdd;
    private List<PaymentMethod> paymentMethods;
    private PaymentMethodController paymentMethodController; // Controller for payment methods

    public dlgAddPaymentMethod(Frame parent, List<PaymentMethod> paymentMethods, PaymentMethodController paymentMethodController) {
        super(parent, "Add Payment Method", true);
        this.paymentMethods = paymentMethods;
        this.paymentMethodController = paymentMethodController;

        txtPaymentType = new JTextField(15);
        txtAccountNumber = new JTextField(15);
        txtExpirationDate = new JTextField(15);
        btnAdd = new JButton("Add");

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Payment Type:"), gbc);

        gbc.gridx = 1;
        add(txtPaymentType, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Account Number:"), gbc);

        gbc.gridx = 1;
        add(txtAccountNumber, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Expiration Date (optional, MM/yyyy):"), gbc);

        gbc.gridx = 1;
        add(txtExpirationDate, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnAdd, gbc);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String paymentType = txtPaymentType.getText();
                String accountNumber = txtAccountNumber.getText();
                String expirationDateStr = txtExpirationDate.getText();

                if (!paymentType.isEmpty() && !accountNumber.isEmpty()) {
                    PaymentMethod paymentMethod = new PaymentMethod();
                    paymentMethod.setUserId(Session.getCurrentUser().getId());
                    paymentMethod.setPaymentType(paymentType);
                    paymentMethod.setAccountNumber(accountNumber);

                    if (!expirationDateStr.isEmpty()) {
                        try {
                            SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
                            Date expirationDate = sdf.parse(expirationDateStr);
                            paymentMethod.setExpirationDate(expirationDate);
                        } catch (ParseException ex) {
                            JOptionPane.showMessageDialog(dlgAddPaymentMethod.this,
                                    "Please enter a valid expiration date in MM/yyyy format.");
                            return;
                        }
                    } else {
                        paymentMethod.setExpirationDate(null);
                    }

                    int confirmation = JOptionPane.showConfirmDialog(dlgAddPaymentMethod.this,
                            "Are you sure you want to add this payment method?\n" +
                            "Payment Type: " + paymentType + "\n" +
                            "Account Number: " + accountNumber + "\n" +
                            "Expiration Date: " + expirationDateStr,
                            "Confirm Addition", JOptionPane.YES_NO_OPTION);

                    if (confirmation == JOptionPane.YES_OPTION) {
                        paymentMethodController.addPaymentMethod(paymentMethod); // Add to database
                        paymentMethods.add(paymentMethod);
                        txtPaymentType.setText("");
                        txtAccountNumber.setText("");
                        txtExpirationDate.setText("");
                        dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(dlgAddPaymentMethod.this,
                            "Please enter all required payment details.");
                }
            }
        });

        pack();
        setLocationRelativeTo(parent);
    }
}