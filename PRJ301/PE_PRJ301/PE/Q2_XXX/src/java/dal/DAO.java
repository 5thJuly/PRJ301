/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Account;
import model.Employee;

/**
 *
 * @author Admin
 */
public class DAO extends DBContext{
    public ArrayList<Account> findAllAccount() {
        ArrayList<Account> acc = new ArrayList<>();
        try {
            String sql = "select * from Account";
            PreparedStatement ptm = connection.prepareStatement(sql);
            ResultSet rs = ptm.executeQuery();
            while(rs.next()) {
                acc.add(new Account(rs.getString(1),rs.getString("password"), rs.getString(3)));
            }
        }
        catch(Exception e) {
            System.out.println("Error" + e.toString());
        }
        return acc;
    }
    public ArrayList<Employee> findAllEmployeeByAccount(String username) {
        ArrayList<Employee> emp = new ArrayList<>();
        try {
            String sql = "select * from Employee where createby = ?";
            PreparedStatement ptm = connection.prepareStatement(sql);
            ptm.setString(1, username);
            ResultSet rs = ptm.executeQuery();
            while(rs.next()) {
                emp.add(new Employee(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate(), rs.getBoolean(4), rs.getString(5)));
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return emp;
    }
}
