package edu.eci.cvds.labReserves.model;

public class Teacher extends User{

    public Teacher(int id, String name, String mail, String password) {
        super(id, name, mail, password);
    }

    @Override
    public boolean removeReserve() {
        return false;
    }
}
