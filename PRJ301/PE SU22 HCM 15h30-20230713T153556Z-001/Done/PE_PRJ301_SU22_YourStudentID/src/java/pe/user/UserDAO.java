/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.utils.DBUtils;

/**
 *
 * @author Hoadnt
 */
public class UserDAO {
//    your code here

    public ArrayList<UserDTO> getAccount() {
        ArrayList<UserDTO> list = new ArrayList<>();
        DBUtils dbu = new DBUtils();

        String sql = "select * from tblUsers";
        try {
            Connection connection = dbu.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserDTO a = new UserDTO(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4));
                list.add(a);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

}
