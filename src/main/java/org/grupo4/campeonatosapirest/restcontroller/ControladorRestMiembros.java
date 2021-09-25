package org.grupo4.campeonatosapirest.restcontroller;

import org.grupocuatro.controlador.ControladorFaltas;
import org.grupocuatro.controlador.ControladorMiembros;
import org.grupocuatro.modelo.Miembro;
import org.grupocuatro.vo.MiembroVO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ControladorRestMiembros {

    @PostMapping("/agregarJugadoresEnLista")
    public void agregarJugadoresEnLista(@RequestBody MiembroVO miembro) {
        ControladorMiembros.getInstancia().agregarJugadoresEnLista(miembro.getClub().toModelo(), miembro.getPartido().toModelo(), miembro.getJugador().toModelo());
    }

    @PostMapping("/definirIngresoEgreso")
    public void definirIngresoEgreso(@RequestParam(name = "idMiembro") Integer idMiembro,
                                     @RequestParam(name = "ingreso") int ingreso,
                                     @RequestParam(name = "egreso") int egreso) {
        ControladorMiembros.getInstancia().definirIngresoEgreso(idMiembro, ingreso, egreso);
    }

    @RequestMapping("/getMiembros")
    public List<MiembroVO> getMiembros() {
        List<Miembro> lista = ControladorMiembros.getInstancia().getMiembros();
        List<MiembroVO> result = new ArrayList<>();
        for (Miembro miembro : lista) {
            result.add(miembro.toVO());
        }

        return result;
    }

    @RequestMapping("/getMiembroById")
    public MiembroVO getMiembroById(@RequestParam(name = "idMiembro") Integer idMiembro) {
        MiembroVO miembro = ControladorMiembros.getInstancia().getMiembroById(idMiembro).toVO();
        if (miembro == null)
            return new MiembroVO();
        else {
            return miembro;
        }
    }

    @RequestMapping("/getMiembrosByClub")
    public List<MiembroVO> getMiembrosByClub(@RequestParam(name = "idClub") Integer idClub) {
        List<Miembro> lista = ControladorMiembros.getInstancia().getMiembrosByClub(idClub);
        List<MiembroVO> result = new ArrayList<>();
        for (Miembro miembro : lista) {
            result.add(miembro.toVO());
        }

        return result;
    }

    @RequestMapping("/getMiembrosByClubAndPartido")
    public List<MiembroVO> getMiembrosByClubAndPartido(@RequestParam(name = "idClub") Integer idClub,
                                                       @RequestParam(name = "idPartido") Integer idPartido) {
        List<Miembro> lista = ControladorMiembros.getInstancia().getMiembrosByClubAndPartido(idClub, idPartido);
        List<MiembroVO> result = new ArrayList<>();
        for (Miembro miembro : lista) {
            result.add(miembro.toVO());
        }

        return result;
    }

    @RequestMapping("/getMiembroByPartidoAndJugador")
    public MiembroVO getMiembroByPartidoAndJugador(@RequestParam(name = "idPartido") Integer idPartido,
                                                   @RequestParam(name = "idJugador") Integer idJugador) {

        MiembroVO miembro = ControladorMiembros.getInstancia().getMiembroByPartidoAndJugador(idPartido, idJugador).toVO();
        if (miembro == null)
            return new MiembroVO();
        else {
            return miembro;
        }
    }

    @RequestMapping("/getMiembroByClubAndPartidoAndJugador")
    public MiembroVO getMiembroByClubAndPartidoAndJugador(@RequestParam(name = "idClub") Integer idClub,
                                                          @RequestParam(name = "idPartido") Integer idPartido,
                                                          @RequestParam(name = "idJugador") Integer idJugador) {

        MiembroVO miembro = ControladorMiembros.getInstancia().getMiembroByClubAndPartidoAndJugador(idClub, idPartido, idJugador).toVO();
        if (miembro == null)
            return new MiembroVO();
        else {
            return miembro;
        }
    }

    @RequestMapping("/getMiembroByJugadorAndFecha")
    public List<MiembroVO> getMiembroByJugadorAndFecha(@RequestParam(name = "idJugador") Integer idJugador,
                                                       @RequestParam(name = "fecha") LocalDate fecha) {
        List<Miembro> lista = ControladorMiembros.getInstancia().getMiembroByJugadorAndFecha(idJugador,fecha);
        List<MiembroVO> result = new ArrayList<>();
        for (Miembro miembro : lista) {
            result.add(miembro.toVO());
        }

        return result;
    }

}

