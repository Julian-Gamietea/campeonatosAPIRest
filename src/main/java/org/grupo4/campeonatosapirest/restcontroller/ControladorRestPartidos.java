package org.grupo4.campeonatosapirest.restcontroller;

import org.grupocuatro.controlador.ControladorCampeonatos;
import org.grupocuatro.controlador.ControladorClubes;
import org.grupocuatro.controlador.ControladorPartidos;
import org.grupocuatro.excepciones.*;
import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.modelo.Club;
import org.grupocuatro.modelo.Partido;
import org.grupocuatro.vo.CampeonatoVO;
import org.grupocuatro.vo.ClubVO;
import org.grupocuatro.vo.PartidoVO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class ControladorRestPartidos {

    @PostMapping("/crearPartido")
    public Integer crearPartido(@RequestParam(name = "nroZona") int nroZona,
                                @RequestParam(name = "categoria") int categoria,
                                @RequestParam(name = "idClubLocal") Integer idClubLocal,
                                @RequestParam(name = "idClubVisitante") Integer idClubVisitante,
                                @RequestParam(name = "idCampeonato") Integer idCampeonato) throws CampeonatoException, ClubException, PartidoException {
        return ControladorPartidos.getInstancia().crearPartido(nroZona, categoria, idClubLocal, idClubVisitante, idCampeonato);
    }

    @PostMapping("/cargarFechaAndHoraPartido")
    public void cargarFechaAndHoraPartido(@RequestParam(name = "idPartido") Integer idPartido,
                                          @RequestParam(name = "nroFecha") int nroFecha,
                                          @RequestParam(name = "fecha") LocalDate fecha) throws PartidoException {

        ControladorPartidos.getInstancia().cargarNroFechaYFecha(idPartido, nroFecha, fecha);
    }

    @PostMapping("/cargarResultadosPartido")
    public void cargarResultadosPartido(@RequestParam(name = "idPartido") Integer idPartido,
                                        @RequestParam(name = "incidentes") String incidentes) throws PartidoException, GolException {
        ControladorPartidos.getInstancia().cargarResultadoPartido(idPartido, incidentes);
    }

    @PostMapping("/validadoByClubLocal")
    public void validarByClubLocal(@RequestParam(name = "idClub") Integer idClub,
                                   @RequestParam(name = "idPartido") Integer idPartido) throws CampeonatoException, ClubException, PartidoException, TablaPosicionException {
        ControladorPartidos.getInstancia().validadoPorClubLocal(idClub, idPartido);
    }

    @PostMapping("/validadoByClubVisitante")
    public void validarByClubVisitante(@RequestParam(name = "idClub") Integer idClub,
                                       @RequestParam(name = "idPartido") Integer idPartido) throws PartidoException, CampeonatoException, ClubException, TablaPosicionException {
        ControladorPartidos.getInstancia().validadoPorClubVisitante(idClub, idPartido);
    }


    @RequestMapping("/encontrarPartido")
    public PartidoVO encontrarPartido(@RequestParam(name = "idPartido") Integer idPartido) throws PartidoException {
        return ControladorPartidos.getInstancia().encontrarPartido(idPartido);

    }

    @RequestMapping("/getAllPartidos")
    public List<PartidoVO> getAllPartidos() throws PartidoException {
        return ControladorPartidos.getInstancia().getAllPartidos();

    }

    @RequestMapping("/getPartidosByCategoria")
    public List<PartidoVO> getPartidosByCategoria(@RequestParam(name = "categoria") int categoria) throws PartidoException {
        return ControladorPartidos.getInstancia().getPartidosByCategoria(categoria);

    }

    @RequestMapping("/getUltimoPartidoByClubAndCampeonato")
    public PartidoVO getUltimoPartidoByClubAndCampeonato(@RequestParam(name = "idClub") Integer idClub,
                                                         @RequestParam(name = "idCampeonato") Integer idCampeonato,
                                                         @RequestParam(name = "nroFechaActual") int nroFechaActual) throws PartidoException, CampeonatoException, ClubException {
        Club club = ControladorClubes.getInstancia().getClubById(idClub).toModelo();
        Campeonato campeonato = ControladorCampeonatos.getInstancia().encontrarCampeonato(idCampeonato).toModelo();
        return ControladorPartidos.getInstancia().getUltimoPartidoByClubAndCampeonato(club.getIdClub(), campeonato.getIdCampeonato(), nroFechaActual);

    }

    @RequestMapping("/getPartidosByNroZona")
    public List<PartidoVO> getPartidosByNroZona(@RequestParam(name = "nroZona") int nroZona) throws PartidoException {
        return ControladorPartidos.getInstancia().getPartidosByNroZona(nroZona);

    }

    @RequestMapping("/getPartidosByClubLocal")
    public List<PartidoVO> getPartidosByClubLocal(@RequestParam(name = "idClub") int idClub) throws PartidoException {
        return ControladorPartidos.getInstancia().getPartidosByClubLocal(idClub);

    }

    @RequestMapping("/getPartidosByClubVisitante")
    public List<PartidoVO> getPartidosByClubVisitante(@RequestParam(name = "idClub") int idClub) throws PartidoException {
        return ControladorPartidos.getInstancia().getPartidosByClubVisitante(idClub);

    }

    @RequestMapping("/getPartidosByNroFechaAndCampeonatoAndClub")
    public List<PartidoVO> getPartidosByNroFechaAndCampeonatoAndClub(@RequestParam(name = "idCampeonato") Integer idCampeonato,
                                                                     @RequestParam(name = "nroFecha") int nroFecha,
                                                                     @RequestParam(name = "idClub") Integer idClub) throws PartidoException {
        return ControladorPartidos.getInstancia().getPartidosByNroFechaAndCampeonatoAndClub(idCampeonato, nroFecha, idClub);

    }

    @RequestMapping("/getPartidosByNroFechaAndCampeonato")
    public List<PartidoVO> getPartidosByNroFechaAndCampeonato(@RequestParam(name = "idCampeonato") Integer idCampeonato,
                                                              @RequestParam(name = "nroFecha") int nroFecha) throws PartidoException {
        return ControladorPartidos.getInstancia().getPartidosByNroFechaAndCampeonato(idCampeonato, nroFecha);

    }

    @RequestMapping("/getPartidosByCampeonato")
    public List<PartidoVO> getPartidosByCampeonato(@RequestParam(name = "idCampeonato") Integer idCampeonato) throws PartidoException {
        return ControladorPartidos.getInstancia().getPartidosByCampeonato(idCampeonato);
    }


}


