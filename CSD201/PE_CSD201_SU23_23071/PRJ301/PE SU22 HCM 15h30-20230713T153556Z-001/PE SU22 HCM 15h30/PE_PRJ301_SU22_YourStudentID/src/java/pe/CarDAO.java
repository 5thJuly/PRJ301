/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.user.UserDTO;
import pe.utils.DBUtils;

/**
 *
 * @author hd
 */
public class CarDAO {
    
    
    private static final String SEARCH="SELECT id, name, description,price, speed, status  FROM tblCars WHERE name like ?";  
    private static final String DELETE = "delete tblCars where id = ?";
        private static final String UPDATE = "UPDATE tblCars SET name = ?,  description=?, price=?,speed = ? WHERE id = ? ";


    public List<CarDTO> getList(String search) throws SQLException {
        List<CarDTO> list= new ArrayList<>();
        Connection conn= null;
        PreparedStatement ptm =null;
        ResultSet rs = null;
        try{
            conn=DBUtils.getConnection();
            if(conn!= null){
                ptm= conn.prepareStatement(SEARCH);
                ptm.setString(1, "%"+search+"%");
                rs= ptm.executeQuery();
                while(rs.next()){
                    String id = rs.getString("id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    int speed = rs.getInt("speed");
                    boolean status = rs.getBoolean("status");
                    
                    list.add(new CarDTO(id, name, description, price, speed, status));
                }
            }
        }catch(Exception e){
            
        }finally{
            if (rs!= null) rs.close();
            if (ptm!= null) ptm.close();
            if (conn!= null) conn.close();
        }
        return list;
    }
    
    public ArrayList<CarDTO> deleteCar(String cid) {
        ArrayList<CarDTO> list = new ArrayList<>();
        DBUtils dbu = new DBUtils();

        
        try {
            Connection connection = dbu.getConnection();
            PreparedStatement ps = connection.prepareStatement(DELETE);
            ps.setString(1, cid);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public boolean update(CarDTO cuser) throws SQLException{
        boolean check = false;
        
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1,cuser.getName());
                ptm.setString(2,cuser.getDescription());
                ptm.setFloat(3,cuser.getPrice());
                ptm.setInt(4, cuser.getSpeed());
                
                
                check = ptm.executeUpdate()>0?true:false;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally{
            if(ptm != null) {
                ptm.close();
            }
            if(conn!= null) {
                conn.close();
            }
        }
        return check;
    }


    

  
    
}
