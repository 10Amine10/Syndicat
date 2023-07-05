package org.example.services;

import org.example.entities.Role;
import org.example.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleService {
    private RoleRepository roleRepository;
    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public Role findiRoleByName(String name) {
        return roleRepository.findByName(name);
    }

    public void saveRole(Role adminRole) {
    }
}
