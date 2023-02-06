package com.kevinsignes.academia.repository;

import com.kevinsignes.academia.basededatos.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UsuarioEntity, Long> {
    UsuarioEntity findByEmail(String email);
}
