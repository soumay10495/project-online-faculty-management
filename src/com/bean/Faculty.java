package com.bean;

public class Faculty {
    private int id;
    private String name;
    private String address;
    private String stream;
    private double salary;
    private int years_of_experience;
    private long phoneno;
    private String grade;

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public String getStream(){
        return stream;
    }

    public double getSalary(){
        return salary;
    }

    public int getYears_of_experience(){
        return years_of_experience;
    }

    public long getPhoneno(){
        return phoneno;
    }

    public String getGrade(){
        return grade;
    }

    public void setId(int id){
        this.id=id;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setAddress(String address){
        this.address=address;
    }

    public void setStream(String stream){
        this.stream=stream;
    }

    public void setSalary(double salary){
        this.salary=salary;
    }

    public void setYears_of_experience(int years_of_experience){
        this.years_of_experience=years_of_experience;
    }

    public void setPhoneno(long phoneno){
        this.phoneno=phoneno;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
