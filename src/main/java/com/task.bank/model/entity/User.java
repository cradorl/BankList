package com.task.bank.model.entity;

public class User {
    private int userId;
    private String name;
    private String surname;

    public User(int userId, String name, String surname) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "User: " +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'';
    }

    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
