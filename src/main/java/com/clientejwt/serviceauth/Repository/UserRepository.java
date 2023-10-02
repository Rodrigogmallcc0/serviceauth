package com.clientejwt.serviceauth.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.clientejwt.serviceauth.model.Usuario;

public interface UserRepository extends CrudRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);
}
