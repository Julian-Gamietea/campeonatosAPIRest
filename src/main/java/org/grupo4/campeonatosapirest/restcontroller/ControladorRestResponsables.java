package org.grupo4.campeonatosapirest.restcontroller;

import org.grupocuatro.controlador.ControladorResponsables;
import org.grupocuatro.modelo.Responsable;
import org.grupocuatro.vo.ResponsableVO;
import org.springframework.web.bind.annotation.*;

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
    public ResponsableVO getResponsableById(@RequestParam(name = "idResponsable") Integer idResponsable) {
        return ControladorResponsables.getInstancia().getResponsable(idResponsable).toVO();
    }

    @RequestMapping("/getResponsables")
    public List<ResponsableVO> getResponsables() {
        List<Responsable> responsables = ControladorResponsables.getInstancia().getResponsables();
        List<ResponsableVO> responsablesVO = Collections.emptyList();
        for (Responsable responsable : responsables)
            responsablesVO.add(responsable.toVO());
        return responsablesVO;
    }

    @RequestMapping("/getResponsableByNroDocAndClub")
    public ResponsableVO getResponsableByNroDocAndClub(@RequestParam(name = "nroDoc") Integer nroDoc,
                                                       @RequestParam(name = "idClub") Integer idClub) {
        return ControladorResponsables.getInstancia().getResponsableByNroDocAndClub(nroDoc, idClub).toVO();
    }

    @RequestMapping("/getResponsablesByClub")
    public List<ResponsableVO> getResponsablesByClub(@RequestParam(name = "idClub") Integer idClub) {
        List<Responsable> responsables = ControladorResponsables.getInstancia().getResponsablesByClub(idClub);
        List<ResponsableVO> responsablesVO = Collections.emptyList();
        for (Responsable responsable : responsables)
            responsablesVO.add(responsable.toVO());
        return responsablesVO;
    }


}
