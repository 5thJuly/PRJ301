/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.utils.DBUtils;

/**
 *
 * @author Hoa Doan
 */
public class FoodDAO {

    public static ArrayList<FoodDTO> search(String name) {
        String SQL = "Select * from tblFoods\n"
                + "where status = 1 and name like ?";
        try {
            Connection conn = DBUtils.makeConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);
            if (name == null) {
                name = "";
            }
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            ArrayList<FoodDTO> list = new ArrayList<>();
            while (rs.next()) {
                FoodDTO obj = new FoodDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4),
                        rs.getInt(5), rs.getBoolean(6));
                list.add(obj);
            }
            return list;
        } catch (Exception ex) {
            System.out.println("get Query Error!" + ex.getMessage());
        }
        return null;
    }

    public static int delete(String name) {
        String SQL = "UPDATE tblFoods \n"
                + "set status =0 \n"
                + "where id like ?";
        try {
            Connection conn = DBUtils.makeConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);
            if (name == null) {
                name = "";
            }
            ps.setString(1, "%" + name + "%");
            System.out.println(name);
            ps.executeUpdate();
            return 1;
        } catch (Exception ex) {
            System.out.println("update Query Error!" + ex.getMessage());
        }
        return 0;
    }
    
}
