package com.kevinsignes.academia.repository;

import com.kevinsignes.academia.basededatos.ClienteEntity;
import com.kevinsignes.academia.basededatos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IClienteRepository extends JpaRepository<ClienteEntity, Integer> {

    @Query("SELECT a FROM ClienteEntity a WHERE a.usuario = ?1")
    public ClienteEntity findByClienteEntityName(String usuario);
}