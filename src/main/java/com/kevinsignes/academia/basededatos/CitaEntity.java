package com.kevinsignes.academia.basededatos;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = " cita", schema = "gestion_citas", catalog = "")
public class CitaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_cita")
    private int idCita;
    @Basic
    @Column(name = "descripcion")
    private String descripcion;
    @Basic
    @Column(name = "fecha")
    private String fecha;
    @Basic
    @Column(name = "estado")
    private String estado;
    @Basic
    @Column(name = "empleado_id_empleado")
    private int empleadoIdEmpleado;
    @Basic
    @Column(name = "cliente_id_cliente")
    private int clienteIdCliente;

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

    public int getEmpleadoIdEmpleado() {
        return empleadoIdEmpleado;
    }

    public void setEmpleadoIdEmpleado(int empleadoIdEmpleado) {
        this.empleadoIdEmpleado = empleadoIdEmpleado;
    }

    public int getClienteIdCliente() {
        return clienteIdCliente;
    }

    public void setClienteIdCliente(int clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CitaEntity that = (CitaEntity) o;
        return idCita == that.idCita && empleadoIdEmpleado == that.empleadoIdEmpleado && clienteIdCliente == that.clienteIdCliente && Objects.equals(descripcion, that.descripcion) && Objects.equals(fecha, that.fecha) && Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCita, descripcion, fecha, estado, empleadoIdEmpleado, clienteIdCliente);
    }
}
