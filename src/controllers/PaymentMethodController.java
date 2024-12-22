package controllers;

import models.PaymentMethod;
import utility.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentMethodController {
    private Database db;

    public PaymentMethodController(Database db) {
        this.db = db;
    }

    public void addPaymentMethod(PaymentMethod paymentMethod) {
        String sql = "INSERT INTO PaymentMethods (user_id, payment_type, account_number, expiration_date, is_default, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, paymentMethod.getUserId());
            pstmt.setString(2, paymentMethod.getPaymentType());
            pstmt.setString(3, paymentMethod.getAccountNumber());
            pstmt.setDate(4, paymentMethod.getExpirationDate() != null ? new Date(paymentMethod.getExpirationDate().getTime()) : null);
            pstmt.setBoolean(5, paymentMethod.isDefault());
            pstmt.setTimestamp(6, new Timestamp(System.currentTimeMillis())); // Set created_at to current time
            pstmt.setTimestamp(7, new Timestamp(System.currentTimeMillis())); // Set updated_at to current time
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePaymentMethod(PaymentMethod paymentMethod) {
        String sql = "UPDATE PaymentMethods SET payment_type = ?, account_number = ?, expiration_date = ?, is_default = ?, updated_at = ? WHERE id = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, paymentMethod.getPaymentType());
            pstmt.setString(2, paymentMethod.getAccountNumber());
            pstmt.setDate(3, paymentMethod.getExpirationDate() != null ? new Date(paymentMethod.getExpirationDate().getTime()) : null);
            pstmt.setBoolean(4, paymentMethod.isDefault());
            pstmt.setTimestamp(5, new Timestamp(System.currentTimeMillis())); // Update the timestamp
            pstmt.setInt(6, paymentMethod.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePaymentMethod(int id) {
        String sql = "DELETE FROM PaymentMethods WHERE id = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PaymentMethod> getPaymentMethodsByUserId(int userId) {
        List<PaymentMethod> paymentMethods = new ArrayList<>();
        String sql = "SELECT * FROM PaymentMethods WHERE user_id = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                PaymentMethod paymentMethod = new PaymentMethod();
                paymentMethod.setId(rs.getInt("id"));
                paymentMethod.setUserId(rs.getInt("user_id"));
                paymentMethod.setPaymentType(rs.getString("payment_type"));
                paymentMethod.setAccountNumber(rs.getString("account_number"));
                paymentMethod.setExpirationDate(rs.getDate("expiration_date"));
                paymentMethod.setDefault(rs.getBoolean("is_default"));
                paymentMethods.add(paymentMethod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paymentMethods;
    }
}