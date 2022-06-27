
package com.app.portfolio.security.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.portfolio.security.entity.Rol;
import com.app.portfolio.security.enums.RolNombre;

public interface RolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
