/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.user.UserDTO;
import pe.utils.DBUtils;

/**
 *
 * @author hd
 */
public class CarDAO {

//   your code here
    public ArrayList<CarDTO> searchCar(String cname) {
        if (cname==null) {
            cname="";
        }
        ArrayList<CarDTO> list = new ArrayList<>();
        DBUtils dbu = new DBUtils();

        String sql = " select * from tblCars where [name] like ?";
        try {
            Connection connection = dbu.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" +cname+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CarDTO c = new CarDTO(rs.getString(1), rs.getString(2), rs.getString(3),
                         rs.getDouble(4), rs.getInt(5), rs.getBoolean(6));
                list.add(c);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    public ArrayList<CarDTO> deleteCar(String cid) {
        ArrayList<CarDTO> list = new ArrayList<>();
        DBUtils dbu = new DBUtils();

        String sql = "   delete tblCars where id = ?";
        try {
            Connection connection = dbu.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cid);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

}
