/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author andre
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.User;
import org.mindrot.jbcrypt.BCrypt;
import utility.Database;
import utility.PasswordUtils;

public class UserController {
    private Database db;

    // Constructor to initialize the database connection
    public UserController(Database db) {
        this.db = db;
    }

    // CREATE: Add a new user to the database
    public void createUser(User user) {
        String sql = "INSERT INTO users (username, password, first_name, last_name, email, role) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, user.getUsername());
            
            String hashedPassword = PasswordUtils.hashPassword(user.getPassword());
            
            pstmt.setString(2, hashedPassword);
            pstmt.setString(3, user.getFirstName());
            pstmt.setString(4, user.getLastName());
            pstmt.setString(5, user.getEmail());
            pstmt.setString(6, user.getRole());
            pstmt.executeUpdate();

            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getInt(1)); // Set the generated ID
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // LOGIN: Check if the user exists with the given username and password
    public User loginUser(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement pstmt = db.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);  // In a real application, you should hash the password for comparison!
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToUser(rs);  // Return the user object if credentials are correct
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // Return null if credentials are incorrect
    }

    // READ: Retrieve a user by their ID
    public User getUserById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement pstmt = db.getConnection().prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public User getUserByUsername(String username) {
        Connection connection = db.getConnection();
        User user = null;
        String query = "SELECT * FROM users WHERE username = ?";  // Adjust if necessary

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String retrievedUsername = rs.getString("username");
                String retrievedPassword = rs.getString("password");  // Hashed password stored in DB
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                Timestamp dateCreated = rs.getTimestamp("date_created");
                Timestamp dateUpdated = rs.getTimestamp("date_updated");
                String role = rs.getString("role");

                user = new User(id, retrievedUsername, retrievedPassword, firstName, lastName, email, dateCreated, dateUpdated, role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }



    // READ: Retrieve all users
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Statement stmt = db.getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                users.add(mapResultSetToUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // UPDATE: Update an existing user's details
    public boolean updateUser(User user, String existingHashedPassword) {
        String passwordToStore;

        // Check if the provided password is already hashed
        if (user.getPassword() == null ? existingHashedPassword == null : user.getPassword().equals(existingHashedPassword)) {
            passwordToStore = existingHashedPassword;
        } else {
            passwordToStore = PasswordUtils.hashPassword(user.getPassword());
        }
        
        String sql = "UPDATE users SET username = ?, password = ?, first_name = ?, last_name = ?, email = ?, role = ? WHERE id = ?";
        try (PreparedStatement pstmt = db.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, passwordToStore);
            pstmt.setString(3, user.getFirstName());
            pstmt.setString(4, user.getLastName());
            pstmt.setString(5, user.getEmail());
            pstmt.setString(6, user.getRole());
            pstmt.setInt(7, user.getId());
            return pstmt.executeUpdate() > 0; // Returns true if update was successful
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    //If not changing password
    public boolean updateUser(User user) {
        String sql = "UPDATE users SET username = ?, first_name = ?, last_name = ?, email = ?, role = ? WHERE id = ?";
        try (PreparedStatement pstmt = db.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getFirstName());
            pstmt.setString(3, user.getLastName());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getRole());
            pstmt.setInt(6, user.getId());
            return pstmt.executeUpdate() > 0; // Returns true if update was successful
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // DELETE: Remove a user by their ID
    public boolean deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement pstmt = db.getConnection().prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0; // Returns true if deletion was successful
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Helper method: Map a ResultSet row to a User object
    private User mapResultSetToUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getTimestamp("date_created"),
                rs.getTimestamp("date_updated"),
                rs.getString("role")
        );
    }
}
