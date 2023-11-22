package com.kevinsignes.academia.service;

import com.kevinsignes.academia.basededatos.ClienteEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class ClienteUserDetails implements UserDetails {

    private ClienteEntity cliente;

    public ClienteUserDetails(ClienteEntity cliente){
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
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public String getFullName() {
        return cliente.getNombre() + " " + cliente.getApellido();
    }
}
