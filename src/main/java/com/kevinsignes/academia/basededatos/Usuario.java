package com.kevinsignes.academia.basededatos;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Usuario implements UserDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idUsuario", nullable = false)
    private int idUsuario;
    @Basic
    @Column(name = "username", nullable = true, length = 45)
    private String username;
    @Basic
    @Column(name = "Password", nullable = true, length = 45)
    private String password;
    @Basic
    @Column(name = "Rol", nullable = true, length = 45)
    private String rol;
    @Basic
    @Column(name = "Nombre", nullable = true, length = 45)
    private String nombre;
    @Basic
    @Column(name = "Apellido1", nullable = true, length = 45)
    private String apellido1;
    @Basic
    @Column(name = "Apellido2", nullable = true, length = 45)
    private String apellido2;
    @Basic
    @Column(name = "Fecha_nacimiento", nullable = true, length = 45)
    private String fechaNacimiento;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }


    public void setUsername(String usuarioName) {
        this.username = usuarioName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return idUsuario == usuario.idUsuario && Objects.equals(username, usuario.username) && Objects.equals(password, usuario.password) && Objects.equals(rol, usuario.rol) && Objects.equals(nombre, usuario.nombre) && Objects.equals(apellido1, usuario.apellido1) && Objects.equals(apellido2, usuario.apellido2) && Objects.equals(fechaNacimiento, usuario.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, username, password, rol, nombre, apellido1, apellido2, fechaNacimiento);
    }

}