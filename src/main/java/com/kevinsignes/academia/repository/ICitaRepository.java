package com.kevinsignes.academia.repository;

import com.kevinsignes.academia.basededatos.AgendaEntity;
import com.kevinsignes.academia.basededatos.CitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICitaRepository extends JpaRepository<CitaEntity, Integer> {

    @Query("SELECT a FROM CitaEntity a WHERE a.idCita = ?1")
    public CitaEntity findByCitaEntityID(String idCita);

}