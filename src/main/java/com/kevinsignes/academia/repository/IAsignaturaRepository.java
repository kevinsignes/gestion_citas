package com.kevinsignes.academia.repository;

import com.kevinsignes.academia.basededatos.AsignaturaEntity;
import com.kevinsignes.academia.basededatos.AulaEntity;
import com.kevinsignes.academia.controller.AsignaturaController;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IAsignaturaRepository extends JpaRepository<AsignaturaEntity, Integer> {

    @Query("SELECT a FROM AsignaturaEntity a WHERE a.idAsignatura = ?1")
    public AsignaturaEntity findByAsignaturaEntity(String idAsignatura);
}
