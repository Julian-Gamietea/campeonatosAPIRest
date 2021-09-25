package org.grupo4.campeonatosapirest.restcontroller;

import org.grupocuatro.modelo.*;
import org.grupocuatro.controlador.*;
import org.grupocuatro.vo.ClubVO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControladorRestClubes {

    @PostMapping("/crearClub")
    public void crearClub(@RequestBody ClubVO club) {
        ControladorClubes.getInstancia().crearClub(club.getIdClub(), club.getNombre(), club.getDireccion());
    }

    @PostMapping("/modificarClub")
    public void modificarClub(@RequestParam(name = "idClub") Integer idClub,
                              @RequestParam(name = "nombre") String nombre,
                              @RequestParam(name = "direccion") String direccion) {
        ControladorClubes.getInstancia().modificarClub(idClub, nombre, direccion);
    }

    @RequestMapping("/getClubById")
    public ClubVO getClubById(@RequestParam(name = "idClub") Integer idClub) {
        ClubVO club = ControladorClubes.getInstancia().getClubById(idClub).toVO();
        return (club == null) ? new ClubVO() : club;
    }

    @RequestMapping("/getClubes")
    public List<ClubVO> getClubes() {
        List<Club> clubes = ControladorClubes.getInstancia().getClubes();
        List<ClubVO> clubesVOS = new ArrayList<>();

        if (clubes != null) {
            for (Club c : clubes) {
                clubesVOS.add(c.toVO());
            }
        }

        return clubesVOS;
    }

    @RequestMapping("/getClubesByCampeonato")
    public List<ClubVO> getClubesByCampeonato(@RequestParam(name = "idCampeonato") Integer idCampeonato) {
        List<Club> clubes = ControladorClubes.getInstancia().getClubesByCampeonato(idCampeonato);
        List<ClubVO> clubesVOS = new ArrayList<>();

        if (clubes != null) {
            for (Club c : clubes) {
                clubesVOS.add(c.toVO());
            }
        }

        return clubesVOS;
    }

    @RequestMapping("/getClubesHabilitadosPorCategoria")
    public List<ClubVO> getClubesHabiltadosPorCategoria(@RequestParam(name = "categoria") int categoria) {
        List<Club> clubes = ControladorClubes.getInstancia().getClubesHabiltadosPorCategoria(categoria);
        List<ClubVO> clubesVOS = new ArrayList<>();

        if (clubes != null) {
            for (Club c : clubes) {
                clubesVOS.add(c.toVO());
            }
        }

        return clubesVOS;
    }


}
