package com.kevinsignes.academia.repository;

import com.kevinsignes.academia.basededatos.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IClienteRepository extends JpaRepository<ClienteEntity, Integer> {
    @Query("SELECT u FROM ClienteEntity u WHERE u.usuario = ?1")
    public ClienteEntity findByCliente(String usuario);
}