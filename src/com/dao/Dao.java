package com.dao;

import com.bean.Faculty;
import com.dbUtil.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao {
    public boolean addFaculty(Faculty f){
        Connection con= DBUtil.getConnection();
        PreparedStatement pst=null;
        String query=null;
        try{
            query="Insert into Faculty values(Faculty_Sequence.nextval,?,?,?,?,?,?,?)";
            pst=con.prepareStatement(query);
            pst.setInt(1,f.getId());
            pst.setString(2,f.getName());
            pst.setString(3,f.getAddress());
            pst.setString(4,f.getStream());
            pst.setDouble(5,f.getSalary());
            pst.setInt(6,f.getYears_of_experience());
            pst.setLong(7,f.getPhoneno());
            pst.setString(7,f.getGrade());
            pst.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBUtil.closeConnection(con);
            return true;
        }
    }



    public boolean removeFaculty(int id){
        Connection con=DBUtil.getConnection();
        PreparedStatement pst = null;
        String query = null;
        try{
            query="Delete from Faculty where id="+id;
            pst=con.prepareStatement(query);
            pst.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBUtil.closeConnection(con);
            return true;
        }
    }



    public boolean updateFaculty(int id, String address){
        Connection con=DBUtil.getConnection();
        PreparedStatement pst=null;
        String query=null;
        try{
            query="Update Faculty set address="+address+" where id="+id;
            pst=con.prepareStatement(query);
            pst.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBUtil.closeConnection(con);
            return true;
        }
    }



    public ArrayList<Faculty> displayFaculty(){
        ArrayList<Faculty> facs=new ArrayList<Faculty>();
        Connection con=DBUtil.getConnection();
        PreparedStatement pst=null;
        ResultSet rs=null;
        String query=null;
        try{
            query="Select * from Faculty";
            pst=con.prepareStatement(query);
            rs=pst.executeQuery();

            while(rs.next()){
                Faculty f= new Faculty();
                f.setId(rs.getInt(1));
                f.setName(rs.getString(2));
                f.setAddress(rs.getString(3));
                f.setStream(rs.getString(4));
                f.setSalary(rs.getDouble(5));
                f.setYears_of_experience(rs.getInt(6));
                f.setPhoneno(rs.getLong(7));
                f.setGrade(rs.getString(8));
                facs.add(f);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            try{
                pst.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
            DBUtil.closeConnection(con);
            return facs;
        }
    }
}
