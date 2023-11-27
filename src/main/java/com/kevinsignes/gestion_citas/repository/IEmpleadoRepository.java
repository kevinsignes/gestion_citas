package com.kevinsignes.gestion_citas.repository;

import com.kevinsignes.gestion_citas.basededatos.AgendaEntity;
import com.kevinsignes.gestion_citas.basededatos.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEmpleadoRepository extends JpaRepository<EmpleadoEntity, Integer> {

    @Query("SELECT a FROM EmpleadoEntity a WHERE a.nombre = ?1")
    public AgendaEntity findByEmpleadoEntity(String nombre);

}