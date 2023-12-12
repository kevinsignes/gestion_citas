package com.kevinsignes.gestion_citas.repository;

import com.kevinsignes.gestion_citas.basededatos.CitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICitaRepository extends JpaRepository<CitaEntity, Integer> {

    @Query("SELECT a FROM CitaEntity a WHERE a.idCita = ?1")
    public CitaEntity findByCitaEntityID(String idCita);


}