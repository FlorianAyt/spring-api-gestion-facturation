package com.florian.gestfact.service;

import com.florian.gestfact.model.Patient;
import com.florian.gestfact.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Optional<Patient> getPatient(final Long id){
        return patientRepository.findById(id);
    }

    public Iterable<Patient> getPatients(){
        return patientRepository.findAll();
    }

    public void deletePatientById(final Long id){
        patientRepository.deleteById(id);
    }

    public void delteAllPatients(){
        patientRepository.deleteAll();
    }

    public Patient savePatient(Patient patient){
        return patientRepository.save(patient);
    }

    public Long getPatientNumber(){
        return patientRepository.count();
    }

    public boolean patientExists(final Long id){
        return patientRepository.existsById(id);
    }
}
