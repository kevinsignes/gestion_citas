package com.kevinsignes.gestion_citas.repository;

import com.kevinsignes.gestion_citas.basededatos.CitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICitaRepository extends JpaRepository<CitaEntity, Integer> {

    @Query("SELECT c FROM CitaEntity c WHERE c.userIdUser = :userId")
    List<CitaEntity> findAllByUserId(@Param("userId") int userId);

    @Query("SELECT c FROM CitaEntity c WHERE c.idCita = :idCita")
    CitaEntity findByCitaId(@Param("idCita") int idCita);

    /*
    @Query("SELECT a FROM CitaEntity a WHERE a.idCita = ?1")
    public CitaEntity findByCitaEntityID(String idCita);
*/

}