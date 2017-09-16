package com.meteorsoftech.slidingtablayoutsqlitedemo;

/**
 * Created by Delete on 9/16/2017.
 */

public class Setters {
    private String name;
    private String mob;
    private String email;

    public Setters(String name, String mob, String email) {
        this.name = name;
        this.mob = mob;
        this.email = email;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
