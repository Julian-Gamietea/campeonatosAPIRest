package org.grupo4.campeonatosapirest.restcontroller;

import org.grupocuatro.controlador.ControladorAdministradores;
import org.grupocuatro.excepciones.AdministradorException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorRestAdministradores {

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/crearJugador")
    public void crearAdministrador() {

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/validarAdministrador")
    public void validarAdministrador(@RequestParam(name = "mail") String mail,
                                     @RequestParam(name = "password") String password) {
        ControladorAdministradores.getInstancia().validarAdministrador(mail, password);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/cambiarPassword")
    public void cambiarPassword(@RequestParam(name = "idAdmin") Integer idAdmin,
                                @RequestParam(name = "password") String password) throws AdministradorException {
        ControladorAdministradores.getInstancia().cambiarPassword(idAdmin, password);
    }

}
