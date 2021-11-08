package org.grupo4.campeonatosapirest.restcontroller;

import org.grupocuatro.controlador.ControladorAdministradores;
import org.grupocuatro.excepciones.AdministradorException;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControladorRestAdministradores {

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/crearJugador")
    public void crearAdministrador() {

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/validarAdministrador")
    public boolean validarAdministrador(@RequestParam(name = "mail") String mail,
                                     @RequestParam(name = "password") String password) {
        return ControladorAdministradores.getInstancia().validarAdministrador(mail, password);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/cambiarPasswordAdmin")
    public void cambiarPassword(@RequestParam(name = "idAdmin") Integer idAdmin,
                                @RequestParam(name = "password") String password) throws AdministradorException {
        ControladorAdministradores.getInstancia().cambiarPassword(idAdmin, password);
    }

}
