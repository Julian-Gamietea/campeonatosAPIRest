package org.grupo4.campeonatosapirest.restcontroller;

import org.grupocuatro.controlador.ControladorJugadores;

import org.grupocuatro.excepciones.CampeonatoException;
import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.excepciones.JugadorException;
import org.grupocuatro.excepciones.PartidoException;
import org.grupocuatro.vo.JugadorVO;
import org.grupocuatro.vo.StatsVO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class ControladorRestJugadores {
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/crearJugador")
    public Integer crearJugador(@RequestParam(name = "tipoDoc") String tipoDoc,
                                @RequestParam(name = "documento") int documento,
                                @RequestParam(name = "nombre") String nombre,
                                @RequestParam(name = "apellido") String apellido,
                                @RequestParam(name = "idClub") Integer idClub,
                                @RequestParam(name = "fechaNac") String fechaNacString,
                                @RequestParam(name = "direccion") String direccion,
                                @RequestParam(name = "mail") String mail,
                                @RequestParam(name = "password") String password,
                                @RequestParam(name = "telefono") String telefono) throws JugadorException, ClubException {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/d");
        LocalDate fechaNac = LocalDate.parse(fechaNacString, formato);
        Integer id = ControladorJugadores.getInstancia().agregarJugador(tipoDoc, documento, nombre, apellido, idClub, fechaNac, direccion, mail, telefono, password);
        return id;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/loginJugador")
    public Integer loginJugador(@RequestParam(name = "mail") String mail,
                                @RequestParam(name = "password") String password) throws JugadorException {
        return ControladorJugadores.getInstancia().loginJugador(mail, password);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/cambiarPasswordJugador")
    public void cambiarPassword(@RequestParam(name = "idJugador") Integer idJugador,
                                @RequestParam(name = "password") String password) throws JugadorException {
        ControladorJugadores.getInstancia().cambiarPassword(idJugador, password);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/modificarDireccion")
    public void modificarDireccion(@RequestParam(name = "idJugador") Integer idJugador,
                                   @RequestParam(name = "direccion") String direccion) throws JugadorException {
        ControladorJugadores.getInstancia().modificarDireccion(idJugador, direccion);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/modificarMail")
    public void modificarMail(@RequestParam(name = "idJugador") Integer idJugador,
                              @RequestParam(name = "mail") String mail) throws JugadorException {
        ControladorJugadores.getInstancia().modificarMail(idJugador, mail);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/modificarTelefono")
    public void modificarTelefono(@RequestParam(name = "idJugador") Integer idJugador,
                                  @RequestParam(name = "telefono") String telefono) throws JugadorException {
        ControladorJugadores.getInstancia().modificarTelefono(idJugador, telefono);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/modificarEstado")
    public void modificarEstado(@RequestParam(name = "idJugador") Integer idJugador) throws JugadorException {
        ControladorJugadores.getInstancia().modificarEstado(idJugador);
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/modificarNombre")
    public void modificarNombre(@RequestParam(name = "idJugador") Integer idJugador,
                                   @RequestParam(name = "nombre") String nombre) throws JugadorException {
        ControladorJugadores.getInstancia().modificarNombre(idJugador, nombre);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/modificarApellido")
    public void modificarApellido(@RequestParam(name = "idJugador") Integer idJugador,
                                @RequestParam(name = "apellido") String apellido) throws JugadorException {
        ControladorJugadores.getInstancia().modificarApellido(idJugador, apellido);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/modificarFechaNac")
    public void modificarFechaNac(@RequestParam(name = "idJugador") Integer idJugador,
                                @RequestParam(name = "fechaNac") LocalDate fechaNac) throws JugadorException {
        ControladorJugadores.getInstancia().modificarFechaNac(idJugador, fechaNac);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/modificarDocumento")
    public void modificarDocumento(@RequestParam(name = "idJugador") Integer idJugador,
                                  @RequestParam(name = "documento") int documento) throws JugadorException {
        ControladorJugadores.getInstancia().modificarDocumento(idJugador, documento);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/modificarTipoDocumento")
    public void modificarTipoDocumento(@RequestParam(name = "idJugador") Integer idJugador,
                                   @RequestParam(name = "tipo") String tipodoc) throws JugadorException {
        ControladorJugadores.getInstancia().modificarTipoDocumento(idJugador, tipodoc);
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/encontrarJugador")
    public JugadorVO encontrarJugador(@RequestParam(name = "idJugador") Integer idJugador) throws JugadorException {

        return ControladorJugadores.getInstancia().encontrarJugador(idJugador);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getStatsByCampeonato")
    public StatsVO getStatsByCampeonato(@RequestParam(name = "idJugador") Integer idJugador,
                                        @RequestParam(name = "idCampeonato") Integer idCampeonato) throws CampeonatoException, PartidoException, JugadorException {
        return ControladorJugadores.getInstancia().getStatsByCampeonato(idJugador, idCampeonato);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getStatsByClub")
    public StatsVO getStatsByClub(@RequestParam(name = "idJugador") Integer idJugador,
                                  @RequestParam(name = "idClub") Integer idClub) throws ClubException, PartidoException, JugadorException {
        return ControladorJugadores.getInstancia().getStatsByClub(idJugador, idClub);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getJugadores")
    public List<JugadorVO> getJugadores() throws JugadorException {
        return ControladorJugadores.getInstancia().getJugadores();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getJugadoresByClub")
    public List<JugadorVO> getJugadoresByClub(@RequestParam(name = "idClub") Integer idClub) throws JugadorException {
        return ControladorJugadores.getInstancia().getJugadoresByClub(idClub);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getJugadoresByCategoria")
    public List<JugadorVO> getJugadoresByCategoria(@RequestParam(name = "categoria") int categoria) throws JugadorException {
        return ControladorJugadores.getInstancia().getJugadoresByCategoria(categoria);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getJugadoresHabilitadosByClubAndCategoria")
    public List<JugadorVO> getJugadoresHabilitadosByClubAndCategoria(@RequestParam(name = "idClub") Integer idClub,
                                                                     @RequestParam(name = "categoria") int categoria) throws JugadorException {
        return ControladorJugadores.getInstancia().getJugadoresHabilitadosCategoriaClub(idClub, categoria);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getJugadorByDocumento")
    public JugadorVO getJugadorByDocumento(@RequestParam(name = "documento") Integer documento,
                                           @RequestParam(name = "tipoDoc") String tipoDoc) throws JugadorException {
        return ControladorJugadores.getInstancia().getJugadorByDocumento(documento, tipoDoc);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getJugadorByNombre")

    public List<JugadorVO> getJugadorByNombre(@RequestParam(name = "nombre") String nombre,
                                              @RequestParam(name = "apellido") String apellido) throws JugadorException {
        return ControladorJugadores.getInstancia().getJugadorByNombre(nombre, apellido);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/modificarEstadoCampeonato")
    public void modificarEstadoCampeonato(@RequestParam(name = "idJugador") int idJugador,
                                          @RequestParam(name = "idCampeonato") int idCampeonato) throws CampeonatoException, JugadorException {
        ControladorJugadores.getInstancia().modificarEstadoCampeonato(idJugador, idCampeonato);
    }


}
