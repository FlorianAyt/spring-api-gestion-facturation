package com.florian.gestfact.service;

import com.florian.gestfact.model.Facture;
import com.florian.gestfact.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FactureService {
    @Autowired
    private FactureRepository factureRepository;

    public Facture saveFacture(Facture facture){
        return factureRepository.save(facture);
    }

    public Optional <Facture> getFacture(final Long id){
        return factureRepository.findById(id);
    }

    public  Iterable <Facture> getFactures(){
        return factureRepository.findAll();
    }

    public void deleteAllFactures(){
        factureRepository.deleteAll();
    }

    public void deleteFacture(final Long id){
        factureRepository.deleteById(id);
    }

    public boolean factureExists(final Long id){
        return factureRepository.existsById(id);
    }
}
