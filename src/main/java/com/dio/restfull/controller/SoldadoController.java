package com.dio.restfull.controller;

import com.dio.restfull.controller.request.SoldadoEditRequest;
import com.dio.restfull.dto.Soldado;
import com.dio.restfull.service.SoldadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/soldado")
public class SoldadoController {

    private final SoldadoService soldadoService;

    public SoldadoController (SoldadoService soldadoService) {
        this.soldadoService = soldadoService;
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Soldado> buscarSoldado(@PathVariable() String cpf){
        Soldado soldado = soldadoService.buscarSoldado(cpf);
        return ResponseEntity.status(HttpStatus.OK).body(soldado);
    }

    @PostMapping
    public ResponseEntity criarSoldado( Soldado soldado){
        soldadoService.criarSoldado(soldado);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{cpf}")
    public ResponseEntity editarSoldado(SoldadoEditRequest soldadoEditRequest, @PathVariable() String cpf){
        soldadoService.alterarSoldado(cpf,soldadoEditRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity deleteSoldado(@PathVariable() String cpf){
        soldadoService.deletarSoldado(cpf);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Soldado>> buscarSoldado(){
        List<Soldado> soldado = soldadoService.buscarSoldados();
        return ResponseEntity.status(HttpStatus.OK).body(soldado);
    }
}
