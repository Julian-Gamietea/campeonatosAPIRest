package org.grupo4.campeonatosapirest.restcontroller;


import org.grupocuatro.controlador.ControladorJugadores;
import org.grupocuatro.excepciones.JugadorException;
import org.grupocuatro.vo.JugadorVO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
                                @RequestParam(name = "telefono") String telefono) throws JugadorException {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/d");
        LocalDate fechaNac = LocalDate.parse(fechaNacString, formato);
        Integer id = ControladorJugadores.getInstancia().agregarJugador(tipoDoc, documento, nombre, apellido, idClub, fechaNac, direccion, mail, telefono);
        if (id == null)
            throw new JugadorException("Ya existe un jugador con documento: " + tipoDoc + " y numero de documento: " + documento);
            //como se van a mostrar un listado de los clubes, no sera necesario chequear que el club sea valido
        else return id;
    }

    @PostMapping("/modificarDireccion")
    public void modificarDireccion(@RequestParam(name = "idJugador") Integer idJugador,
                                   @RequestParam(name = "direccion") String direccion) throws JugadorException {
        ControladorJugadores.getInstancia().modificarDireccion(idJugador, direccion);
    }

    @PostMapping("/modificarMail")
    public void modificarMail(@RequestParam(name = "idJugador") Integer idJugador,
                              @RequestParam(name = "mail") String mail) throws JugadorException {
        ControladorJugadores.getInstancia().modificarMail(idJugador, mail);
    }

    @PostMapping("/modificarTelefono")
    public void modificarTelefono(@RequestParam(name = "idJugador") Integer idJugador,
                                  @RequestParam(name = "telefono") String telefono) throws JugadorException{
        ControladorJugadores.getInstancia().modificarTelefono(idJugador, telefono);
    }

    @PostMapping("/modificarEstado")
    public void modificarEstado(@RequestParam(name = "idJugador") Integer idJugador) throws JugadorException {
        ControladorJugadores.getInstancia().modificarEstado(idJugador);
    }

    @RequestMapping("/encontrarJugador")
    public JugadorVO encontrarJugador(@RequestParam(name = "idJugador") Integer idJugador) throws JugadorException {
        return ControladorJugadores.getInstancia().encontrarJugador(idJugador);


    }

    //TODO estaria bueno ver como devolver las estadisticas
    @RequestMapping("/getStatsByCampeonato")
    public void getStatsByCampeonato(@RequestParam(name = "idJugador") Integer idJugador,
                                     @RequestParam(name = "idCampeonato") Integer idCampeonato) {
        ControladorJugadores.getInstancia().getStatsByCampeonato(idJugador, idCampeonato);
    }

    @RequestMapping("/getStatsByClub")
    public void getStatsByClub(@RequestParam(name = "idJugador") Integer idJugador,
                               @RequestParam(name = "idClub") Integer idClub) {
        ControladorJugadores.getInstancia().getStatsByClub(idJugador, idClub);
    }

    @RequestMapping("/getJugadores")
    public List<JugadorVO> getJugadores() throws JugadorException {
        return ControladorJugadores.getInstancia().getJugadores();

    }

    @RequestMapping("/getJugadoresByClub")
    public List<JugadorVO> getJugadoresByClub(@RequestParam(name = "idClub") Integer idClub) throws JugadorException {
        return ControladorJugadores.getInstancia().getJugadoresByClub(idClub);
    }

    @RequestMapping("/getJugadoresByCategoria")
    public List<JugadorVO> getJugadoresByCategoria(@RequestParam(name = "categoria") int categoria) throws JugadorException {
        return ControladorJugadores.getInstancia().getJugadoresByCategoria(categoria);

    }

    @RequestMapping("/getJugadoresHabilitadosByClubAndCategoria")
    public List<JugadorVO> getJugadoresHabilitadosByClubAndCategoria(@RequestParam(name = "idClub") Integer idClub,
                                                                     @RequestParam(name = "categoria") int categoria) throws JugadorException {
        return ControladorJugadores.getInstancia().getJugadoresHabilitadosCategoriaClub(idClub, categoria);

    }

    @RequestMapping("/getJugadorByDocumento")
    public JugadorVO getJugadorByDocumento(@RequestParam(name = "documento") Integer documento,
                                           @RequestParam(name = "tipoDoc") String tipoDoc) throws JugadorException {
        return ControladorJugadores.getInstancia().getJugadorByDocumento(documento, tipoDoc);

    }

    @RequestMapping("/getJugadorByNombre")
    public List<JugadorVO> getJugadorByNombre(@RequestParam(name = "nombre") String nombre,
                                              @RequestParam(name = "apellido") String apellido) throws JugadorException {
        return ControladorJugadores.getInstancia().getJugadorByNombre(nombre, apellido);

    }


}
