package com.kevinsignes.academia.repositorys;

import com.kevinsignes.academia.basededatos.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

}
