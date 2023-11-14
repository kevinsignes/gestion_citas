package com.kevinsignes.academia.basededatos;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "empleado", schema = "gestion_citas", catalog = "")
public class EmpleadoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_empleado")
    private int idEmpleado;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "telefono")
    private String telefono;
    @Basic
    @Column(name = "servicio_id_servicio")
    private int servicioIdServicio;

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getServicioIdServicio() {
        return servicioIdServicio;
    }

    public void setServicioIdServicio(int servicioIdServicio) {
        this.servicioIdServicio = servicioIdServicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpleadoEntity that = (EmpleadoEntity) o;
        return idEmpleado == that.idEmpleado && servicioIdServicio == that.servicioIdServicio && Objects.equals(nombre, that.nombre) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(telefono, that.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmpleado, nombre, email, password, telefono, servicioIdServicio);
    }
}