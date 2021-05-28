package com.florian.gestfact.security.service;

import com.florian.gestfact.security.model.Role;
import com.florian.gestfact.security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role saveRole(Role role){
        return roleRepository.save(role);
    }

    public Optional<Role> getRole(final Long id){
        return  roleRepository.findById(id);
    }

    public Iterable <Role> getRoles(){
        return roleRepository.findAll();
    }

    public void deleteRole(final Long id){
        roleRepository.deleteById(id);
    }

    public void deleteRoles(){
        roleRepository.deleteAll();
    }

    public boolean roleExists(final Long id) {
        return roleRepository.existsById(id);
    }

    public Long contRole(){
        return roleRepository.count();
    }
}
