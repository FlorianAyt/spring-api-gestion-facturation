package com.florian.gestfact.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "actesmedicaux")
public class Acte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "libelle")
    private String libActe;

    @Column(name = "prix")
    private float prixActe;

    @Column(name = "type")
    private float typeActe;

    @ManyToMany(mappedBy = "actes")
    private List<Patient> patients;

    @ManyToMany(mappedBy = "actes")
    private List <Facture> factures;
}
