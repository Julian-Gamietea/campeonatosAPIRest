package org.grupo4.campeonatosapirest.restcontroller;

import org.grupocuatro.controlador.ControladorTablasPosiciones;
import org.grupocuatro.excepciones.TablaPosicionException;
import org.grupocuatro.vo.TablaPosicionesVO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControladorRestTablasPosiciones {

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getTablasPosicionesByClub")
    public List<TablaPosicionesVO> getTablasPosicionesByClub(@RequestParam(name = "idClub") Integer idClub) throws TablaPosicionException {
        return ControladorTablasPosiciones.getInstancia().getTablasPosicionesByClub(idClub);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getTablaPosicionesByClubAndCampeonato")
    public TablaPosicionesVO getTablaPosicionesByClubAndCampeonato(@RequestParam(name = "idClub") Integer idClub,
                                                                   @RequestParam(name = "idCampeonato") Integer idCampeonato) throws TablaPosicionException {
        return ControladorTablasPosiciones.getInstancia().getTablaPosicionesByClubAndCampeonato(idClub, idCampeonato);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getTablaPosicionesByCampeonato")
    public List<TablaPosicionesVO> getTablaPosicionesByCampeonato(@RequestParam(name = "idCampeonato") Integer idCampeonato) throws TablaPosicionException {
        return ControladorTablasPosiciones.getInstancia().getTablasPosicionesByCampeonato(idCampeonato);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getTablaPosicionesByPuntos")
    public List<TablaPosicionesVO> getTablaPosicionesByPuntos(@RequestParam(name = "puntos") int puntos) throws TablaPosicionException {
        return ControladorTablasPosiciones.getInstancia().getTablaPosicionesByPuntos(puntos);
    }


}
