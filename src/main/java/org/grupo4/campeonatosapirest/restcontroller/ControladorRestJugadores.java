package org.grupo4.campeonatosapirest.restcontroller;


import org.grupocuatro.controlador.ControladorJugadores;
import org.grupocuatro.modelo.Jugador;
import org.grupocuatro.vo.JugadorVO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class ControladorRestJugadores {

    @PostMapping("/crearJugador")
    public Integer crearJugador(@RequestBody JugadorVO jugador) {
        return ControladorJugadores.getInstancia().agregarJugador(jugador.getTipoDocumento(), jugador.getDocumento(), jugador.getNombre(), jugador.getApellido(), jugador.getClub().getIdClub(), jugador.getFechaNacimiento(), jugador.getDireccion(), jugador.getMail(), jugador.getTelefono());
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
    public JugadorVO encontrarJugador(@RequestParam(name = "idJugador") Integer idJugador) {
        JugadorVO jugador = ControladorJugadores.getInstancia().encontrarJugador(idJugador).toVO();
        if (jugador == null)
            return new JugadorVO();
        else {
            return jugador;
        }
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
        for (Jugador jugador : jugadores) {
            jugadoresVO.add(jugador.toVO());
        }
        return jugadoresVO;
    }

    @RequestMapping("/getJugadoresByClub")
    public List<JugadorVO> getJugadoresByClub(@RequestParam(name = "idClub") Integer idClub) {
        List<Jugador> jugadores = ControladorJugadores.getInstancia().getJugadoresByClub(idClub);
        List<JugadorVO> jugadoresVO = new ArrayList<>();
        for (Jugador jugador : jugadores) {
            jugadoresVO.add(jugador.toVO());
        }
        return jugadoresVO;
    }

    @RequestMapping("/getJugadoresByCategoria")
    public List<JugadorVO> getJugadoresByCategoria(@RequestParam(name = "categoria") int categoria) {
        List<Jugador> jugadores = ControladorJugadores.getInstancia().getJugadoresByCategoria(categoria);
        List<JugadorVO> jugadoresVO = new ArrayList<>();
        for (Jugador jugador : jugadores) {
            jugadoresVO.add(jugador.toVO());
        }
        return jugadoresVO;
    }

    @RequestMapping("/getJugadoresHabilitadosByClubAndCategoria")
    public List<JugadorVO> getJugadoresHabilitadosByClubAndCategoria(@RequestParam(name = "idClub") Integer idClub, @RequestParam(name = "categoria") int categoria) {
        List<Jugador> jugadores = ControladorJugadores.getInstancia().getJugadoresHabilitadosCategoriaClub(idClub, categoria);
        List<JugadorVO> jugadoresVO = new ArrayList<>();
        for (Jugador jugador : jugadores) {
            jugadoresVO.add(jugador.toVO());
        }
        return jugadoresVO;
    }

    @RequestMapping("/getJugadorByDocumento")
    public JugadorVO getJugadorByDocumento(@RequestParam(name = "documento") Integer documento, @RequestParam(name = "tipoDoc") String tipoDoc) {
        JugadorVO jugador = ControladorJugadores.getInstancia().getJugadorByDocumento(documento, tipoDoc).toVO();
        if (jugador == null)
            return new JugadorVO();
        else {
            return jugador;
        }
    }

    @RequestMapping("/getJugadorByNombre")
    public List<JugadorVO> getJugadorByNombre(@RequestParam(name = "nombre") String nombre, @RequestParam(name = "apellido") String apellido) {
        List<Jugador> jugadores = ControladorJugadores.getInstancia().getJugadorByNombre(nombre, apellido);
        List<JugadorVO> jugadoresVO = new ArrayList<>();
        for (Jugador jugador : jugadores) {
            jugadoresVO.add(jugador.toVO());
        }
        return jugadoresVO;
    }


}
