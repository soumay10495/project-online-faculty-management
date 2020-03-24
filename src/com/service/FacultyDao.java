package com.service;

import com.bean.Faculty;
import com.dao.Dao;

import java.util.ArrayList;

public class FacultyDao {
    public boolean addFaculty(Faculty f){
        Dao d=new Dao();
        return d.addFaculty(f);
    }

    public boolean removeFaculty(int id){
        Dao d=new Dao();
        return d.removeFaculty(id);
    }

    public boolean updateFaculty(int id, String address){
        Dao d= new Dao();
        return d.updateFaculty(id,address);
    }

    public ArrayList<Faculty> displayFaculty(){
        Dao d=new Dao();
        return d.displayFaculty();
    }
}
