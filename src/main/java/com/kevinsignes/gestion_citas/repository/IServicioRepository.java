package com.kevinsignes.gestion_citas.repository;


import com.kevinsignes.gestion_citas.basededatos.CitaEntity;
import com.kevinsignes.gestion_citas.basededatos.ServicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IServicioRepository extends JpaRepository<ServicioEntity, Integer> {

    @Query("SELECT s.nombre FROM ServicioEntity s WHERE s.id = :id")
    String findNombrePorId(@Param("id") int id);
    @Query("SELECT s.nombre FROM ServicioEntity s WHERE s.id = :servicioId")
    String findNombreById(@Param("servicioId") int servicioId);

    @Query("SELECT s.imagen FROM ServicioEntity s WHERE s.id = :servicioId")
    String findImagenById(@Param("servicioId") int servicioId);

    @Query("SELECT s.categoria FROM ServicioEntity s WHERE s.id = :servicioId")
    String findCategoriaById(@Param("servicioId") int servicioId);

    @Query("SELECT s.descripcion FROM ServicioEntity s WHERE s.id = :servicioId")
    String findDescripcionById(@Param("servicioId") int servicioId);

    @Query("SELECT s.precio FROM ServicioEntity s WHERE s.id = :servicioId")
    double findPrecioById(@Param("servicioId") int servicioId);


    @Query("SELECT p FROM ServicioEntity p WHERE p.nombre LIKE %:q%")
    List<ServicioEntity> buscarPorNombre(@Param("q") String nombre);


    @Query("SELECT p FROM ServicioEntity p WHERE p.categoria LIKE %:q%")
    List<ServicioEntity> buscarPorCategoria(@Param("q") String nombre);


}