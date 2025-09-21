package dev.java.study.controller;

import java.util.List;

import dev.java.study.service.PassageiroService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return service.getPassageiros();
    }

    @PostMapping("/novoPassageiro")
    public ResponseEntity<Passageiro> criarPassageiro(@RequestBody Passageiro user){
        return service.criarPassageiro(user);
    }

    @PutMapping("/editarPassageiro")
    public ResponseEntity<Passageiro> editarPassageiro(@RequestBody Passageiro user){
        return service.editarPassageiro(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirUsuario(@PathVariable Integer id){
        return service.excluirPassageiro(id);
    }

}
