package com.kevinsignes.academia.security;

import com.kevinsignes.academia.basededatos.UsuarioEntity;
import com.kevinsignes.academia.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    IUserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity user = repo.findByEmail(username);

        User.UserBuilder builder = null;

        if (user != null) {
            builder = User.withUsername(username);
            builder.disabled(false);
            builder.password(user.getPassword());
            builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            throw new UsernameNotFoundException(UserDetailsServiceImpl.class.getSimpleName());
        }

        return builder.build();
    }
}
