package com.kevinsignes.academia.basededatos;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "curso", schema = "academia", catalog = "")
public class CursoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCurso", nullable = false)
    private int idCurso;
    @Basic
    @Column(name = "Nombre", nullable = true, length = 45)
    private String nombre;
    @Basic
    @Column(name = "Codigo", nullable = true, length = 45)
    private String codigo;

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursoEntity that = (CursoEntity) o;
        return idCurso == that.idCurso && Objects.equals(nombre, that.nombre) && Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCurso, nombre, codigo);
    }
}
