package com.florian.gestfact.controller;

import com.florian.gestfact.model.Patient;
import com.florian.gestfact.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/patients/")
public class PatientController {
     @Autowired
    PatientService patientService;

    @PostMapping(value = "/")
    public String savePatient(@RequestBody Patient patient){
        patientService.savePatient(patient);
        return "Patient enregistré";
    }

    @GetMapping(value = "/{id}")
    public Patient getPatient(@PathVariable Long id){
        Optional <Patient> patients = patientService.getPatient(id);

        if(patients.isPresent()){
            return patients.get();
        }else{
            return null;
        }
    }

    @GetMapping(value = "/")
    public Iterable <Patient>getPatients(){
        return patientService.getPatients();
    }

    @DeleteMapping(value = "/{id}")
    public String deletePatient(@PathVariable Long id){
        patientService.deletePatientById(id);
        return "Patient supprimé";
    }

    @PutMapping("/patient/{id}")
    public Patient updatePatient(@PathVariable Long id,Patient pat){
        return patientService.getPatient(id).map(patient -> {
            patient.setContactPatient(pat.getContactPatient());
            patient.setEtatPatient(pat.getEtatPatient());
            patient.setAdressePatient(pat.getAdressePatient());
            patient.setNomPatient(pat.getNomPatient());
            patient.setPrenomPatient(pat.getPrenomPatient());
            patient.setDateNaissPatient(pat.getDateNaissPatient());
            patient.setGroupeSanguin(pat.getGroupeSanguin());
            patient.setNumCartePatient(pat.getNumCartePatient());
            patient.setSexePatient(pat.getSexePatient());
            patient.setFactures(pat.getFactures());
            patient.setActes(pat.getActes());
            return patientService.savePatient(patient);
        }).orElseGet(()->{
            pat.setId(id);
            return patientService.savePatient(pat);
        });
    }
}
