package com.clientejwt.serviceauth.model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long usuarioId;
    private String username;
    private String password;
    private String correoElectronico;
    private boolean estado;
    // Otros atributos y getters/setters

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private List<UsuarioRol> usuarioRoles;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date createAt;
}