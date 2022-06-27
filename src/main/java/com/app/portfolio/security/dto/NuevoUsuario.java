
package com.app.portfolio.security.dto;

import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter //Esto se puede agregar gracias a la dependecia Lombock de springboot
public class NuevoUsuario {
    
    @NotBlank
    private String nombre;
    @NotBlank
    private String nombreUsuario;
    @NotBlank
    private String password;
    @Email
    private String email;
    //Acá manda en cadenas los datos extras encadenados en un
    //JSON para no generar tráfico innecesario (img_usuario, link_gitHub, etc)
    private Set<String> roles = new HashSet<>();
    

}
