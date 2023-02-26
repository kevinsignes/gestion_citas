package com.kevinsignes.academia.repository;

import com.kevinsignes.academia.basededatos.AulaEntity;
import com.kevinsignes.academia.basededatos.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IAulaRepository extends JpaRepository<AulaEntity, Integer> {

    @Query("SELECT a FROM AulaEntity a WHERE a.idAula = ?1")
    public AulaEntity findByAulaEntity(String idAula);
}
