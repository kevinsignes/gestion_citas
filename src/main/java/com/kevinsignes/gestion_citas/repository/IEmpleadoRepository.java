package com.kevinsignes.gestion_citas.repository;

import com.kevinsignes.gestion_citas.basededatos.EmpleadoEntity;
import com.kevinsignes.gestion_citas.basededatos.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEmpleadoRepository extends JpaRepository<EmpleadoEntity, Integer> {

    @Query("SELECT a FROM EmpleadoEntity a WHERE a.idEmpleado = ?1")
    public EmpleadoEntity findByEmpleadoEntity(String nombre);


}