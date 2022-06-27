
package com.app.portfolio.security.entity;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.app.portfolio.security.enums.RolNombre;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter //Esto se puede agregar gracias a la dependecia Lombock de springboot
@Entity
public class Rol {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        @NotNull
        @Enumerated(EnumType.STRING)
        private RolNombre rolNombre;

    public Rol() {
    }

    public Rol(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }    
}