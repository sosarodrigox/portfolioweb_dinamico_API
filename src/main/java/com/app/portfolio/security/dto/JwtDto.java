
package com.app.portfolio.security.dto;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter //Esto se puede agregar gracias a la dependecia Lombock de springboot
public class JwtDto {
    
    private String token;
    private String bearer = "Bearer";
    private String nombreUsuario;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtDto(String token, String nombreUsuario, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.nombreUsuario = nombreUsuario;
        this.authorities = authorities;
    }
}
