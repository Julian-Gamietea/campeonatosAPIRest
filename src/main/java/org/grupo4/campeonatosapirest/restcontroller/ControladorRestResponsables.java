package org.grupo4.campeonatosapirest.restcontroller;

import org.grupocuatro.controlador.ControladorResponsables;
import org.grupocuatro.excepciones.ResponsableException;
import org.grupocuatro.modelo.Responsable;
import org.grupocuatro.vo.ResponsableVO;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RelationServiceNotRegisteredException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class ControladorRestResponsables {

    @PostMapping("/crearResponsable")
    public Integer crearResponsable(@RequestBody ResponsableVO responsable) {
        return ControladorResponsables.getInstancia().crearResponsable(responsable.getDocumento(), responsable.getNombre(), responsable.getClub().getIdClub());
    }

    @PostMapping("/modificarResponsable")
    public void modificarResponsable(@RequestParam(name = "legajo") Integer legajo,
                                     @RequestParam(name = "documento") Integer documento,
                                     @RequestParam(name = "nombre") String nombre,
                                     @RequestParam(name = "idClub") Integer idClub) {
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
