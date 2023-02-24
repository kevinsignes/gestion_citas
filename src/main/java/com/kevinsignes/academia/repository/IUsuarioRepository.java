package com.kevinsignes.academia.repository;

import com.kevinsignes.academia.basededatos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUsuarioRepository extends JpaRepository<Usuario , Long> {

    @Query("SELECT a FROM Usuario a WHERE a.username = ?1")
    public Usuario findByUsuarioName(String usuarioName);
}
