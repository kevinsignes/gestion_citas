package com.kevinsignes.academia.repository;

import com.kevinsignes.academia.basededatos.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICursoRepository extends JpaRepository<CursoEntity, Integer> {
    @Query("SELECT a FROM CursoEntity a WHERE a.idCurso = ?1")
    public CursoEntity findByCursoEntity(String idCurso);
}
