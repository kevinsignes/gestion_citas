package com.kevinsignes.gestion_citas.repository;


import com.kevinsignes.gestion_citas.basededatos.ServicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IServicioRepository extends JpaRepository<ServicioEntity, Integer> {

    @Query("SELECT a FROM ServicioEntity a WHERE a.idServicio = ?1")
    public ServicioEntity findByServicioEntity(String idServicio);

}