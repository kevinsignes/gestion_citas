package com.kevinsignes.gestion_citas.basededatos;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "servicio", schema = "gestion_citas", catalog = "")
public class ServicioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_servicio", nullable = false)
    private int idServicio;
    @Basic
    @Column(name = "nombre", nullable = true, length = 45)
    private String nombre;
    @Basic
    @Column(name = "categoria", nullable = true, length = 45)
    private String categoria;
    @Basic
    @Column(name = "descripcion", nullable = true, length = 500)
    private String descripcion;
    @Basic
    @Column(name = "precio", nullable = true, length = 45)
    private String precio;

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicioEntity that = (ServicioEntity) o;
        return idServicio == that.idServicio && Objects.equals(nombre, that.nombre) && Objects.equals(categoria, that.categoria) && Objects.equals(descripcion, that.descripcion) && Objects.equals(precio, that.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idServicio, nombre, categoria, descripcion, precio);
    }
}
