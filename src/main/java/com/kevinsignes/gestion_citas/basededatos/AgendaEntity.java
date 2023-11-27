package com.kevinsignes.gestion_citas.basededatos;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "agenda", schema = "gestion_citas", catalog = "")
public class AgendaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_agenda", nullable = false)
    private int idAgenda;
    @Basic
    @Column(name = "fecha", nullable = false, length = 45)
    private String fecha;
    @Basic
    @Column(name = "disponible", nullable = true, length = 45)
    private String disponible;
    @Basic
    @Column(name = "empleado_id_empleado", nullable = false)
    private int empleadoIdEmpleado;

    public int getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public int getEmpleadoIdEmpleado() {
        return empleadoIdEmpleado;
    }

    public void setEmpleadoIdEmpleado(int empleadoIdEmpleado) {
        this.empleadoIdEmpleado = empleadoIdEmpleado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgendaEntity that = (AgendaEntity) o;
        return idAgenda == that.idAgenda && empleadoIdEmpleado == that.empleadoIdEmpleado && Objects.equals(fecha, that.fecha) && Objects.equals(disponible, that.disponible);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAgenda, fecha, disponible, empleadoIdEmpleado);
    }
}
