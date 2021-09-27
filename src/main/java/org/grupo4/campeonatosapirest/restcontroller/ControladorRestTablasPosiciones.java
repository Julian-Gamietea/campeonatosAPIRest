package org.grupo4.campeonatosapirest.restcontroller;

import org.grupocuatro.controlador.ControladorTablasPosiciones;
import org.grupocuatro.excepciones.TablaPosicionException;
import org.grupocuatro.vo.TablaPosicionesVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControladorRestTablasPosiciones {


    @RequestMapping("/getTablasPosicionesByClub")
    public List<TablaPosicionesVO> getTablasPosicionesByClub(@RequestParam(name = "idClub") Integer idClub) throws TablaPosicionException {
        return ControladorTablasPosiciones.getInstancia().getTablasPosicionesByClub(idClub);

    }

    @RequestMapping("/getTablaPosicionesByClubAndCampeonato")
    public TablaPosicionesVO getTablaPosicionesByClubAndCampeonato(@RequestParam(name = "idClub") Integer idClub,
                                                                   @RequestParam(name = "idCampeonato") Integer idCampeonato) throws TablaPosicionException {
        return ControladorTablasPosiciones.getInstancia().getTablaPosicionesByClubAndCampeonato(idClub, idCampeonato);

    }

    @RequestMapping("/getTablaPosicionesByCampeonato")
    public List<TablaPosicionesVO> getTablaPosicionesByCampeonato(@RequestParam(name = "idCampeonato") Integer idCampeonato) throws TablaPosicionException {
        return ControladorTablasPosiciones.getInstancia().getTablasPosicionesByCampeonato(idCampeonato);

    }

    @RequestMapping("/getTablaPosicionesByPuntos")
    public List<TablaPosicionesVO> getTablaPosicionesByPuntos(@RequestParam(name = "puntos") int puntos) throws TablaPosicionException {
        return ControladorTablasPosiciones.getInstancia().getTablaPosicionesByPuntos(puntos);

    }


}
