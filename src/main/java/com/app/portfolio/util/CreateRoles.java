//Utilizo esta clase solo para generar los roles
//ROLE_ADMIN Y ROLE_USER
//Queda comentada porque si se vuelve a ejecutar genera nuevos usuarios admin y user.

/*
package com.app.portfolio.util;

import com.app.portfolio.security.entity.Rol;
import com.app.portfolio.security.enums.RolNombre;
import com.app.portfolio.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateRoles implements CommandLineRunner{
        
    @Autowired
    RolService rolService;
    
    @Override
    public void run(String... args) throws Exception {
        Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        Rol rolUser = new Rol(RolNombre.ROLE_USER);
        rolService.save(rolAdmin);
        rolService.save(rolUser);
    }
}
*/