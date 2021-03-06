package org.grupo4.campeonatosapirest.restcontroller;

import org.grupocuatro.controlador.ControladorAdministradores;
import org.grupocuatro.excepciones.AdministradorException;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControladorRestAdministradores {

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/crearAdmin")
    public void crearAdministrador(@RequestParam(name = "nombre") String nombre,
                                   @RequestParam(name = "apellido") String apellido,
                                   @RequestParam(name = "tipoDoc") String tipoDoc,
                                   @RequestParam(name = "documento") Integer documento,
                                   @RequestParam(name = "mail") String mail,
                                   @RequestParam(name = "password") String password) throws AdministradorException {
        ControladorAdministradores.getInstancia().crearAdministrador(nombre, apellido, tipoDoc, documento, mail, password);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/loginAdministrador")
    public Integer loginAdministrador(@RequestParam(name = "mail") String mail,
                                      @RequestParam(name = "password") String password) throws AdministradorException {
        return ControladorAdministradores.getInstancia().loginAdministrador(mail, password);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/cambiarPasswordAdmin")
    public void cambiarPassword(@RequestParam(name = "idAdmin") Integer idAdmin,
                                @RequestParam(name = "password") String password) throws AdministradorException {
        ControladorAdministradores.getInstancia().cambiarPassword(idAdmin, password);
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/existeMailAdministrador")
    public boolean existeMailAdministrador(@RequestParam(name = "mail") String mail) {
        return ControladorAdministradores.getInstancia().existeMailAdministrador(mail);
    }
}
