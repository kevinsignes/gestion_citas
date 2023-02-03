package com.kevinsignes.academia.basededatos;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "usuario", schema = "academia", catalog = "")
public class UsuarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idUsuario", nullable = false)
    private int idUsuario;
    @Basic
    @Column(name = "Usuario_Name", nullable = true, length = 45)
    private String usuarioName;
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

    public String getUsuarioName() {
        return usuarioName;
    }

    public void setUsuarioName(String usuarioName) {
        this.usuarioName = usuarioName;
    }

    public String getPassword() {
        return password;
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
        UsuarioEntity that = (UsuarioEntity) o;
        return idUsuario == that.idUsuario && Objects.equals(usuarioName, that.usuarioName) && Objects.equals(password, that.password) && Objects.equals(rol, that.rol) && Objects.equals(nombre, that.nombre) && Objects.equals(apellido1, that.apellido1) && Objects.equals(apellido2, that.apellido2) && Objects.equals(fechaNacimiento, that.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, usuarioName, password, rol, nombre, apellido1, apellido2, fechaNacimiento);
    }
}
