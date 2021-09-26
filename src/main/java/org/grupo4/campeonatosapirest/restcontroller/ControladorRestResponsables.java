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
        Responsable responsable = ControladorResponsables.getInstancia().getResponsable(idResponsable);
        if (responsable == null) throw new ResponsableException("No existe un responsable con id: " + idResponsable);
        else return responsable.toVO();
    }

    @RequestMapping("/getResponsables")
    public List<ResponsableVO> getResponsables() {
        List<Responsable> responsables = ControladorResponsables.getInstancia().getResponsables();
        List<ResponsableVO> responsablesVO = new ArrayList<>();

        if (responsables != null) {
            for (Responsable responsable : responsables)
                responsablesVO.add(responsable.toVO());
        }

        return responsablesVO;
    }

    @RequestMapping("/getResponsableByNroDocAndClub")
    public ResponsableVO getResponsableByNroDocAndClub(@RequestParam(name = "nroDoc") Integer nroDoc,
                                                       @RequestParam(name = "idClub") Integer idClub) throws ResponsableException {
        Responsable responsable = ControladorResponsables.getInstancia().getResponsableByNroDocAndClub(nroDoc, idClub);
        if (responsable == null)
            throw new ResponsableException("No existe un responsable con numero de documento: " + nroDoc + " para el club: " + idClub);
        else return responsable.toVO();
    }

    @RequestMapping("/getResponsablesByClub")
    public List<ResponsableVO> getResponsablesByClub(@RequestParam(name = "idClub") Integer idClub) {
        List<Responsable> responsables = ControladorResponsables.getInstancia().getResponsablesByClub(idClub);
        List<ResponsableVO> responsablesVO = new ArrayList<>();

        if (responsables != null) {
            for (Responsable responsable : responsables)
                responsablesVO.add(responsable.toVO());
        }

        return responsablesVO;
    }


}
