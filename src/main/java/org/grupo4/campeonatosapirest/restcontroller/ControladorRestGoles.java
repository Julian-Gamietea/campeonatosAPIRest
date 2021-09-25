package org.grupo4.campeonatosapirest.restcontroller;

import org.grupocuatro.controlador.ControladorFaltas;
import org.grupocuatro.controlador.ControladorGoles;
import org.grupocuatro.modelo.Gol;
import org.grupocuatro.vo.GolVO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControladorRestGoles {

    @PostMapping("/cargarGol")
    public void cargarGol(@RequestBody GolVO gol) {
        ControladorGoles.getInstancia().cargarGol(gol.getJugador().getIdJugador(), gol.getPartido().getIdPartido(), gol.getMinuto(), gol.getTipo());
    }

    @RequestMapping("/contarCantidadGoles")
    public int contarCantidadGoles(@RequestParam(name = "idClub") Integer idClub,
                                   @RequestParam(name = "idPartido") Integer idPartido) {
        return ControladorGoles.getInstancia().contarCantidadGoles(idClub, idPartido);

    }

    @RequestMapping("/getGoles")
    public List<GolVO> getGoles() {
        List<Gol> lista = ControladorGoles.getInstancia().getGoles();
        List<GolVO> result = new ArrayList<>();
        for (Gol gol : lista) {
            result.add(gol.toVO());
        }

        return result;
    }

    @RequestMapping("/getGolById")
    public GolVO getGolById(@RequestParam(name = "idGol") Integer idGol) {
        return ControladorGoles.getInstancia().getGolById(idGol).toVO();
    }

    @RequestMapping("/getGolesByPartido")
    public List<GolVO> getGolesByPartido(@RequestParam(name = "idPartido") Integer idPartido) {
        List<Gol> lista = ControladorGoles.getInstancia().getGolesByPartido(idPartido);
        List<GolVO> result = new ArrayList<>();
        for (Gol gol : lista) {
            result.add(gol.toVO());
        }

        return result;
    }

    @RequestMapping("/getGolesByPartidoAndClub")
    public List<GolVO> getGolesByPartidoAndClub(@RequestParam(name = "idPartido") Integer idPartido,
                                                @RequestParam(name = "idClubAContar") Integer idClubAContar,
                                                @RequestParam(name = "idClubRival") Integer idClubRival) {
        List<Gol> lista = ControladorGoles.getInstancia().getGolesByPartidoAndClub(idPartido, idClubAContar, idClubRival);
        List<GolVO> result = new ArrayList<>();
        for (Gol gol : lista) {
            result.add(gol.toVO());
        }

        return result;
    }

    @RequestMapping("/getGolesByPartidoAndSentido")
    public List<GolVO> getGolesByPartidoAndSentido(@RequestParam(name = "idPartido") Integer idPartido,
                                                   @RequestParam(name = "sentido") String sentido) {
        List<Gol> lista = ControladorGoles.getInstancia().getGolesByPartidoAndSentido(idPartido, sentido);
        List<GolVO> result = new ArrayList<>();
        for (Gol gol : lista) {
            result.add(gol.toVO());
        }

        return result;
    }

    @RequestMapping("/getGolesByJugadorAndPartido")
    public List<GolVO> getGolesByJugadorAndPartido(@RequestParam(name = "idPartido") Integer idPartido,
                                                   @RequestParam(name = "idJugador") Integer idJugador) {
        List<Gol> lista = ControladorGoles.getInstancia().getGolesByJugadorAndPartido(idPartido, idJugador);
        List<GolVO> result = new ArrayList<>();
        for (Gol gol : lista) {
            result.add(gol.toVO());
        }

        return result;
    }

    @RequestMapping("/getGolesByJugador")
    public List<GolVO> getGolesByJugador(@RequestParam(name = "idJugador") Integer idJugador) {
        List<Gol> lista = ControladorGoles.getInstancia().getGolesByJugador(idJugador);
        List<GolVO> result = new ArrayList<>();
        for (Gol gol : lista) {
            result.add(gol.toVO());
        }

        return result;
    }


}
