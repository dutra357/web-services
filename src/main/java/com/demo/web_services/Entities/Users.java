package com.demo.web_services.Entities;

import java.io.Serializable;
import java.util.Objects;

public class Users implements Serializable {

    private  long id;
    private String name;
    private String phone;
    private String password;


    public Users() {
    }
    public Users(long id, String name, String phone, String password) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return getId() == users.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
