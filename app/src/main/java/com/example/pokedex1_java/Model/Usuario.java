package com.example.pokedex1_java.Model;

import io.realm.RealmObject;

public class Usuario extends RealmObject {

    private String usuario;
    private String password;

    public Usuario() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
