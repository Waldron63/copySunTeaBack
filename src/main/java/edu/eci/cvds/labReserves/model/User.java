package edu.eci.cvds.labReserves.model;

import java.util.HashMap;

public abstract class User {
    private int id;
    private String name;
    private String mail;
    private String password;
    private HashMap<Schedule,Reserve> reserves;

    public User(int id, String name, String mail, String password) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.reserves = new HashMap<>();
    }

    
}
