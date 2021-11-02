package org.grupo4.campeonatosapirest.restcontroller;

import org.grupocuatro.controlador.ControladorCampeonatos;
import org.grupocuatro.excepciones.CampeonatoException;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.excepciones.ClubesCampeonatoException;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.vo.CampeonatoVO;
import org.grupocuatro.vo.ClubesCampeonatoVO;
import org.springframework.web.bind.annotation.*;

import javax.naming.ldap.Control;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@RestController
public class ControladorRestCampeonatos {
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/crearCampeonato")
    public Integer crearCampeonato(@RequestParam(name = "descripcion") String descripcion,
                                   @RequestParam(name = "fechaInicio") String fechaInicioString,
                                   @RequestParam(name = "fechaFin") String fechaFinString,
                                   @RequestParam(name = "estado") String estado) throws CampeonatoException {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/d");
        LocalDate fechaInicio = LocalDate.parse(fechaInicioString, formato);
        LocalDate fechaFin = LocalDate.parse(fechaFinString, formato);
        Integer id = ControladorCampeonatos.getInstancia().crearCampeonato(descripcion, fechaInicio, fechaFin, estado);
        return id;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/definirTipoCampeonatoAndCategoria")
    public void definirTipoCampeonatoAndCategoria(@RequestParam(name = "cantidadZonas") int cantidadZonas,
                                                  @RequestParam(name = "idCampeonato") Integer idCampeonato,
                                                  @RequestParam(name = "categoria") int categoria) throws CampeonatoException, ClubesCampeonatoException, PartidoException, ClubException {

        ControladorCampeonatos.getInstancia().definirTipoCampeonatoAndCategoria(cantidadZonas, idCampeonato, categoria);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/terminarCampeonato")
    public void terminarCampeonato(@RequestParam(name = "idCampeonato") Integer idCampeonato) throws CampeonatoException {
        ControladorCampeonatos.getInstancia().terminarCampeonato(idCampeonato);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/encontrarCampeonato")
    public CampeonatoVO encontrarCampeonato(@RequestParam(name = "idCampeonato") Integer idCampeonato) throws CampeonatoException {
        return ControladorCampeonatos.getInstancia().encontrarCampeonato(idCampeonato);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getCampeonatos")
    public List<CampeonatoVO> getCampeonatos() throws CampeonatoException {
        return ControladorCampeonatos.getInstancia().getCampeonatos();

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getCampeonatosByEstado")
    public List<CampeonatoVO> getCampeonatosByEstado(@RequestParam(name = "estado") String estado) throws CampeonatoException {
        return ControladorCampeonatos.getInstancia().getCampeonatosByEstado(estado);

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/agregarClubACampeonato")
    public void agregarClubACampeonato(@RequestParam(name = "idClub") Integer idClub,
                                       @RequestParam(name = "idCampeonato") Integer idCampeonato) throws CampeonatoException, ClubException, ClubesCampeonatoException {
        ControladorCampeonatos.getInstancia().agregarClubACampeonato(idClub, idCampeonato);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getCampeonatosByClub")
    public List<CampeonatoVO> getCampeonatosByClub(@RequestParam(name = "idClub") Integer idClub) throws ClubesCampeonatoException {
        return ControladorCampeonatos.getInstancia().getCampeonatosByClub(idClub);

    }
}
