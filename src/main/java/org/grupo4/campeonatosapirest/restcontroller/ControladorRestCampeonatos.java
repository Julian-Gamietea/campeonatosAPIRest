package org.grupo4.campeonatosapirest.restcontroller;

import org.grupocuatro.controlador.ControladorCampeonatos;
import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.vo.CampeonatoVO;
import org.grupocuatro.vo.ClubesCampeonatoVO;
import org.springframework.web.bind.annotation.*;

import javax.naming.ldap.Control;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class ControladorRestCampeonatos {

    @PostMapping("/crearCampeonato")
    public void crearCampeonato(@RequestParam(name = "descripcion") String descripcion,
                                @RequestParam(name = "fechaInicio") LocalDate fechaInicio,
                                @RequestParam(name = "fechaFin") LocalDate fechaFin,
                                @RequestParam(name = "estado") String estado) {
        ControladorCampeonatos.getInstancia().crearCampeonato(descripcion, fechaInicio, fechaFin, estado);
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
        CampeonatoVO result = ControladorCampeonatos.getInstancia().encontrarCampeonato(idCampeonato).toVO();
        if (result != null)
            return result;
        return new CampeonatoVO();
    }

    @RequestMapping("/getCampeonatos")
    public List<CampeonatoVO> getCampeonatos() {
        List<Campeonato> lista = ControladorCampeonatos.getInstancia().getCampeonatos();
        List<CampeonatoVO> result = new ArrayList<>();
        for (Campeonato camp : lista) {
            result.add(camp.toVO());
        }
        return result;
    }

    @RequestMapping("/getCampeonatosByEstado")
    public List<CampeonatoVO> getCampeonatosByEstado(@RequestParam(name = "estado") String estado) {
        List<Campeonato> lista = ControladorCampeonatos.getInstancia().getCampeonatosByEstado(estado);
        List<CampeonatoVO> result = new ArrayList<>();
        for (Campeonato camp : lista) {
            result.add(camp.toVO());
        }
        return result;
    }

    @PostMapping("/agregarClubACampeonato")
    public void agregarClubACampeonato(@RequestParam(name = "idClub") Integer idClub ,
                                       @RequestParam(name = "idCampeonato") Integer idCampeonato) {
        ControladorCampeonatos.getInstancia().agregarClubACampeonato(idClub, idCampeonato);
    }

    @RequestMapping("/getCampeonatosByClub")
    public List<CampeonatoVO> getCampeonatosByClub(@RequestParam(name = "idClub") Integer idClub) {
        List<Campeonato> lista = ControladorCampeonatos.getInstancia().getCampeonatosByClub(idClub);
        List<CampeonatoVO> result = new ArrayList<>();
        for (Campeonato camp : lista) {
            result.add(camp.toVO());
        }
        if (result.isEmpty()) return Collections.emptyList();
        else return result;
    }
}
