
package com.app.portfolio.security.controller;

import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.portfolio.security.dto.JwtDto;
import com.app.portfolio.security.dto.LoginUsuario;
import com.app.portfolio.security.dto.NuevoUsuario;
import com.app.portfolio.security.entity.Rol;
import com.app.portfolio.security.entity.Usuario;
import com.app.portfolio.security.enums.RolNombre;
import com.app.portfolio.security.jwt.JwtProvider;
import com.app.portfolio.security.service.RolService;
import com.app.portfolio.security.service.UsuarioService;

@RestController
@RequestMapping("/auth/")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    RolService rolService;
    
    @Autowired
    JwtProvider jwtProvider;
    
    private String mensaje;
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            mensaje="Campos mal puestos o email inválido";
            return new ResponseEntity(mensaje, HttpStatus.BAD_REQUEST);
        }
        if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario())){
            mensaje="El nombre de usuario ya existe tinky winky";
            return new ResponseEntity(mensaje, HttpStatus.BAD_REQUEST);
        }
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail())){
            mensaje="El correo ingresado ya existe tinky winky";
            return new ResponseEntity(mensaje, HttpStatus.BAD_REQUEST);
        }
        Usuario usuario =
                new Usuario(
                        nuevoUsuario.getNombre(),
                        nuevoUsuario.getNombreUsuario(),
                        nuevoUsuario.getEmail(),
                        passwordEncoder.encode(nuevoUsuario.getPassword())
                );
        
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        mensaje = "Usuario guardado";
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            mensaje="Los campos están mal puestos.";
            return new ResponseEntity(mensaje, HttpStatus.BAD_REQUEST);
        }
        
        Authentication authentication = 
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(),loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}