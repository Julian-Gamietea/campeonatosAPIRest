package org.grupo4.campeonatosapirest.restcontroller;

import org.grupocuatro.controlador.ControladorFaltas;
import org.grupocuatro.excepciones.FaltaException;
import org.grupocuatro.excepciones.JugadorException;
import org.grupocuatro.excepciones.MiembroException;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.modelo.Falta;
import org.grupocuatro.vo.FaltaVO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControladorRestFaltas {

    @PostMapping("/cargarFalta")
    public Integer cargarFalta(@RequestParam(name = "idJugador") Integer idJugador,
                               @RequestParam(name = "idPartido") Integer idPartido,
                               @RequestParam(name = "minuto") Integer minuto,
                               @RequestParam(name = "tipo") String tipo) throws FaltaException, PartidoException, JugadorException, MiembroException {
        Integer id = ControladorFaltas.getInstancia().cargarFalta(idJugador, idPartido, minuto, tipo);
        return id;
    }

    @RequestMapping("/getFaltas")
    public List<FaltaVO> getFaltas() throws FaltaException {
        return ControladorFaltas.getInstancia().getFaltas();

    }

    @RequestMapping("/getFaltaById")
    public FaltaVO getFaltaById(@RequestParam(name = "id") Integer id) throws FaltaException {
        return ControladorFaltas.getInstancia().getFaltaById(id);
    }

    @RequestMapping("/getFaltasPartido")
    public List<FaltaVO> getFaltasPartido(@RequestParam(name = "idPartido") Integer idPartido) throws FaltaException {
        return ControladorFaltas.getInstancia().getFaltasPartido(idPartido);

    }

    @RequestMapping("/getFaltasByTipoAndPartido")
    public List<FaltaVO> getFaltasByTipoAndPartido(@RequestParam(name = "idPartido") Integer idPartido,
                                                   @RequestParam(name = "tipo") String tipo) throws FaltaException {
        return ControladorFaltas.getInstancia().getFaltasByTipoAndPartido(idPartido, tipo);

    }

    @RequestMapping("/getFaltasByCampeonato")
    public List<FaltaVO> getFaltasByCampeonato(@RequestParam(name = "idCampeonato") Integer idCampeonato) throws FaltaException {
        return ControladorFaltas.getInstancia().getFaltasByCampeonato(idCampeonato);

    }

    @RequestMapping("/getFaltasByJugadorAndPartido")
    public List<FaltaVO> getFaltasByJugadorAndPartido(@RequestParam(name = "idJugador") Integer idJugador,
                                                      @RequestParam(name = "idPartido") Integer idPartido) throws FaltaException {
        return ControladorFaltas.getInstancia().getFaltasByJugadorAndPartido(idJugador, idPartido);

    }

    @RequestMapping("/getFaltasByJugadorAndCampeonato")
    public List<FaltaVO> getFaltasByJugadorAndCampeonato(@RequestParam(name = "idJugador") Integer idJugador,
                                                         @RequestParam(name = "idCampeonato") Integer idCampeonato) throws FaltaException {
        return ControladorFaltas.getInstancia().getFaltasByJugadorAndCampeonato(idJugador, idCampeonato);

    }

    @RequestMapping("/getFaltasByJugadorAndPartidoAndTipo")
    public List<FaltaVO> getFaltasByJugadorAndPartidoAndTipo(@RequestParam(name = "idJugador") Integer idJugador,
                                                             @RequestParam(name = "idPartido") Integer idPartido,
                                                             @RequestParam(name = "tipo") String tipo) throws FaltaException {

        return ControladorFaltas.getInstancia().getFaltasByJugadorAndTipoAndPartido(idJugador, tipo, idPartido);

    }

    @RequestMapping("/getFaltasByJugador")
    public List<FaltaVO> getFaltasByJugador(@RequestParam(name = "idJugador") Integer idJugador) throws FaltaException {
        return ControladorFaltas.getInstancia().getFaltasByJugador(idJugador);

    }

    @RequestMapping("/getFaltasByTipo")
    public List<FaltaVO> getFaltasByTipo(@RequestParam(name = "tipo") String tipo) throws FaltaException {
        return ControladorFaltas.getInstancia().getFaltasByTipo(tipo);

    }


}
