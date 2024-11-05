/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;


public class Employee {
    private int empid;
    private String empname;
    private LocalDate date;
    private boolean empgender;
    private String createby;

    public Employee() {
    }

    public Employee(int empid, String empname, LocalDate date, boolean empgender, String createby) {
        this.empid = empid;
        this.empname = empname;
        this.date = date;
        this.empgender = empgender;
        this.createby = createby;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEmpGender() {
        return empgender ? "Male" : "Female" ;
    }

    public void setEmpgender(boolean empgender) {
        this.empgender = empgender;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }
    
    
}
