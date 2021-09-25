package org.grupo4.campeonatosapirest.restcontroller;

import org.grupocuatro.controlador.ControladorTablasPosiciones;
import org.grupocuatro.modelo.TablaPosiciones;
import org.grupocuatro.vo.TablaPosicionesVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControladorRestTablasPosiciones {


    @RequestMapping("/getTablasPosicionesByClub")
    public List<TablaPosicionesVO> getTablasPosicionesByClub(@RequestParam(name = "idClub") Integer idClub) {
        List<TablaPosiciones> tablas = ControladorTablasPosiciones.getInstancia().getTablasPosicionesByClub(idClub);
        List<TablaPosicionesVO> tablasVO = new ArrayList<>();
        for (TablaPosiciones tabla : tablas)
            tablasVO.add(tabla.toVO());
        return tablasVO;
    }

    @RequestMapping("/getTablaPosicionesByClubAndCampeonato")
    public TablaPosicionesVO getTablaPosicionesByClubAndCampeonato(@RequestParam(name = "idClub") Integer idClub,
                                                                   @RequestParam(name = "idCampeonato") Integer idCampeonato) {

        TablaPosicionesVO tabla = ControladorTablasPosiciones.getInstancia().getTablaPosicionesByClubAndCampeonato(idClub, idCampeonato).toVO();
        if (tabla == null)
            return new TablaPosicionesVO();
        else {
            return tabla;
        }
    }

    @RequestMapping("/getTablaPosicionesByCampeonato")
    public List<TablaPosicionesVO> getTablaPosicionesByCampeonato(@RequestParam(name = "idCampeonato") Integer idCampeonato) {
        List<TablaPosiciones> tablas = ControladorTablasPosiciones.getInstancia().getTablasPosicionesByCampeonato(idCampeonato);
        List<TablaPosicionesVO> tablasVO = new ArrayList<>();
        for (TablaPosiciones tabla : tablas)
            tablasVO.add(tabla.toVO());
        return tablasVO;
    }

    @RequestMapping("/getTablaPosicionesByPuntos")
    public List<TablaPosicionesVO> getTablaPosicionesByPuntos(@RequestParam(name = "puntos") int puntos) {
        List<TablaPosiciones> tablas = ControladorTablasPosiciones.getInstancia().getTablaPosicionesByPuntos(puntos);
        List<TablaPosicionesVO> tablasVO = new ArrayList<>();
        for (TablaPosiciones tabla : tablas)
            tablasVO.add(tabla.toVO());
        return tablasVO;
    }


}
