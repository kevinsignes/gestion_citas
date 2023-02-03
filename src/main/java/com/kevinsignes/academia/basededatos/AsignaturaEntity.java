package com.kevinsignes.academia.basededatos;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "asignatura", schema = "academia", catalog = "")
public class AsignaturaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idAsignatura", nullable = false)
    private int idAsignatura;
    @Basic
    @Column(name = "Nombre_Asignatura", nullable = true, length = 45)
    private String nombreAsignatura;
    @Basic
    @Column(name = "Professor_idProfessor", nullable = false)
    private int professorIdProfessor;
    @Basic
    @Column(name = "Aula_idAula", nullable = false)
    private int aulaIdAula;
    @Basic
    @Column(name = "Curso_idCurso", nullable = false)
    private int cursoIdCurso;

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public int getProfessorIdProfessor() {
        return professorIdProfessor;
    }

    public void setProfessorIdProfessor(int professorIdProfessor) {
        this.professorIdProfessor = professorIdProfessor;
    }

    public int getAulaIdAula() {
        return aulaIdAula;
    }

    public void setAulaIdAula(int aulaIdAula) {
        this.aulaIdAula = aulaIdAula;
    }

    public int getCursoIdCurso() {
        return cursoIdCurso;
    }

    public void setCursoIdCurso(int cursoIdCurso) {
        this.cursoIdCurso = cursoIdCurso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsignaturaEntity that = (AsignaturaEntity) o;
        return idAsignatura == that.idAsignatura && professorIdProfessor == that.professorIdProfessor && aulaIdAula == that.aulaIdAula && cursoIdCurso == that.cursoIdCurso && Objects.equals(nombreAsignatura, that.nombreAsignatura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAsignatura, nombreAsignatura, professorIdProfessor, aulaIdAula, cursoIdCurso);
    }
}
