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
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/cargarFalta")
    public Integer cargarFalta(@RequestParam(name = "idJugador") Integer idJugador,
                               @RequestParam(name = "idPartido") Integer idPartido,
                               @RequestParam(name = "minuto") Integer minuto,
                               @RequestParam(name = "tipo") String tipo) throws FaltaException, PartidoException, JugadorException, MiembroException {
        Integer id = ControladorFaltas.getInstancia().cargarFalta(idJugador, idPartido, minuto, tipo);
        return id;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getFaltas")
    public List<FaltaVO> getFaltas() throws FaltaException {
        return ControladorFaltas.getInstancia().getFaltas();

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getFaltaById")
    public FaltaVO getFaltaById(@RequestParam(name = "id") Integer id) throws FaltaException {
        return ControladorFaltas.getInstancia().getFaltaById(id);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getFaltasPartido")
    public List<FaltaVO> getFaltasPartido(@RequestParam(name = "idPartido") Integer idPartido) throws FaltaException {
        return ControladorFaltas.getInstancia().getFaltasPartido(idPartido);

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getFaltasByTipoAndPartido")
    public List<FaltaVO> getFaltasByTipoAndPartido(@RequestParam(name = "idPartido") Integer idPartido,
                                                   @RequestParam(name = "tipo") String tipo) throws FaltaException {
        return ControladorFaltas.getInstancia().getFaltasByTipoAndPartido(idPartido, tipo);

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getFaltasByCampeonato")
    public List<FaltaVO> getFaltasByCampeonato(@RequestParam(name = "idCampeonato") Integer idCampeonato) throws FaltaException {
        return ControladorFaltas.getInstancia().getFaltasByCampeonato(idCampeonato);

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getFaltasByJugadorAndPartido")
    public List<FaltaVO> getFaltasByJugadorAndPartido(@RequestParam(name = "idJugador") Integer idJugador,
                                                      @RequestParam(name = "idPartido") Integer idPartido) throws FaltaException {
        return ControladorFaltas.getInstancia().getFaltasByJugadorAndPartido(idJugador, idPartido);

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getFaltasByJugadorAndCampeonato")
    public List<FaltaVO> getFaltasByJugadorAndCampeonato(@RequestParam(name = "idJugador") Integer idJugador,
                                                         @RequestParam(name = "idCampeonato") Integer idCampeonato) throws FaltaException {
        return ControladorFaltas.getInstancia().getFaltasByJugadorAndCampeonato(idJugador, idCampeonato);

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getFaltasByJugadorAndPartidoAndTipo")
    public List<FaltaVO> getFaltasByJugadorAndPartidoAndTipo(@RequestParam(name = "idJugador") Integer idJugador,
                                                             @RequestParam(name = "idPartido") Integer idPartido,
                                                             @RequestParam(name = "tipo") String tipo) throws FaltaException {

        return ControladorFaltas.getInstancia().getFaltasByJugadorAndTipoAndPartido(idJugador, tipo, idPartido);

    }/*/
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getFaltasByJugador")
    public List<FaltaVO> getFaltasByJugador(@RequestParam(name = "idJugador") Integer idJugador) throws FaltaException {
        return ControladorFaltas.getInstancia().getFaltasByJugador(idJugador);

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getFaltasByTipo")
    public List<FaltaVO> getFaltasByTipo(@RequestParam(name = "tipo") String tipo) throws FaltaException {
        return ControladorFaltas.getInstancia().getFaltasByTipo(tipo);

    }
/*/
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getFaltasByClubAndPartido")
    public List<FaltaVO> getFaltasByClubAndPartido(@RequestParam(name = "idClub") Integer idClub,
                                                   @RequestParam(name = "idPartido") Integer idPartido) {
        return ControladorFaltas.getInstancia().getFaltasByClubAndPartido(idClub, idPartido);
    }

}
