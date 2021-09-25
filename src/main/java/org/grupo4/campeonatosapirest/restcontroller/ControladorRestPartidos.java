package org.grupo4.campeonatosapirest.restcontroller;

import org.grupocuatro.controlador.ControladorCampeonatos;
import org.grupocuatro.controlador.ControladorClubes;
import org.grupocuatro.controlador.ControladorPartidos;
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
    public Integer crearPartido(@RequestBody PartidoVO partido) {
        return ControladorPartidos.getInstancia().crearPartido(partido.getNroZona(),
                partido.getCategoria(),
                partido.getClubLocal().getIdClub(),
                partido.getClubVisitante().getIdClub(),
                partido.getCampeonato().getIdCampeonato());
    }

    @PostMapping("/cargarFechaAndHoraPartido")
    public void cargarFechaAndHoraPartido(@RequestParam(name = "idPartido") Integer idPartido,
                                          @RequestParam(name = "nroFecha") int nroFecha,
                                          @RequestParam(name = "fecha") LocalDate fecha) {

        ControladorPartidos.getInstancia().cargarNroFechaYFecha(idPartido, nroFecha, fecha);
    }

    @PostMapping("/cargarResultadosPartido")
    public void cargarResultadosPartido(@RequestParam(name = "idPartido") Integer idPartido, @RequestParam(name = "incidentes") String incidentes) {
        ControladorPartidos.getInstancia().cargarResultadoPartido(idPartido, incidentes);
    }

    @PostMapping("/validadoByClubLocal")
    public void validarByClubLocal(@RequestParam(name = "idClub") Integer idClub, @RequestParam(name = "idPartido") Integer idPartido) {
        ControladorPartidos.getInstancia().validadoPorClubLocal(idClub, idPartido);
    }

    @PostMapping("/validadoByClubVisitante")
    public void validarByClubVisitante(@RequestParam(name = "idClub") Integer idClub, @RequestParam(name = "idPartido") Integer idPartido) {
        ControladorPartidos.getInstancia().validadoPorClubVisitante(idClub, idPartido);
    }


    @RequestMapping("/encontrarPartido")
    public PartidoVO encontrarPartido(@RequestParam(name = "idPartido") Integer idPartido) {
        PartidoVO partido = ControladorPartidos.getInstancia().encontrarPartido(idPartido).toVO();
        if (partido == null)
            return new PartidoVO();
        else {
            return partido;
        }
    }

    @RequestMapping("/getAllPartidos")
    public List<PartidoVO> getAllPartidos() {
        List<Partido> partidos = ControladorPartidos.getInstancia().getAllPartidos();
        List<PartidoVO> partidosVO = new ArrayList<>();
        for (Partido partido : partidos)
            partidosVO.add(partido.toVO());
        return partidosVO;
    }

    @RequestMapping("/getPartidosByCategoria")
    public List<PartidoVO> getPartidosByCategoria(@RequestParam(name = "categoria") int categoria) {
        List<Partido> partidos = ControladorPartidos.getInstancia().getPartidosByCategoria(categoria);
        List<PartidoVO> partidosVO = new ArrayList<>();
        for (Partido partido : partidos)
            partidosVO.add(partido.toVO());
        return partidosVO;
    }

    @RequestMapping("/getUltimoPartidoByClubAndCampeonato")
    public PartidoVO getUltimoPartidoByClubAndCampeonato(@RequestParam(name = "idClub") Integer idClub,
                                                         @RequestParam(name = "idCampeonato") Integer idCampeonato,
                                                         @RequestParam(name = "nroFechaActual") int nroFechaActual) {
        Club club = ControladorClubes.getInstancia().getClubById(idClub);
        Campeonato campeonato = ControladorCampeonatos.getInstancia().encontrarCampeonato(idCampeonato);
        PartidoVO partido = ControladorPartidos.getInstancia().getUltimoPartidoByClubAndCampeonato(club.getIdClub(), campeonato.getIdCampeonato(), nroFechaActual).toVO();
        if (partido == null)
            return new PartidoVO();
        else {
            return partido;
        }
    }

    @RequestMapping("/getPartidosByNroZona")
    public List<PartidoVO> getPartidosByNroZona(@RequestParam(name = "nroZona") int nroZona) {
        List<Partido> partidos = ControladorPartidos.getInstancia().getPartidosByNroZona(nroZona);
        List<PartidoVO> partidosVO = new ArrayList<>();
        for (Partido partido : partidos)
            partidosVO.add(partido.toVO());
        return partidosVO;
    }

    @RequestMapping("/getPartidosByClubLocal")
    public List<PartidoVO> getPartidosByClubLocal(@RequestParam(name = "idClub") int idClub) {
        List<Partido> partidos = ControladorPartidos.getInstancia().getPartidosByClubLocal(idClub);
        List<PartidoVO> partidosVO = new ArrayList<>();
        for (Partido partido : partidos)
            partidosVO.add(partido.toVO());
        return partidosVO;
    }

    @RequestMapping("/getPartidosByClubVisitante")
    public List<PartidoVO> getPartidosByClubVisitante(@RequestParam(name = "idClub") int idClub) {
        List<Partido> partidos = ControladorPartidos.getInstancia().getPartidosByClubVisitante(idClub);
        List<PartidoVO> partidosVO = new ArrayList<>();
        for (Partido partido : partidos)
            partidosVO.add(partido.toVO());
        return partidosVO;
    }

    @RequestMapping("/getPartidosByNroFechaAndCampeonatoAndClub")
    public List<PartidoVO> getPartidosByNroFechaAndCampeonatoAndClub(@RequestParam(name = "idCampeonato") Integer idCampeonato,
                                                                     @RequestParam(name = "nroFecha") int nroFecha,
                                                                     @RequestParam(name = "idClub") Integer idClub) {
        List<Partido> partidos = ControladorPartidos.getInstancia().getPartidosByNroFechaAndCampeonatoAndClub(idCampeonato, nroFecha, idClub);
        List<PartidoVO> partidosVO = new ArrayList<>();
        for (Partido partido : partidos)
            partidosVO.add(partido.toVO());
        return partidosVO;
    }

    @RequestMapping("/getPartidosByNroFechaAndCampeonato")
    public List<PartidoVO> getPartidosByNroFechaAndCampeonato(@RequestParam(name = "idCampeonato") Integer idCampeonato,
                                                              @RequestParam(name = "nroFecha") int nroFecha) {
        List<Partido> partidos = ControladorPartidos.getInstancia().getPartidosByNroFechaAndCampeonato(idCampeonato, nroFecha);
        List<PartidoVO> partidosVO = new ArrayList<>();
        for (Partido partido : partidos)
            partidosVO.add(partido.toVO());
        return partidosVO;
    }


}


