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

    private static final String GET_ALL_ACTIVE = "SELECT id, name, description, price, cookingTime, status FROM tblFoods WHERE status=1";
    private static final String GET_BY_NAME = "SELECT id, name, description, price, cookingTime, status FROM tblFoods WHERE name LIKE ?";
    private static final String REMOVE = "UPDATE tblFoods SET status=0 WHERE id=?";

    public List<FoodDTO> getAll() throws SQLException {
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        List<FoodDTO> list = new ArrayList<>();
        try {
            con = DBUtils.makeConnection();
            ptm = con.prepareStatement(GET_ALL_ACTIVE);
            rs = ptm.executeQuery();
            while (rs.next()) {
                list.add(new FoodDTO(rs.getString("id").trim(), rs.getString("name").trim(), 
                        
                        rs.getString("description").trim(), rs.getDouble("price"), rs.getInt("cookingTime"), rs.getBoolean("status")));
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
        return list;
    }

    public List<FoodDTO> getByName(String search) throws SQLException {
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        List<FoodDTO> list = new ArrayList<>();
        try {
            con = DBUtils.makeConnection();
            ptm = con.prepareStatement(GET_BY_NAME);
            ptm.setString(1, "%" + search + "%");
            rs = ptm.executeQuery();
            while (rs.next()) {
                list.add(new FoodDTO(rs.getString("id").trim(), rs.getString("name").trim(), rs.getString("description").trim(), 
                        rs.getDouble("price"), rs.getInt("cookingTime"), rs.getBoolean("status")));
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
        return list;
    }

    public boolean remove(String foodId) throws SQLException {
        Connection con = null;
        PreparedStatement ptm = null;
        boolean check = false;
        try {
            con = DBUtils.makeConnection();
            ptm = con.prepareStatement(REMOVE);
            ptm.setString(1, foodId);
            check = ptm.executeUpdate() > 0;

        } catch (Exception e) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }
}
