package com.kevinsignes.academia.basededatos;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "usuario_has_asignatura", schema = "academia", catalog = "")
@IdClass(UsuarioHasAsignaturaEntityPK.class)
public class UsuarioHasAsignaturaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Usuario_idUsuario", nullable = false)
    private int usuarioIdUsuario;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Asignatura_idAsignatura", nullable = false)
    private int asignaturaIdAsignatura;
    @Basic
    @Column(name = "Nota", nullable = true, length = 45)
    private String nota;

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

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioHasAsignaturaEntity that = (UsuarioHasAsignaturaEntity) o;
        return usuarioIdUsuario == that.usuarioIdUsuario && asignaturaIdAsignatura == that.asignaturaIdAsignatura && Objects.equals(nota, that.nota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioIdUsuario, asignaturaIdAsignatura, nota);
    }
}
