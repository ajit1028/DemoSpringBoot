package com.example.DemoSpringBoot.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "user_table")
public class UserModel {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone_number")
    private int phoneNumber;

    @Column(name = "team")
    private String team;



    // Getters and setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }





    // Constructors
    public UserModel() {
    }

    public UserModel(int userId, String userName, String password, int phoneNumber, String team) {
        this.userId = userId;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.team = team;
    }
}
