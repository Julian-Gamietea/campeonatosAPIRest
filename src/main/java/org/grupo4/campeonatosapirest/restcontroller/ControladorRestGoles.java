package org.grupo4.campeonatosapirest.restcontroller;

import org.grupocuatro.controlador.ControladorFaltas;
import org.grupocuatro.controlador.ControladorGoles;
import org.grupocuatro.excepciones.GolException;
import org.grupocuatro.modelo.Gol;
import org.grupocuatro.vo.GolVO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControladorRestGoles {

    @PostMapping("/cargarGol")
    public void cargarGol(@RequestParam(name = "idJugador") Integer idJugador,
                          @RequestParam(name = "idPartido") Integer idPartido,
                          @RequestParam(name = "minuto") int minuto,
                          @RequestParam(name = "tipo") String tipo) {
        ControladorGoles.getInstancia().cargarGol(idJugador, idPartido, minuto, tipo);
    }

    @RequestMapping("/contarCantidadGoles")
    public int contarCantidadGoles(@RequestParam(name = "idClub") Integer idClub,
                                   @RequestParam(name = "idPartido") Integer idPartido) {
        return ControladorGoles.getInstancia().contarCantidadGoles(idClub, idPartido);

    }

    @RequestMapping("/getGoles")
    public List<GolVO> getGoles() throws GolException {
        return ControladorGoles.getInstancia().getGoles();

    }

    @RequestMapping("/getGolById")
    public GolVO getGolById(@RequestParam(name = "idGol") Integer idGol) throws GolException {
        return ControladorGoles.getInstancia().getGolById(idGol);

    }

    @RequestMapping("/getGolesByPartido")
    public List<GolVO> getGolesByPartido(@RequestParam(name = "idPartido") Integer idPartido) throws GolException {
        return ControladorGoles.getInstancia().getGolesByPartido(idPartido);

    }

    @RequestMapping("/getGolesByPartidoAndClub")
    public List<GolVO> getGolesByPartidoAndClub(@RequestParam(name = "idPartido") Integer idPartido,
                                                @RequestParam(name = "idClubAContar") Integer idClubAContar,
                                                @RequestParam(name = "idClubRival") Integer idClubRival) throws GolException {
        return ControladorGoles.getInstancia().getGolesByPartidoAndClub(idPartido, idClubAContar, idClubRival);

    }

    @RequestMapping("/getGolesByPartidoAndSentido")
    public List<GolVO> getGolesByPartidoAndSentido(@RequestParam(name = "idPartido") Integer idPartido,
                                                   @RequestParam(name = "sentido") String sentido) throws GolException {
        return ControladorGoles.getInstancia().getGolesByPartidoAndSentido(idPartido, sentido);

    }

    @RequestMapping("/getGolesByJugadorAndPartido")
    public List<GolVO> getGolesByJugadorAndPartido(@RequestParam(name = "idPartido") Integer idPartido,
                                                   @RequestParam(name = "idJugador") Integer idJugador) throws GolException {
        return ControladorGoles.getInstancia().getGolesByJugadorAndPartido(idPartido, idJugador);

    }

    @RequestMapping("/getGolesByJugador")
    public List<GolVO> getGolesByJugador(@RequestParam(name = "idJugador") Integer idJugador) throws GolException {
        return ControladorGoles.getInstancia().getGolesByJugador(idJugador);

    }


}
