package com.florian.gestfact.service;

import com.florian.gestfact.model.Acte;
import com.florian.gestfact.repository.ActeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActeService {
    @Autowired
    private ActeRepository acteRepository;

    /**
     * @param acte
     * @return
     */
    public Acte saveActe(Acte acte){
        return acteRepository.save(acte);
    }

    public Optional <Acte> getActe(final Long id){
        return acteRepository.findById(id);
    }

    public Iterable <Acte> getActes(){
        return acteRepository.findAll();
    }

    public boolean acteExists(final Long id){
        return acteRepository.existsById(id);
    }

    public void deleteActe(final Long id){
        acteRepository.deleteById(id);
    }

    public void deleteActes(){
        acteRepository.deleteAll();
    }
}
