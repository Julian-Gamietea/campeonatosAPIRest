package org.grupo4.campeonatosapirest.restcontroller;

import org.grupocuatro.controlador.ControladorResponsables;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.excepciones.ResponsableException;
import org.grupocuatro.vo.ResponsableVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorRestResponsables {
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/crearResponsable")
    public Integer crearResponsable(@RequestParam(name = "documento") int documento,
                                    @RequestParam(name = "nombre") String nombre,
                                    @RequestParam(name = "apellido") String apellido,
                                    @RequestParam(name = "idClub") Integer idClub,
                                    @RequestParam(name = "mail") String mail,
                                    @RequestParam(name = "password") String password) throws ClubException, ResponsableException {
        return ControladorResponsables.getInstancia().crearResponsable(documento, nombre, apellido, mail, password, idClub);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/modificarResponsable")
    public void modificarResponsable(@RequestParam(name = "legajo") Integer legajo,
                                     @RequestParam(name = "nombre") String nombre,
                                     @RequestParam(name = "idClub") Integer idClub) throws ClubException, ResponsableException {
        ControladorResponsables.getInstancia().modificarResponsable(legajo, nombre, idClub);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/loginResponsable")
    public Integer loginResponsable(@RequestParam(name = "mail") String mail,
                                    @RequestParam(name = "password") String password) throws ResponsableException {
        return ControladorResponsables.getInstancia().loginResponsable(mail, password);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/modificarPasswordResponsable")
    public void modificarPassword(@RequestParam(name = "idResponsable") Integer idResponsable,
                                  @RequestParam(name = "password") String password) throws ResponsableException {
        ControladorResponsables.getInstancia().cambiarPassword(idResponsable, password);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getResponsableById")
    public ResponsableVO getResponsableById(@RequestParam(name = "idResponsable") Integer idResponsable) throws ResponsableException {
        return ControladorResponsables.getInstancia().getResponsable(idResponsable);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getResponsables")
    public List<ResponsableVO> getResponsables() throws ResponsableException {
        return ControladorResponsables.getInstancia().getResponsables();

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getResponsableByNroDocAndClub")
    public ResponsableVO getResponsableByNroDocAndClub(@RequestParam(name = "nroDoc") Integer nroDoc,
                                                       @RequestParam(name = "idClub") Integer idClub) throws ResponsableException {
        return ControladorResponsables.getInstancia().getResponsableByNroDocAndClub(nroDoc, idClub);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getResponsablesByClub")
    public List<ResponsableVO> getResponsablesByClub(@RequestParam(name = "idClub") Integer idClub) throws ResponsableException {
        return ControladorResponsables.getInstancia().getResponsablesByClub(idClub);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/existeMailResponsable")
    public boolean existeMailResponsable(@RequestParam(name = "mail") String mail) {
        return ControladorResponsables.getInstancia().existeMailResponsable(mail);
    }

}
