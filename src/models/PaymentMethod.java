package models;

import java.util.Date;

public class PaymentMethod {
    private int id; // Unique identifier for the payment method
    private int userId; // Foreign key to link to the User
    private String paymentType; // Type of payment method (e.g., GCash, Maya, Credit Card)
    private String accountNumber; // Account number or identifier for the payment method
    private Date expirationDate; // Expiration date for credit cards (if applicable)
    private boolean isDefault; // Flag to indicate if this is the default payment method

    // Constructor
    public PaymentMethod() {
    }
     
    public PaymentMethod(int userId, String paymentType, String accountNumber, Date expirationDate, boolean isDefault) {
        this.userId = userId;
        this.paymentType = paymentType;
        this.accountNumber = accountNumber;
        this.expirationDate = expirationDate;
        this.isDefault = isDefault;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }
}