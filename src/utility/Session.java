/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import java.awt.Window;
import models.User;
import views.LoginView;

/**
 *
 * @author andre
 */
public class Session {
    private static User currentUser;

    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    public static User getCurrentUser() {
        return currentUser;
    }
    
    public static void logout(Window currentWindow){
        currentWindow.dispose();
        LoginView loginView = new LoginView();
        loginView.setVisible(true);
    }
}
