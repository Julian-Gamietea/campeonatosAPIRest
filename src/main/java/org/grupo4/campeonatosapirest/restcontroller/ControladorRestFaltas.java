package org.grupo4.campeonatosapirest.restcontroller;

import org.grupocuatro.controlador.ControladorFaltas;
import org.grupocuatro.excepciones.FaltaException;
import org.grupocuatro.modelo.Falta;
import org.grupocuatro.vo.FaltaVO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControladorRestFaltas {

    @PostMapping("/cargarFalta")
    public void cargarFalta(@RequestParam(name = "idJugador") Integer idJugador,
                            @RequestParam(name = "idPartido") Integer idPartido,
                            @RequestParam(name = "minuto") Integer minuto,
                            @RequestParam(name = "tipo") String tipo) {
        ControladorFaltas.getInstancia().cargarFalta(idJugador, idPartido, minuto, tipo);
    }

    @RequestMapping("/getFaltas")
    public List<FaltaVO> getFaltas() {
        List<Falta> lista = ControladorFaltas.getInstancia().getFaltas();
        List<FaltaVO> result = new ArrayList<>();

        if (lista != null) {
            for (Falta falta : lista) {
                result.add(falta.toVO());
            }
        }

        return result;
    }

    @RequestMapping("/getFaltaById")
    public FaltaVO getFaltaById(@RequestParam(name = "id") Integer id) throws FaltaException {
        Falta result = ControladorFaltas.getInstancia().getFaltaById(id);
        if (result == null) throw new FaltaException("No existe una falta con id: " + id);
        else return result.toVO();
    }

    @RequestMapping("/getFaltasPartido")
    public List<FaltaVO> getFaltasPartido(@RequestParam(name = "idPartido") Integer idPartido) {
        List<Falta> lista = ControladorFaltas.getInstancia().getFaltasPartido(idPartido);
        List<FaltaVO> result = new ArrayList<>();

        if (lista != null) {
            for (Falta falta : lista) {
                result.add(falta.toVO());
            }
        }

        return result;
    }

    @RequestMapping("/getFaltasByTipoAndPartido")
    public List<FaltaVO> getFaltasByTipoAndPartido(@RequestParam(name = "idPartido") Integer idPartido,
                                                   @RequestParam(name = "tipo") String tipo) {
        List<Falta> lista = ControladorFaltas.getInstancia().getFaltasByTipoAndPartido(idPartido, tipo);
        List<FaltaVO> result = new ArrayList<>();

        if (lista != null) {
            for (Falta falta : lista) {
                result.add(falta.toVO());
            }
        }

        return result;
    }

    @RequestMapping("/getFaltasByCampeonato")
    public List<FaltaVO> getFaltasByCampeonato(@RequestParam(name = "idCampeonato") Integer idCampeonato) {
        List<Falta> lista = ControladorFaltas.getInstancia().getFaltasByCampeonato(idCampeonato);
        List<FaltaVO> result = new ArrayList<>();

        if (lista != null) {
            for (Falta falta : lista) {
                result.add(falta.toVO());
            }
        }

        return result;
    }

    @RequestMapping("/getFaltasByJugadorAndPartido")
    public List<FaltaVO> getFaltasByJugadorAndPartido(@RequestParam(name = "idJugador") Integer idJugador,
                                                      @RequestParam(name = "idPartido") Integer idPartido) {
        List<Falta> lista = ControladorFaltas.getInstancia().getFaltasByJugadorAndPartido(idJugador, idPartido);
        List<FaltaVO> result = new ArrayList<>();

        if (lista != null) {
            for (Falta falta : lista) {
                result.add(falta.toVO());
            }
        }

        return result;
    }

    @RequestMapping("/getFaltasByJugadorAndTipoAndPartido")
    public List<FaltaVO> getFaltasByJugadorAndTipoAndPartido(@RequestParam(name = "idJugador") Integer idJugador,
                                                             @RequestParam(name = "tipo") String tipo,
                                                             @RequestParam(name = "idPartido") Integer idPartido) {
        List<Falta> lista = ControladorFaltas.getInstancia().getFaltasByJugadorAndTipoAndPartido(idJugador, tipo, idPartido);
        List<FaltaVO> result = new ArrayList<>();

        if (lista != null) {
            for (Falta falta : lista) {
                result.add(falta.toVO());
            }
        }

        return result;
    }

    @RequestMapping("/getFaltasByJugadorAndCampeonato")
    public List<FaltaVO> getFaltasByJugadorAndCampeonato(@RequestParam(name = "idJugador") Integer idJugador,
                                                         @RequestParam(name = "idCampeonato") Integer idCampeonato) {
        List<Falta> lista = ControladorFaltas.getInstancia().getFaltasByJugadorAndCampeonato(idJugador, idCampeonato);
        List<FaltaVO> result = new ArrayList<>();

        if (lista != null) {
            for (Falta falta : lista) {
                result.add(falta.toVO());
            }
        }

        return result;
    }

    @RequestMapping("/getFaltasByJugadorAndPartidoAndTipoAndCampeonato")
    public List<FaltaVO> getFaltasByJugadorAndPartidoAndTipoAndCampeonato(@RequestParam(name = "idJugador") Integer idJugador,
                                                                          @RequestParam(name = "idPartido") Integer idPartido,
                                                                          @RequestParam(name = "tipo") String tipo,
                                                                          @RequestParam(name = "idCampeonato") Integer idCampeonato) {

        List<Falta> lista = ControladorFaltas.getInstancia().getFaltasByJugadorAndPartidoAndTipo(idJugador, idPartido, tipo);
        List<FaltaVO> result = new ArrayList<>();

        if (lista != null) {
            for (Falta falta : lista) {
                result.add(falta.toVO());
            }
        }

        return result;
    }

    @RequestMapping("/getFaltasByJugador")
    public List<FaltaVO> getFaltasByJugador(@RequestParam(name = "idJugador") Integer idJugador) {
        List<Falta> lista = ControladorFaltas.getInstancia().getFaltasByJugador(idJugador);
        List<FaltaVO> result = new ArrayList<>();

        if (lista != null) {
            for (Falta falta : lista) {
                result.add(falta.toVO());
            }
        }

        return result;
    }

    @RequestMapping("/getFaltasByTipo")
    public List<FaltaVO> getFaltasByTipo(@RequestParam(name = "tipo") String tipo) {
        List<Falta> lista = ControladorFaltas.getInstancia().getFaltasByTipo(tipo);
        List<FaltaVO> result = new ArrayList<>();

        if (lista != null) {
            for (Falta falta : lista) {
                result.add(falta.toVO());
            }
        }

        return result;
    }
}
