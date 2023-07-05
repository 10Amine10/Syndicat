package org.example.mappers;

import org.example.entities.Role;
import org.example.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class RoleInitializer implements CommandLineRunner {
    private RoleService roleService;

    @Autowired
    public RoleInitializer(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) {
        Role adminRole = roleService.findiRoleByName("administrateur");
        if (adminRole == null) {
            adminRole = new Role();
            adminRole.setName("administrateur");
            roleService.saveRole(adminRole);
        }
        Role userRole = roleService.findiRoleByName("utilisteur");
        if (userRole == null) {
            userRole = new Role();
            userRole.setName("utilisateur");
            roleService.saveRole(userRole);
        }
    }
}
