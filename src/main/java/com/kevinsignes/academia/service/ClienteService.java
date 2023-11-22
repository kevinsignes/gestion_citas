package com.kevinsignes.academia.service;

import com.kevinsignes.academia.basededatos.ClienteEntity;
import com.kevinsignes.academia.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements UserDetailsService {

    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ClienteEntity user = clienteRepository.findByCliente(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return null;
    }
}
