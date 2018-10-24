package com.business.ventas.model;


import javax.persistence.*;

@Entity
@Table(name="user_roles")
public class Rol {

    @Id
    @Column(name="user_role_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name="username")
    private String username;
    @Column(name="role")
    private String rol;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
