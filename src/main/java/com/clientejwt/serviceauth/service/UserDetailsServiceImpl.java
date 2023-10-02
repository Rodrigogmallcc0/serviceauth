package com.clientejwt.serviceauth.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.clientejwt.serviceauth.Repository.UserRepository;
import com.clientejwt.serviceauth.model.Usuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + "no existe."));

        Hibernate.initialize(userEntity.getUsuarioRoles());
        Collection<? extends GrantedAuthority> authorities = userEntity.getUsuarioRoles()
                .stream()
                .map(usuarioRol -> usuarioRol.getRol())
                .map(rol -> new SimpleGrantedAuthority("ROLE_" + rol.getNombreDelRol()))
                .collect(Collectors.toList()); // toSet
        return new User(userEntity.getUsername(), userEntity.getPassword(),
                true,
                true,
                true,
                true,
                authorities);
    }

}
