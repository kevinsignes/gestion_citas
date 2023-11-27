package com.kevinsignes.gestion_citas.service;

import com.kevinsignes.gestion_citas.basededatos.ClienteEntity;
import com.kevinsignes.gestion_citas.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ClienteDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IClienteRepository clienteRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ClienteEntity cliente = clienteRepo.findByCliente(username);
        if (cliente == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new ClienteDetailsImpl(cliente);
    }

}
