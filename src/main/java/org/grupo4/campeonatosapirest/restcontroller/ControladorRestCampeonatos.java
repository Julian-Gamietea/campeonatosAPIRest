package org.grupo4.campeonatosapirest.restcontroller;

import org.grupocuatro.controlador.ControladorCampeonatos;
import org.grupocuatro.excepciones.CampeonatoException;
import org.grupocuatro.excepciones.ClubesCampeonatoException;
import org.grupocuatro.vo.CampeonatoVO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class ControladorRestCampeonatos {

    @PostMapping("/crearCampeonato")
    public Integer crearCampeonato(@RequestParam(name = "descripcion") String descripcion,
                                   @RequestParam(name = "fechaInicio") String fechaInicioString,
                                   @RequestParam(name = "fechaFin") String fechaFinString,
                                   @RequestParam(name = "estado") String estado) throws CampeonatoException {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/d");
        LocalDate fechaInicio = LocalDate.parse(fechaInicioString, formato);
        LocalDate fechaFin = LocalDate.parse(fechaFinString, formato);
        Integer id = ControladorCampeonatos.getInstancia().crearCampeonato(descripcion, fechaInicio, fechaFin, estado);
        if (id == null) throw new CampeonatoException("El campeonato que se esta intentando crear ya existe");
        else return id;
    }

    @PostMapping("/definirTipoCampeonatoAndCategoria")
    public void definirTipoCampeonatoAndCategoria(@RequestParam(name = "cantidadZonas") int cantidadZonas,
                                                  @RequestParam(name = "idCampeonato") Integer idCampeonato,
                                                  @RequestParam(name = "categoria") int categoria) throws ClubesCampeonatoException {

        ControladorCampeonatos.getInstancia().definirTipoCampeonatoAndCategoria(cantidadZonas, idCampeonato, categoria);
    }

    @PostMapping("/terminarCampeonato")
    public void terminarCampeonato(@RequestParam(name = "idCampeonato") Integer idCampeonato) {
        ControladorCampeonatos.getInstancia().terminarCampeonato(idCampeonato);
    }

    @RequestMapping("/encontrarCampeonato")
    public CampeonatoVO encontrarCampeonato(@RequestParam(name = "idCampeonato") Integer idCampeonato) throws CampeonatoException {
        return ControladorCampeonatos.getInstancia().encontrarCampeonato(idCampeonato);
    }

    @RequestMapping("/getCampeonatos")
    public List<CampeonatoVO> getCampeonatos() throws CampeonatoException {
        return ControladorCampeonatos.getInstancia().getCampeonatos();

    }

    @RequestMapping("/getCampeonatosByEstado")
    public List<CampeonatoVO> getCampeonatosByEstado(@RequestParam(name = "estado") String estado) throws CampeonatoException {
        return ControladorCampeonatos.getInstancia().getCampeonatosByEstado(estado);

    }

    @PostMapping("/agregarClubACampeonato")
    public void agregarClubACampeonato(@RequestParam(name = "idClub") Integer idClub,
                                       @RequestParam(name = "idCampeonato") Integer idCampeonato) {
        ControladorCampeonatos.getInstancia().agregarClubACampeonato(idClub, idCampeonato);
    }

    @RequestMapping("/getCampeonatosByClub")
    public List<CampeonatoVO> getCampeonatosByClub(@RequestParam(name = "idClub") Integer idClub) throws ClubesCampeonatoException {
        return ControladorCampeonatos.getInstancia().getCampeonatosByClub(idClub);

    }
}
