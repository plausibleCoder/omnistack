package com.example.demo.model;

public class UserDetails {
    
    private String userName;
    private int userId;
    private String address;


   public UserDetails(String userName, int userId, String address){
        this.address=address;
        this.userId=userId;
        this.userName=userName;
    }
    
    public void setUserName(String userName){
        this.userName=userName;
    }

    public String getUserName(){
        return this.userName;
    }

    public void setUserId(int userId){
        this.userId=userId;
    }

    public int getUserId(){
        return this.userId;
    }

    public void setAddress(String address){
        this.address=address;
    }

    public String getAddress(){
        return this.address;
    }

}
