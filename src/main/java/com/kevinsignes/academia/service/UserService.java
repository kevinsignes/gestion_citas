package com.kevinsignes.academia.service;

import com.kevinsignes.academia.basededatos.UsuarioEntity;
import com.kevinsignes.academia.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    IUserRepository repo;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public UsuarioEntity register(UsuarioEntity u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        return repo.save(u);
    }

}