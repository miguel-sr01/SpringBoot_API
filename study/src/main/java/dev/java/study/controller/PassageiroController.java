package dev.java.study.controller;

import java.util.List;

import dev.java.study.service.PassageiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.java.study.model.Passageiro;


@RestController
@CrossOrigin("*")
@RequestMapping("/rodoviaria")
public class PassageiroController {

    @Autowired
    private PassageiroService service;


    @GetMapping("/listarPassageiros")
    public ResponseEntity <List<Passageiro>> getPassageiros(){
        List<Passageiro> passageiros = service.getPassageiros();
        return ResponseEntity.status(200).body(passageiros);
    }

    @PostMapping("/novoPassageiro")
    public ResponseEntity<Passageiro> criarPassageiro(@RequestBody Passageiro user){
        Passageiro novoPassageiro = service.criarPassageiro(user);
        return ResponseEntity.status(201).body(novoPassageiro);
    }

    @PutMapping("/editarPassageiro")
    public ResponseEntity<Passageiro> editarPassageiro(@RequestBody Passageiro user){
        Passageiro novoPassageiro = service.criarPassageiro(user);
        return ResponseEntity.status(201).body(novoPassageiro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirUsuario(@PathVariable Integer id) throws Exception {
        service.excluirPassageiro(id);
        return ResponseEntity.noContent().build();
    }

}
