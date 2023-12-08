package com.kevinsignes.gestion_citas.service;

import com.kevinsignes.gestion_citas.basededatos.UserEntity;
import com.kevinsignes.gestion_citas.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        UserEntity user = iUserRepository.findByUsuario(usuario);
        return new UserDetailsImpl(user);
    }

}
