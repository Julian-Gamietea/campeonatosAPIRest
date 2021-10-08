package org.grupo4.campeonatosapirest.restcontroller;

import org.grupocuatro.controlador.ControladorResponsables;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.excepciones.ResponsableException;
import org.grupocuatro.vo.ResponsableVO;
import org.springframework.web.bind.annotation.*;
import javax.management.relation.RelationServiceNotRegisteredException;
import java.util.List;

@RestController
public class ControladorRestResponsables {

    @PostMapping("/crearResponsable")
    public Integer crearResponsable(@RequestParam(name = "documento") int documento,
                                    @RequestParam(name = "nombre") String nombre,
                                    @RequestParam(name = "idClub") Integer idClub) throws ClubException, ResponsableException {
        return ControladorResponsables.getInstancia().crearResponsable(documento, nombre, idClub);
    }

    @PostMapping("/modificarResponsable")
    public void modificarResponsable(@RequestParam(name = "legajo") Integer legajo,
                                     @RequestParam(name = "documento") Integer documento,
                                     @RequestParam(name = "nombre") String nombre,
                                     @RequestParam(name = "idClub") Integer idClub) throws ClubException, ResponsableException {
        ControladorResponsables.getInstancia().modificarResponsable(legajo, documento, nombre, idClub);
    }

    @RequestMapping("/getResponsableById")
    public ResponsableVO getResponsableById(@RequestParam(name = "idResponsable") Integer idResponsable) throws ResponsableException {
        return ControladorResponsables.getInstancia().getResponsable(idResponsable);

    }

    @RequestMapping("/getResponsables")
    public List<ResponsableVO> getResponsables() throws ResponsableException {
        return ControladorResponsables.getInstancia().getResponsables();

    }

    @RequestMapping("/getResponsableByNroDocAndClub")
    public ResponsableVO getResponsableByNroDocAndClub(@RequestParam(name = "nroDoc") Integer nroDoc,
                                                       @RequestParam(name = "idClub") Integer idClub) throws ResponsableException {
        return ControladorResponsables.getInstancia().getResponsableByNroDocAndClub(nroDoc, idClub);

    }

    @RequestMapping("/getResponsablesByClub")
    public List<ResponsableVO> getResponsablesByClub(@RequestParam(name = "idClub") Integer idClub) throws ResponsableException {
        return ControladorResponsables.getInstancia().getResponsablesByClub(idClub);

    }


}
