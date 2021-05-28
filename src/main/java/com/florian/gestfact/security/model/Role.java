package com.florian.gestfact.security.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String libelle;

    @OneToMany(mappedBy = "role")
    private List <User> user;
}
