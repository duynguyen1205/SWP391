/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dbutils.DBUtils;
import dtos.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Trong Duy
 */
public class UserDao {
    private static final String LOGIN = "SELECT UserName, RoleID FROM UserTable WHERE UserID=? and UserPassword=? and status='true'";
    
    public UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, userID);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if(rs.next()) {
                    String fullName = rs.getString("UserName");
                    String roleID = rs.getString("RoleID");
                    user = new UserDTO(userID, fullName, roleID, "***");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return user;
    }
}
