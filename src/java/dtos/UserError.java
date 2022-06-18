/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author Trong Duy
 */
public class UserError {
    private String userID;
    private String email;
    private String phone;

    public UserError() {
        this.userID = "";
        this.email = "";
        this.phone = "";
    }

    public UserError(String userID, String gmail, String phone) {
        this.userID = userID;
        this.email = gmail;
        this.phone = phone;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}
