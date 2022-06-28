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
import java.util.ArrayList;

/**
 *
 * @author Trong Duy
 */
public class UserDao {

    private static final String LOGIN = "SELECT UserName, RoleID, Email, Phone FROM UserTable WHERE UserID=? AND UserPassword=? AND status='true'";
    private static final String CHECK_DUPLICATE_USERID = "SELECT Email, Phone FORM UserTable WHERE UserID=? AND status='true'";
    private static final String CHECK_DUPLICATE = "SELECT Email, Phone FORM UserTable WHERE UserID=? AND status='true'";
    private static final String CREATE = "INSERT INTO UserTable(UserID, RoleID, UserName, UserPassword, Phone, Email, Address, Status) \n" +
"VALUES(?, 'US', 'none', ?, ?, ?, null, 1)";
    private static final String UPDATE = "UPDATE UserTable SET UserName=?, Phone=?, Email=? WHERE UserID=?";
    private static final String CHAHGE_PASS = "UPDATE UserTable SET UserPassword=? WHERE UserID=?";
    public UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, userID);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("UserName");
                    String roleID = rs.getString("RoleID");
                    String email = rs.getString("Email");
                    String phone = rs.getString("Phone");
                    user = new UserDTO(userID, fullName, roleID, email, phone, password);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;
    }

    public Boolean checkDuplicateUser(String userID) throws SQLException {
        Boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE_USERID);
                ptm.setString(1, userID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
     public boolean checkDuplicate(String userID, String param) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        ArrayList<String> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, userID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                   String email = rs.getString("Email");
                   String phone = rs.getString("Phone");
                   list.add(email);
                   list.add(phone);
                }
                for (int i = 0; i < list.size(); i++) {
                    if(param.equalsIgnoreCase(list.get(i))) {
                        check = true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
     
    public boolean createUser(UserDTO user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();

            if (conn != null) {
                ptm = conn.prepareStatement(CREATE);
                ptm.setString(1, user.getUserID());
                ptm.setString(2,user.getPassword());
                ptm.setString(3, user.getPhone());
                ptm.setString(4, user.getEmail());
                check = ptm.executeUpdate() > 0 ? true : false;

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;

     }
    public boolean updateUser(String userID, String fullName, String email, String phone) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ptm=conn.prepareStatement(UPDATE);
                ptm.setString(1, fullName);
                ptm.setString(2, phone);
                ptm.setString(3, email);
                ptm.setString(4, userID);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    public boolean updatePass(String userID, String newPass) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ptm=conn.prepareStatement(CHAHGE_PASS);
                ptm.setString(1, newPass);
                ptm.setString(2, userID);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
}
