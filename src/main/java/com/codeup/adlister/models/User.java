package com.codeup.adlister.models;

public class User {
    private long id;
    private long roleId;
    private String username;
    private String email;
    private String password;

    public User() {}

    public User(long roleId, String username, String email, String password) {
        this.roleId = roleId;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(long id, long roleId, String username, String email, String password) {
        this.id = id;
        this.roleId = roleId;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
