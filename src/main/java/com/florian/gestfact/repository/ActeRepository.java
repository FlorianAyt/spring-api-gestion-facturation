package com.florian.gestfact.repository;

import com.florian.gestfact.model.Acte;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ActeRepository extends CrudRepository<Acte,Long> {
}
