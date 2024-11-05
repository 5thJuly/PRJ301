
package sample.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.utils.DBUtils;



public class UserDAO {
    private static final String LOGIN="SELECT userID FROM tblUsers WHERE userID=? AND password=?";
    private static final String SEARCH="SELECT userID, fullName, roleID FROM tblUsers WHERE fullName like ?";


    
    public boolean checkLogin(String userID, String password) throws SQLException {
        boolean check= false;
        Connection conn= null;
        PreparedStatement ptm= null;
        ResultSet rs=null;
        try{
            conn= DBUtils.getConnection();
            if(conn!= null){
                ptm=conn.prepareStatement(LOGIN);
                ptm.setString(1, userID); // gan userID=? AND password (1)
                ptm.setString(2, password); // gan userID=? AND password=? (2)
                rs=ptm.executeQuery(); // thuc thi cau truy van sql o tren roi đẩy qua SQL để thực hiện
                if(rs.next()){ 
                    check=true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if(rs!= null) rs.close(); // dong reset truoc
            if(ptm!= null) ptm.close(); // tiep theo dong PreparedStatement
            if(conn!= null) conn.close(); // Connection 
            // Phải đóng theo thứ tự
        }
        return check;
    }

    public List<UserDTO> getListUser(String search) throws SQLException {
        List<UserDTO> listUser = new ArrayList<UserDTO>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(SEARCH);
            ptm.setString(1,"%" + search + "%");
            rs = ptm.executeQuery();
            while(rs.next()) {
                String userID = rs.getString("userID");
                String fullName = rs.getString("fullName");
                String roleID = rs.getString("roleID");
                String password = "***";
                listUser.add(new UserDTO(userID, fullName, roleID, password));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally{
            if(rs != null) rs.close();
            if(ptm != null) ptm.close();
            if(conn != null) conn.close();
        }
        return listUser;
    }
    
}
