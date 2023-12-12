package com.kevinsignes.gestion_citas.repository;


import com.kevinsignes.gestion_citas.basededatos.ServicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IServicioRepository extends JpaRepository<ServicioEntity, Integer> {



    @Query("SELECT a FROM ServicioEntity a WHERE a.idServicio = ?1")
    ServicioEntity findByServicioEntity(String idServicio);
}