package com.kevinsignes.academia.basededatos;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "aula", schema = "academia", catalog = "")
public class AulaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idAula", nullable = false)
    private int idAula;
    @Basic
    @Column(name = "Codigo", nullable = true, length = 45)
    private String codigo;
    @Basic
    @Column(name = "Numero_Pupitres", nullable = true)
    private Integer numeroPupitres;

    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getNumeroPupitres() {
        return numeroPupitres;
    }

    public void setNumeroPupitres(Integer numeroPupitres) {
        this.numeroPupitres = numeroPupitres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AulaEntity that = (AulaEntity) o;
        return idAula == that.idAula && Objects.equals(codigo, that.codigo) && Objects.equals(numeroPupitres, that.numeroPupitres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAula, codigo, numeroPupitres);
    }
}
