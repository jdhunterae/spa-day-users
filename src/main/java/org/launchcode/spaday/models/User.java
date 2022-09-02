package org.launchcode.spaday.models;

import java.util.Date;

public class User {
    private static int userId = 0;
    private int id;
    private String username;
    private String password;
    private String email;
    private Date joined;

    public User() {
        id = userId++;
        username = "";
        password = "";
        email = "";
        joined = new Date();
    }

    public User(int id, String username, String email, String password, Date joined) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.joined = joined;

        userId = Math.max(userId, id++);
    }

    @Override
    public String toString() {
        return username;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getJoined() {
        return joined;
    }

    public void setJoined(Date joined) {
        this.joined = joined;
    }
}
