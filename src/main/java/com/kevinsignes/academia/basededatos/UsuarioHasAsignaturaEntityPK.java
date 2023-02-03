package com.kevinsignes.academia.basededatos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class UsuarioHasAsignaturaEntityPK implements Serializable {
    @Column(name = "Usuario_idUsuario", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuarioIdUsuario;
    @Column(name = "Asignatura_idAsignatura", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int asignaturaIdAsignatura;

    public int getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(int usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public int getAsignaturaIdAsignatura() {
        return asignaturaIdAsignatura;
    }

    public void setAsignaturaIdAsignatura(int asignaturaIdAsignatura) {
        this.asignaturaIdAsignatura = asignaturaIdAsignatura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioHasAsignaturaEntityPK that = (UsuarioHasAsignaturaEntityPK) o;
        return usuarioIdUsuario == that.usuarioIdUsuario && asignaturaIdAsignatura == that.asignaturaIdAsignatura;
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioIdUsuario, asignaturaIdAsignatura);
    }
}
