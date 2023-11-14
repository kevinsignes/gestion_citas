package com.kevinsignes.academia.service;

import com.kevinsignes.academia.basededatos.ClienteEntity;
import com.kevinsignes.academia.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IClienteRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ClienteEntity user = userRepo.findByClienteEntityName(username);
        if (user == null) {
            throw new UsernameNotFoundException("CLiente no encontrado");
        }
        return new UserDetailsImpl(user);
    }

}
