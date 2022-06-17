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
public class UserDTO {
     private String userID;
    private String userName;
    private String roleID;
    private String password;

    public UserDTO() {
        this.userID = "";
        this.userName = "";
        this.roleID = "";
        this.password = "";
    }
    
    
    public UserDTO(String userID, String userName, String roleID, String password) {
        this.userID = userID;
        this.userName = userName;
        this.roleID = roleID;
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
