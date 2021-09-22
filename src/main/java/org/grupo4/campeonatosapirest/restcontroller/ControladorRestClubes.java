package org.grupo4.campeonatosapirest.restcontroller;

import org.grupocuatro.modelo.*;
import org.grupocuatro.controlador.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControladorRestClubes {
    @PostMapping("/crearClub")
    public void crearClub(@RequestBody Club club) {
        ControladorClubes.getInstancia().crearClub(club.getIdClub(), club.getNombre(), club.getDireccion());
    }

    @PostMapping("/modificarClub")
    public void modificarClub(@RequestParam(name = "idClub") Integer idClub,
                              @RequestParam(name = "nombre") String nombre,
                              @RequestParam(name = "direccion") String direccion) {
        ControladorClubes.getInstancia().modificarClub(idClub, nombre, direccion);
    }

    @RequestMapping("/getClubById")
    public void getClubById(@RequestParam(name = "idClub") Integer idClub ){
        ControladorClubes.getInstancia().getClubById(idClub);
    }
    @RequestMapping("/getClubes")
    public void getClubes(){
        ControladorClubes.getInstancia().getClubes();
    }
    @RequestMapping("/getClubByCampeonato")
    public void getClubByCampeonato(@RequestBody Campeonato campeonato){
        ControladorClubes.getInstancia().getClubesByCampeonato(campeonato.getIdCampeonato());
    }
    @RequestMapping("/getClubesHabiltadosPorCategoria")
    public void getClubesHabiltadosPorCategoria(@RequestParam(name = "Categoria") int categoria){
        ControladorClubes.getInstancia().getClubesHabiltadosPorCategoria(categoria);
    }



}
