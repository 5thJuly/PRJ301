/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.shopping;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import sample.user.UserDTO;
import sample.utils.DBUtils;


public class Shopping_cart {
    
    private static final String CHECKOUT = "SELECT id, name, price, quantity FROM tblCheckout";
    
    public List<Comestic> getProduct() throws SQLException {
        List<Comestic> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn != null){
                ptm = conn.prepareStatement(CHECKOUT);
                rs = ptm.executeQuery();
                while(rs.next()){   
                    String id = rs.getString("id");
                    String name = rs.getString("name");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");              
                    list.add(new Comestic(id, name, price, quantity));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(rs != null) rs.close();
            if(ptm != null) ptm.close();
            if(conn != null) conn.close();
        }
        return list;
    }
}

