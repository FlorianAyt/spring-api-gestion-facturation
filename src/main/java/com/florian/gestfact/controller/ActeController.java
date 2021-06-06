package com.florian.gestfact.controller;

import com.florian.gestfact.model.Acte;
import com.florian.gestfact.service.ActeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/actes/")
public class ActeController {
    @Autowired
    ActeService acteService;

    @GetMapping(value = "/")
    public Iterable <Acte> getAllActes(){
        return acteService.getAlltActes();
    }

    @GetMapping(value = "/{id}")
    public Acte getActe(@PathVariable Long id){
        Optional<Acte> acteOptional = acteService.getActe(id);

        if(acteOptional.isPresent()){
            return acteOptional.get();
        }else{
            return null;
        }
    }

    @DeleteMapping(value = "/{id}")
    public String deleteActe(@PathVariable Long id){
        acteService.deleteActe(id);
        return "Acte supprimé";
    }

    @DeleteMapping(value = "/")
    public String deleteAllActes(){
        acteService.deleteAllActes();
        return "Tous les actes ont été supprimés";
    }

    @PutMapping(value = "/{id}")
    public Acte updateActe(@PathVariable Long id,Acte act){
        return acteService.getActe(id).map(acte -> {
            acte.setLibActe(act.getLibActe());
            acte.setPrixActe(act.getPrixActe());
            acte.setLibActe(act.getLibActe());
            acte.setFactures(act.getFactures());
            acte.setPatients(act.getPatients());

            return acteService.saveActe(acte);
        }).orElseGet(()->{
            act.setId(id);
            return acteService.saveActe(act);
        });
    }

}
