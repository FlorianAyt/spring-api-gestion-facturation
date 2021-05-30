package com.florian.gestfact.model;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nom")
    public String nomPatient;

    @NotNull
    @Column(name = "prenom")
    public String prenomPatient;

    @NotNull
    @Column(name = "sexe")
    public String sexePatient;

    @NotNull
    @Column
    private String groupeSanguin;

    @NotNull
    @Column(name= "dateNaissance" )
    private Date dateNaissPatient;

    @Column(name = "adresse")
    private String adressePatient;

    @Column(name = "contact")
    private String contactPatient;

    @Column(name = "numeroCarte")
    private  String numCartePatient;

    @Column(name = "etat")
    private String etatPatient;

    @OneToMany(mappedBy = "patient")
    private List<Facture> factures;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "effectuer",
    joinColumns = @JoinColumn(name = "acte_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "patient_id",
    referencedColumnName = "id"))
    private List <Acte> actes;
}
