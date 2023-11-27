package com.kevinsignes.gestion_citas.repository;

import com.kevinsignes.gestion_citas.basededatos.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IAgendaRepository extends JpaRepository<AgendaEntity, Integer> {

@Query("SELECT a FROM AgendaEntity a WHERE a.idAgenda = ?1")
public AgendaEntity findByAgendaEntityID(String usuario);

}