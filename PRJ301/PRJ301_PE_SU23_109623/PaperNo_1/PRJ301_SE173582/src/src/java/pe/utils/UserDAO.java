/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class UserDAO {

    private static final String LOGIN = "select fullName, roleID from tblUsers WHERE userID=? AND password=?";
    private static final String SEARCH = "SELECT id, name, description, price, size, status FROM tblFashion WHERE name LIKE ?";

    public UserDTO checkLog(String userID, String password) throws SQLException {
        UserDTO us = null;
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
                    String fullName = rs.getString("fullName");
                    String roleId = rs.getString("roleID");
                    us = new UserDTO(userID, fullName, roleId, "");
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
        return us;
    }

    public List<ClothesDTO> getList(String search) throws ClassNotFoundException, SQLException {
        List<ClothesDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String size = rs.getString("speed");
                    boolean status = rs.getBoolean("status");
                    
                    list.add(new ClothesDTO(id, name, description, price, size, status));
                }
            }
        }
        catch(Exception e) {
            
        }
        finally{
            if (rs!= null) rs.close();
            if (ptm!= null) ptm.close();
            if (conn!= null) conn.close();
        }
        return list;
    }

}
