package com.kevinsignes.gestion_citas.service;

import com.kevinsignes.gestion_citas.basededatos.ClienteEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class ClienteDetailsImpl implements UserDetails {

    private ClienteEntity cliente;

    public ClienteDetailsImpl(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return cliente.getPassword();
    }

    @Override
    public String getUsername() {
        return cliente.getUsuario();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}