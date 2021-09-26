package org.grupo4.campeonatosapirest.restcontroller;


import org.grupocuatro.controlador.ControladorJugadores;
import org.grupocuatro.excepciones.JugadorException;
import org.grupocuatro.modelo.Jugador;
import org.grupocuatro.vo.JugadorVO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class ControladorRestJugadores {

    @PostMapping("/crearJugador")
    public Integer crearJugador(@RequestParam(name = "tipoDoc") String tipoDoc,
                                @RequestParam(name = "documento") int documento,
                                @RequestParam(name = "nombre") String nombre,
                                @RequestParam(name = "apellido") String apellido,
                                @RequestParam(name = "idClub") Integer idClub,
                                @RequestParam(name = "fechaNac") String fechaNacString,
                                @RequestParam(name = "direccion") String direccion,
                                @RequestParam(name = "mail") String mail,
                                @RequestParam(name = "telefono") String telefono) {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/d");
        LocalDate fechaNac = LocalDate.parse(fechaNacString, formato);
        return ControladorJugadores.getInstancia().agregarJugador(tipoDoc, documento, nombre, apellido, idClub, fechaNac, direccion, mail, telefono);
    }

    @PostMapping("/modificarDireccion")
    public void modificarDireccion(@RequestParam(name = "idJugador") Integer idJugador, @RequestParam(name = "direccion") String direccion) {
        ControladorJugadores.getInstancia().modificarDireccion(idJugador, direccion);
    }

    @PostMapping("/modificarMail")
    public void modificarMail(@RequestParam(name = "idJugador") Integer idJugador, @RequestParam(name = "mail") String mail) {
        ControladorJugadores.getInstancia().modificarMail(idJugador, mail);
    }

    @PostMapping("/modificarTelefono")
    public void modificarTelefono(@RequestParam(name = "idJugador") Integer idJugador, @RequestParam(name = "telefono") String telefono) {
        ControladorJugadores.getInstancia().modificarTelefono(idJugador, telefono);
    }

    @PostMapping("/modificarEstado")
    public void modificarEstado(@RequestParam(name = "idJugador") Integer idJugador) {
        ControladorJugadores.getInstancia().modificarEstado(idJugador);
    }

    @RequestMapping("/encontrarJugador")
    public JugadorVO encontrarJugador(@RequestParam(name = "idJugador") Integer idJugador) throws JugadorException {
        Jugador jugador = ControladorJugadores.getInstancia().encontrarJugador(idJugador);
        if (jugador == null) throw new JugadorException("No existe un jugador con id: " + idJugador);
        else return jugador.toVO();

    }

    @RequestMapping("/getStatsByCampeonato")
    public void getStatsByCampeonato(@RequestParam(name = "idJugador") Integer idJugador, @RequestParam(name = "idCampeonato") Integer idCampeonato) {
        ControladorJugadores.getInstancia().getStatsByCampeonato(idJugador, idCampeonato);
    }

    @RequestMapping("/getStatsByClub")
    public void getStatsByClub(@RequestParam(name = "idJugador") Integer idJugador, @RequestParam(name = "idClub") Integer idClub) {
        ControladorJugadores.getInstancia().getStatsByClub(idJugador, idClub);
    }

    @RequestMapping("/getJugadores")
    public List<JugadorVO> getJugadores() {
        List<Jugador> jugadores = ControladorJugadores.getInstancia().getJugadores();
        List<JugadorVO> jugadoresVO = new ArrayList<>();

        if (jugadores != null) {
            for (Jugador jugador : jugadores) {
                jugadoresVO.add(jugador.toVO());
            }
        }

        return jugadoresVO;
    }

    @RequestMapping("/getJugadoresByClub")
    public List<JugadorVO> getJugadoresByClub(@RequestParam(name = "idClub") Integer idClub) {
        List<Jugador> jugadores = ControladorJugadores.getInstancia().getJugadoresByClub(idClub);
        List<JugadorVO> jugadoresVO = new ArrayList<>();

        if (jugadores != null) {
            for (Jugador jugador : jugadores) {
                jugadoresVO.add(jugador.toVO());
            }
        }

        return jugadoresVO;
    }

    @RequestMapping("/getJugadoresByCategoria")
    public List<JugadorVO> getJugadoresByCategoria(@RequestParam(name = "categoria") int categoria) {
        List<Jugador> jugadores = ControladorJugadores.getInstancia().getJugadoresByCategoria(categoria);
        List<JugadorVO> jugadoresVO = new ArrayList<>();

        if (jugadores != null) {
            for (Jugador jugador : jugadores) {
                jugadoresVO.add(jugador.toVO());
            }
        }

        return jugadoresVO;
    }

    @RequestMapping("/getJugadoresHabilitadosByClubAndCategoria")
    public List<JugadorVO> getJugadoresHabilitadosByClubAndCategoria(@RequestParam(name = "idClub") Integer idClub, @RequestParam(name = "categoria") int categoria) {
        List<Jugador> jugadores = ControladorJugadores.getInstancia().getJugadoresHabilitadosCategoriaClub(idClub, categoria);
        List<JugadorVO> jugadoresVO = new ArrayList<>();

        if (jugadores != null) {
            for (Jugador jugador : jugadores) {
                jugadoresVO.add(jugador.toVO());
            }
        }

        return jugadoresVO;
    }

    @RequestMapping("/getJugadorByDocumento")
    public JugadorVO getJugadorByDocumento(@RequestParam(name = "documento") Integer documento, @RequestParam(name = "tipoDoc") String tipoDoc) throws JugadorException {
        Jugador jugador = ControladorJugadores.getInstancia().getJugadorByDocumento(documento, tipoDoc);
        if (jugador == null) throw new JugadorException("No existe un jugador con numero de documento: " + documento);
        else return jugador.toVO();
    }

    @RequestMapping("/getJugadorByNombre")
    public List<JugadorVO> getJugadorByNombre(@RequestParam(name = "nombre") String nombre, @RequestParam(name = "apellido") String apellido) {
        List<Jugador> jugadores = ControladorJugadores.getInstancia().getJugadorByNombre(nombre, apellido);
        List<JugadorVO> jugadoresVO = new ArrayList<>();

        if (jugadores != null) {
            for (Jugador jugador : jugadores) {
                jugadoresVO.add(jugador.toVO());
            }
        }

        return jugadoresVO;
    }


}
