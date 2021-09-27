package org.grupo4.campeonatosapirest.restcontroller;

import org.grupocuatro.controlador.ControladorFaltas;
import org.grupocuatro.controlador.ControladorMiembros;
import org.grupocuatro.excepciones.MiembroException;
import org.grupocuatro.modelo.Miembro;
import org.grupocuatro.vo.MiembroVO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@RestController
public class ControladorRestMiembros {

    @PostMapping("/agregarJugadoresEnLista")
    public void agregarJugadoresEnLista(@RequestParam(name = "idClub") Integer idClub,
                                        @RequestParam(name = "idPartido") Integer idPartido,
                                        @RequestParam(name = "idJugador") Integer idJugador) {
        ControladorMiembros.getInstancia().agregarJugadoresEnLista(idClub, idPartido, idJugador);
    }

    @PostMapping("/definirIngresoEgreso")
    public void definirIngresoEgreso(@RequestParam(name = "idMiembro") Integer idMiembro,
                                     @RequestParam(name = "ingreso") int ingreso,
                                     @RequestParam(name = "egreso") int egreso) {
        ControladorMiembros.getInstancia().definirIngresoEgreso(idMiembro, ingreso, egreso);
    }

    @RequestMapping("/getMiembros")
    public List<MiembroVO> getMiembros() throws MiembroException {
        return ControladorMiembros.getInstancia().getMiembros();

    }

    @RequestMapping("/getMiembroById")
    public MiembroVO getMiembroById(@RequestParam(name = "idMiembro") Integer idMiembro) throws MiembroException {
        return ControladorMiembros.getInstancia().getMiembroById(idMiembro);

    }

    @RequestMapping("/getMiembrosByClub")
    public List<MiembroVO> getMiembrosByClub(@RequestParam(name = "idClub") Integer idClub) throws MiembroException {
        return ControladorMiembros.getInstancia().getMiembrosByClub(idClub);

    }

    @RequestMapping("/getMiembrosByClubAndPartido")
    public List<MiembroVO> getMiembrosByClubAndPartido(@RequestParam(name = "idClub") Integer idClub,
                                                       @RequestParam(name = "idPartido") Integer idPartido) throws MiembroException {
        return ControladorMiembros.getInstancia().getMiembrosByClubAndPartido(idClub, idPartido);

    }

    @RequestMapping("/getMiembroByPartidoAndJugador")
    public MiembroVO getMiembroByPartidoAndJugador(@RequestParam(name = "idPartido") Integer idPartido,
                                                   @RequestParam(name = "idJugador") Integer idJugador) throws MiembroException {

        return ControladorMiembros.getInstancia().getMiembroByPartidoAndJugador(idPartido, idJugador);
    }

    @RequestMapping("/getMiembroByClubAndPartidoAndJugador")
    public MiembroVO getMiembroByClubAndPartidoAndJugador(@RequestParam(name = "idClub") Integer idClub,
                                                          @RequestParam(name = "idPartido") Integer idPartido,
                                                          @RequestParam(name = "idJugador") Integer idJugador) throws MiembroException {
        return ControladorMiembros.getInstancia().getMiembroByClubAndPartidoAndJugador(idClub, idPartido, idJugador);

    }

    @RequestMapping("/getMiembroByJugadorAndFecha")
    public List<MiembroVO> getMiembroByJugadorAndFecha(@RequestParam(name = "idJugador") Integer idJugador,
                                                       @RequestParam(name = "fecha") LocalDate fecha) throws MiembroException {
        return ControladorMiembros.getInstancia().getMiembroByJugadorAndFecha(idJugador, fecha);

    }

}

