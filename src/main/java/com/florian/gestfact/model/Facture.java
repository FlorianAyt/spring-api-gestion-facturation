package com.florian.gestfact.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "factures")
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @CreationTimestamp
    private LocalDateTime dateCreationFacture;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "concerner",
            joinColumns = @JoinColumn(name = "acte_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "facture_id",
            referencedColumnName ="id" ))
    private List <Acte> actes;


    public Facture() {

    }
}
