package org.grupo4.campeonatosapirest.restcontroller;

import org.grupocuatro.controlador.ControladorCampeonatos;
import org.grupocuatro.modelo.Campeonato;
import org.grupocuatro.vo.CampeonatoVO;
import org.grupocuatro.vo.ClubesCampeonatoVO;
import org.springframework.web.bind.annotation.*;

import javax.naming.ldap.Control;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ControladorRestCampeonatos {

    @PostMapping("/crearCampeonato")
    public void crearCampeonato(@RequestBody CampeonatoVO camp) {
        ControladorCampeonatos.getInstancia().crearCampeonato(camp.getDescripcion(), camp.getFechaInicio(), camp.getFechaFin(), camp.getEstado());
    }

    @PostMapping("/definirTipoCampeonatoAndCategoria")
    public void definirTipoCampeonatoAndCategoria(@RequestParam(name = "cantidadZonas") int cantidadZonas,
                                                  @RequestParam(name = "idCampeonatos") Integer idCampeonato,
                                                  @RequestParam(name = "categoria") int categoria) {

        ControladorCampeonatos.getInstancia().definirTipoCampeonatoAndCategoria(cantidadZonas, idCampeonato, categoria);

    }

    @PostMapping("/terminarCampeonato")
    public void terminarCampeonato(@RequestParam(name = "idCampeonato") Integer idCampeonato) {
        ControladorCampeonatos.getInstancia().terminarCampeonato(idCampeonato);
    }

    @RequestMapping("/encontrarCampeonato")
    public CampeonatoVO encontrarCampeonato(@RequestParam(name = "idCampeonato") Integer idCampeonato) {
        CampeonatoVO result = ControladorCampeonatos.getInstancia().encontrarCampeonato(idCampeonato).toVO();
        if (result != null)
            return result;
        return new CampeonatoVO();
    }

    @RequestMapping("/getCampeonatos")
    public List<CampeonatoVO> getCampeonatos() {
        List<Campeonato> lista = ControladorCampeonatos.getInstancia().getCampeonatos();
        List<CampeonatoVO> result = new ArrayList<>();
        for (Campeonato camp : lista) {
            result.add(camp.toVO());
        }
        return result;
    }

    @RequestMapping("/getCampeonatosByEstado")
    public List<CampeonatoVO> getCampeonatosByEstado(@RequestParam(name = "estado") String estado) {
        List<Campeonato> lista = ControladorCampeonatos.getInstancia().getCampeonatosByEstado(estado);
        List<CampeonatoVO> result = new ArrayList<>();
        for (Campeonato camp : lista) {
            result.add(camp.toVO());
        }
        return result;
    }

    @PostMapping("/agregarClubACampeonato")
    public void agregarClubACampeonato(@RequestBody ClubesCampeonatoVO clubCampeonato) {
        //Aclaracion: como el atributo de idClub de club campeonato guarda la instancia del club en lugar de solo el id, es por eso que se llama al getId del club para obtener el Integer, lo mismo ocurre con el campeonato
        ControladorCampeonatos.getInstancia().agregarClubACampeonato(clubCampeonato.getIdClub().getIdClub(), clubCampeonato.getIdCampeonato().getIdCampeonato());
    }

    @RequestMapping("/getCampeonatosByClub")
    public List<CampeonatoVO> getCampeonatosByClub(@RequestParam(name = "idClub") Integer idClub) {
        List<Campeonato> lista = ControladorCampeonatos.getInstancia().getCampeonatosByClub(idClub);
        List<CampeonatoVO> result = new ArrayList<>();
        for (Campeonato camp : lista) {
            result.add(camp.toVO());
        }
        return result;
    }
}
