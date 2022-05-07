
package com.app.portfolio.controller.model;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter //Esto se puede agregar gracias a la dependecia Lombock de springboot
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String nombre;
    private  String apellido;
    private  String domicilio;
    private  Date fechaNac;
    private  String telefono; 
    private  String personacol; 
    private  String correo;
    private  String sobre_mi_bold;
    private  String url_foto; 
    
    public Persona(){
    }
    
     public Persona(Integer id, 
                    String nombre, 
                    String apellido,
                    String domicilio,
                    Date fechaNac,
                    String telefono,
                    String personacol,
                    String correo,
                    String sobre_mi_bold,
                    String url_foto){
         this.id = id;
         this.nombre = nombre;
         this.apellido = apellido;
         this.domicilio = domicilio;
         this.fechaNac = fechaNac;
         this.telefono = telefono;
         this.personacol = personacol;
         this.correo = correo;
         this.sobre_mi_bold = sobre_mi_bold;
         this.url_foto = url_foto;
    }
    
}
