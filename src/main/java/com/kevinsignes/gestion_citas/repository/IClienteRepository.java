package com.kevinsignes.gestion_citas.repository;

import com.kevinsignes.gestion_citas.basededatos.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IClienteRepository extends JpaRepository<ClienteEntity, Integer> {


    @Query("SELECT u FROM ClienteEntity u WHERE u.usuario = ?1")
    public ClienteEntity findByCliente(String usuario);


}