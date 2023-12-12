package com.kevinsignes.gestion_citas.basededatos;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = " cita", schema = "gestion_citas", catalog = "")
public class CitaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_cita", nullable = false)
    private int idCita;
    @Basic
    @Column(name = "descripcion", nullable = true, length = 500)
    private String descripcion;
    @Basic
    @Column(name = "fecha", nullable = false, length = 45)
    private String fecha;
    @Basic
    @Column(name = "estado", nullable = true, length = 45)
    private String estado;
    @Basic
    @Column(name = "servicio_id_servicio", nullable = false)
    private int servicioIdServicio;
    @Basic
    @Column(name = "User_id_user", nullable = false)
    private int userIdUser;

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getServicioIdServicio() {
        return servicioIdServicio;
    }

    public void setServicioIdServicio(int servicioIdServicio) {
        this.servicioIdServicio = servicioIdServicio;
    }

    public int getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(int userIdUser) {
        this.userIdUser = userIdUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CitaEntity that = (CitaEntity) o;
        return idCita == that.idCita && servicioIdServicio == that.servicioIdServicio && userIdUser == that.userIdUser && Objects.equals(descripcion, that.descripcion) && Objects.equals(fecha, that.fecha) && Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCita, descripcion, fecha, estado, servicioIdServicio, userIdUser);
    }







}
