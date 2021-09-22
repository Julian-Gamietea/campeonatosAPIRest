package org.grupo4.campeonatosapirest.restcontroller;

import org.grupocuatro.controlador.ControladorCampeonatos;
import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.vo.CampeonatoVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorRestCampeonatos {

    @PostMapping("/crearCampeonato")
    public void crearCampeonato(@RequestBody CampeonatoVO camp) {
        ControladorCampeonatos.getInstancia().crearCampeonato(camp.getDescripcion(), camp.getFechaInicio(), camp.getFechaFin(), camp.getEstado());
    }

    @PostMapping("/definirTipoCampeonatoAndCategoria")
    public void definirTipoCampeonatoAndCategoria(@RequestParam(name = "cantidadZonas") int cantidadZonas,
                                                  @RequestParam(name = "idCampeonatos") Integer idCampeonato,
                                                  @RequestParam(name = "categoria") int categoria) {

        ControladorCampeonatos.getInstancia().definirTipoCampeonatoAndCategoria(cantidadZonas, idCampeonato, categoria);

    }

    @PostMapping("/terminarCampeonato")
    public void terminarCampeonato(@RequestParam(name = "idCampeonato") Integer idCampeonato) {
        ControladorCampeonatos.getInstancia().terminarCampeonato(idCampeonato);
    }

    @RequestMapping("/encontrarCampeonato")
    public CampeonatoVO encontrarCampeonato(@RequestParam(name = "idCampeonato") Integer idCampeonato) {
        return ControladorCampeonatos.getInstancia().encontrarCampeonato(idCampeonato).toVO();
    }

    @RequestMapping("/getCampeonatos")
    public List<CampeonatoVO> getCampeonatos() {
        List<Campeonato> lista = ControladorCampeonatos.getInstancia().getCampeonatos();
        List<CampeonatoVO> result = null;
        for (Campeonato camp : lista) {
            result.add(camp.toVO());
        }
        return result;
    }

    @RequestMapping("/getCampeonatosByEstado")
    public List<CampeonatoVO> getCampeonatosByEstado(@RequestParam(name = "estado") String estado) {
        List<Campeonato> lista = ControladorCampeonatos.getInstancia().getCampeonatosByEstado(estado);
        List<CampeonatoVO> result = null;
        for (Campeonato camp : lista) {
            result.add(camp.toVO());
        }
        return result;
    }


}
