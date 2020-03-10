package com.codeup.adlister.models;

public class Contract {
    private long id;
    private long userId;
    private String title;
    private String description;
    private String country;
    private double reward;

    public Contract(long id, long userId, String title, String description, String country, double reward) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.country = country;
        this.reward = reward;
    }

    public Contract(long userId, String title, String description, String country, double reward) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.country = country;
        this.reward = reward;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(long reward) {
        this.reward = reward;
    }
}
