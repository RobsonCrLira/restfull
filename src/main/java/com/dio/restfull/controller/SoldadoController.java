package com.dio.restfull.controller;

import com.dio.restfull.controller.request.SoldadoEditRequest;
import com.dio.restfull.controller.response.SoldadoListResponse;
import com.dio.restfull.controller.response.SoldadoResponse;
import com.dio.restfull.dto.Soldado;
import com.dio.restfull.service.SoldadoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/soldado")
public class SoldadoController {

    private final SoldadoService soldadoService;
    private final ObjectMapper objectMapper;

    public SoldadoController(SoldadoService soldadoService, ObjectMapper objectMapper) {
        this.soldadoService = soldadoService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoldadoResponse> buscarSoldado(@PathVariable() Long id) {
        SoldadoResponse soldadoResponse = soldadoService.buscarSoldado(id);
        return ResponseEntity.status(HttpStatus.OK).body(soldadoResponse);
    }

    @PostMapping
    public ResponseEntity criarSoldado(@RequestBody Soldado soldado) {
        System.out.println("Entrou no post");
        soldadoService.criarSoldado(soldado);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity editarSoldado(@PathVariable() Long id,
                                        @RequestBody SoldadoEditRequest soldadoEditRequest) {
        soldadoService.alterarSoldado(id, soldadoEditRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarSoldado(@PathVariable Long id) {
        soldadoService.deletarSoldado(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/frente-castelo/{id}")
    public ResponseEntity frenteCastelo(@PathVariable Long id) {
        //FAZER ALGO
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Object> buscarSoldados() {
        CollectionModel<SoldadoListResponse> soldadoListResponses = soldadoService.buscarSoldados();
        return ResponseEntity.status(HttpStatus.OK).body(soldadoListResponses);
    }
}