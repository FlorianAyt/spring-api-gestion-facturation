package com.florian.gestfact.model;

import lombok.Data;

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

    @Column(name = "nom")
    public String nomPatient;

    @Column(name = "prenom")
    public String prenomPatient;

    @Column(name = "sexe")
    public String sexePatient;

    @Column
    private String groupeSanguin;

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

    @OneToMany(mappedBy = "patients")
    private List<Facture> factures;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "effectuer",
    joinColumns = @JoinColumn(name = "acte_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "patient_id",
    referencedColumnName = "id"))
    private List <Acte> actes;
}
