package com.kevinsignes.gestion_citas.repository;

import com.kevinsignes.gestion_citas.basededatos.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByUsuario(String usuario);;
   /* @Query("SELECT u FROM UserEntity u WHERE u.usuario = ?1")
    public UserEntity findByUsuario(String usuario);

*/
}