package org.grupo4.campeonatosapirest.restcontroller;

import org.grupocuatro.excepciones.ClubException;
import org.grupocuatro.excepciones.ClubesCampeonatoException;
import org.grupocuatro.modelo.*;
import org.grupocuatro.controlador.*;
import org.grupocuatro.vo.ClubVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorRestClubes {

    @PostMapping("/crearClub")
    public void crearClub(@RequestBody ClubVO club) throws ClubException {
        ControladorClubes.getInstancia().crearClub(club.getIdClub(), club.getNombre(), club.getDireccion());
    }

    @PostMapping("/modificarClub")
    public void modificarClub(@RequestParam(name = "idClub") Integer idClub,
                              @RequestParam(name = "nombre") String nombre,
                              @RequestParam(name = "direccion") String direccion) throws ClubException {
        ControladorClubes.getInstancia().modificarClub(idClub, nombre, direccion);
    }

    @RequestMapping("/getClubById")
    public ClubVO getClubById(@RequestParam(name = "idClub") Integer idClub) throws ClubException {
        return ControladorClubes.getInstancia().getClubById(idClub);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getClubes")
    public List<ClubVO> getClubes() throws ClubException {
        return ControladorClubes.getInstancia().getClubes();

    }

    @RequestMapping("/getClubesByCampeonato")
    public List<ClubVO> getClubesByCampeonato(@RequestParam(name = "idCampeonato") Integer idCampeonato) throws ClubesCampeonatoException {
        return ControladorClubes.getInstancia().getClubesByCampeonato(idCampeonato);

    }

    @RequestMapping("/getClubesHabilitadosPorCategoria")
    public List<ClubVO> getClubesHabiltadosPorCategoria(@RequestParam(name = "categoria") int categoria) throws ClubException {
        return ControladorClubes.getInstancia().getClubesHabiltadosPorCategoria(categoria);

    }


}
