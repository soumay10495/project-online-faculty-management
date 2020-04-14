package com.dao;

import com.bean.Faculty;
import com.dbUtil.DBUtil;

import javax.swing.table.TableRowSorter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao {
    public boolean addFaculty(Faculty f){
        Connection con= DBUtil.getConnection();
        PreparedStatement pst=null;
        String query;
        boolean flag=true;
        try{
            query="Insert into Faculty values(Faculty_Sequence.nextval,?,?,?,?,?,?,?)";
            pst=con.prepareStatement(query);
            pst.setString(1,f.getName());
            pst.setString(2,f.getAddress());
            pst.setString(3,f.getStream());
            pst.setDouble(4,f.getSalary());
            pst.setInt(5,f.getYears_of_experience());
            pst.setLong(6,f.getPhoneno());
            pst.setString(7,f.getGrade());
            pst.executeUpdate();
        }catch(SQLException e){
            flag=false;
            e.printStackTrace();
        }
        finally {
            try {
                pst.close();
            } catch (SQLException|NullPointerException e) {
                e.printStackTrace();
            }
            DBUtil.closeConnection(con);
        }
        return flag;
    }



    public boolean removeFaculty(Integer id){
        boolean isValid=isFacultyValid(id);
        if(!isValid)
            return false;

        Connection con=DBUtil.getConnection();
        PreparedStatement pst = null;
        String query;
        boolean flag=true;
        try{
            query="Delete from Faculty where id="+id;
            pst=con.prepareStatement(query);
            pst.executeUpdate();
        }catch(SQLException e){
            flag=false;
            e.printStackTrace();
        }finally {
            try {
                pst.close();
            } catch (SQLException|NullPointerException e) {
                e.printStackTrace();
            }
            DBUtil.closeConnection(con);
        }
        return flag;
    }



    public boolean updateFaculty(Integer id, String address){
        boolean isValid=isFacultyValid(id);
        if(!isValid)
            return false;

        Connection con=DBUtil.getConnection();
        PreparedStatement pst=null;
        String query=null;
        boolean flag= true;
        try{
            query="Update Faculty set address='"+address+"' where id="+id;
            pst=con.prepareStatement(query);
            pst.executeUpdate();
        }catch(SQLException e){
            flag=false;
            e.printStackTrace();
        }
        finally {
            try {
                pst.close();
            } catch (SQLException|NullPointerException e) {
                e.printStackTrace();
            }
            DBUtil.closeConnection(con);
        }
        return flag;
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
            }catch(SQLException|NullPointerException e){
                e.printStackTrace();
            }
            DBUtil.closeConnection(con);
        }
        return facs;
    }

    public boolean isFacultyValid(Integer id){
        Connection con=DBUtil.getConnection();
        PreparedStatement pst=null;
        ResultSet rs=null;
        String query;
        boolean flag=true;
        try{
            query="Select * from Faculty where id="+id;
            pst=con.prepareStatement(query);
            rs=pst.executeQuery();
            int count=0;
            while(rs.next()) count++;
            if(count==0)
                flag=false;
        }catch(SQLException e){
            flag=false;
            e.printStackTrace();
        }
        finally {
            try{
                pst.close();
            }catch(SQLException|NullPointerException e){
                e.printStackTrace();
            }
            DBUtil.closeConnection(con);
        }
        return flag;
    }

}
