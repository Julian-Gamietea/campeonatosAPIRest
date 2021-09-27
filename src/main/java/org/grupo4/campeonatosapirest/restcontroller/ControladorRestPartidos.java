package org.grupo4.campeonatosapirest.restcontroller;

import org.grupocuatro.controlador.ControladorCampeonatos;
import org.grupocuatro.controlador.ControladorClubes;
import org.grupocuatro.controlador.ControladorPartidos;
import org.grupocuatro.excepciones.PartidoException;
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
    public Integer crearPartido(@RequestBody PartidoVO partido) throws PartidoException {
        return ControladorPartidos.getInstancia().crearPartido(partido.getNroZona(),
                partido.getCategoria(),
                partido.getClubLocal().getIdClub(),
                partido.getClubVisitante().getIdClub(),
                partido.getCampeonato().getIdCampeonato());
    }

    @PostMapping("/cargarFechaAndHoraPartido")
    public void cargarFechaAndHoraPartido(@RequestParam(name = "idPartido") Integer idPartido,
                                          @RequestParam(name = "nroFecha") int nroFecha,
                                          @RequestParam(name = "fecha") LocalDate fecha) throws PartidoException {

        ControladorPartidos.getInstancia().cargarNroFechaYFecha(idPartido, nroFecha, fecha);
    }

    @PostMapping("/cargarResultadosPartido")
    public void cargarResultadosPartido(@RequestParam(name = "idPartido") Integer idPartido, @RequestParam(name = "incidentes") String incidentes) throws PartidoException {
        ControladorPartidos.getInstancia().cargarResultadoPartido(idPartido, incidentes);
    }

    @PostMapping("/validadoByClubLocal")
    public void validarByClubLocal(@RequestParam(name = "idClub") Integer idClub, @RequestParam(name = "idPartido") Integer idPartido) throws PartidoException {
        ControladorPartidos.getInstancia().validadoPorClubLocal(idClub, idPartido);
    }

    @PostMapping("/validadoByClubVisitante")
    public void validarByClubVisitante(@RequestParam(name = "idClub") Integer idClub, @RequestParam(name = "idPartido") Integer idPartido) throws PartidoException {
        ControladorPartidos.getInstancia().validadoPorClubVisitante(idClub, idPartido);
    }


    @RequestMapping("/encontrarPartido")
    public PartidoVO encontrarPartido(@RequestParam(name = "idPartido") Integer idPartido) throws PartidoException {
        PartidoVO partido = ControladorPartidos.getInstancia().encontrarPartido(idPartido);
        if (partido == null)
            return new PartidoVO();
        else {
            return partido;
        }
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
                                                         @RequestParam(name = "nroFechaActual") int nroFechaActual) throws PartidoException {
        Club club = ControladorClubes.getInstancia().getClubById(idClub);
        Campeonato campeonato = ControladorCampeonatos.getInstancia().encontrarCampeonato(idCampeonato);
        PartidoVO partido = ControladorPartidos.getInstancia().getUltimoPartidoByClubAndCampeonato(club.getIdClub(), campeonato.getIdCampeonato(), nroFechaActual);
        if (partido == null)
            return new PartidoVO();
        else {
            return partido;
        }
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
                                                              @RequestParam(name = "nroFecha") int nroFecha) throws PartidoException  {

        return ControladorPartidos.getInstancia().getPartidosByNroFechaAndCampeonato(idCampeonato, nroFecha);
    }


}


