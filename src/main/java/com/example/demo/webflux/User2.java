package com.example.demo.webflux;

import org.springframework.data.annotation.Id;

public class User2 {
    @Id
    private int id;
    private String name;

    public User2() {
    }

    public User2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
