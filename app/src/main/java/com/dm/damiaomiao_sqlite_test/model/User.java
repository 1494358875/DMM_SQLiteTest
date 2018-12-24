package com.dm.damiaomiao_sqlite_test.model;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

public class User extends LitePalSupport {
    @Column(unique = true,defaultValue = "unknown")
    private String name;
    private int age;
    private boolean sex;

    public User() {
    }

    public User(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public boolean isSex() {
        return sex;
    }

    public User setSex(boolean sex) {
        this.sex = sex;
        return this;
    }

}
