package com.florian.gestfact.security.repository;

import com.florian.gestfact.security.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Long> {
}
