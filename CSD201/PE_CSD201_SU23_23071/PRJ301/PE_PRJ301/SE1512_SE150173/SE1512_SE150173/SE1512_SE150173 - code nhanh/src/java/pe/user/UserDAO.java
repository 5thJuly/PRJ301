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

    public static UserDTO login(String user, String pass) {
        String SQL = "select * from tblUsers\n"
                + "where userID = ? and password = ?";
        try {
            Connection conn = DBUtils.makeConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                UserDTO userD = new UserDTO(rs.getString(1),
                        rs.getString(2), rs.getString(3), null);
                return userD;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
