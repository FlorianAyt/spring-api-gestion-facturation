package com.florian.gestfact.repository;

import com.florian.gestfact.model.Facture;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends CrudRepository<Facture,Long> {
}
