package com.florian.gestfact.controller;

import com.florian.gestfact.model.Facture;
import com.florian.gestfact.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/factures")
public class FactureController {
    @Autowired
    FactureService factureService;

    @GetMapping(value = "/")
    public Iterable <Facture> getFactures(){
        return factureService.getFactures();
    }

    @GetMapping(value = "/{id}")
    public Facture getFacture(@PathVariable Long id){
        Optional<Facture> factures = factureService.getFacture(id);
        if(factures.isPresent()){
            return factures.get();
        }else {
            return null ;
        }
    }

    @PostMapping(value = "/")
    public String saveFacture(@RequestBody Facture facture){
        factureService.saveFacture(facture);
        return "Facture créé";
    }

    @DeleteMapping(value = "/{id}")
    public  String deleteFacture(@PathVariable Long id){
        factureService.deleteFacture(id);
        return "Facture supprimée";
    }

    @DeleteMapping(value = "/")
    public String deleteAllFactures(){
        factureService.deleteAllFactures();
        return "Toutes les factures ont été supprimées";
    }

    @PutMapping(value = "/{id}")
    public Facture updateFacture(@PathVariable Long id , Facture fact){
        return factureService.getFacture(id).map(facture ->{
            facture.setDateCreationFacture(fact.getDateCreationFacture());
            facture.setPatient(fact.getPatient());
            facture.setActes(fact.getActes());
            return factureService.saveFacture(facture);
        }).orElseGet(()->{
            fact.setId(id);
            return factureService.saveFacture(fact);
        });
    }
}
