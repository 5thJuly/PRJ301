/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.utils.DBUtils;

/**
 *
 * @author Yuh A
 */
public class UserDAO {

    private static final String CHECK_LOGIN = "SELECT fullName, roleID FROM tblUsers WHERE userID=? AND password=?";

    public UserDTO getAccount(String userId, String password) throws SQLException {
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        UserDTO user = null;
        try {
            con = DBUtils.makeConnection();
            ptm = con.prepareStatement(CHECK_LOGIN);
            ptm.setString(1, userId);
            ptm.setString(2, password);
            rs = ptm.executeQuery();
            if (rs.next()) {
                user = new UserDTO(userId, rs.getString("fullName").trim(), "*****", rs.getString("roleId").trim());
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return user;
    }
}
