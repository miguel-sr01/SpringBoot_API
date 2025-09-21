package dev.java.study.service;

import dev.java.study.model.Passageiro;
import dev.java.study.repository.IPassageiro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PassageiroService {

    @Autowired
    private IPassageiro crud;

    public ResponseEntity<List<Passageiro>> getPassageiros(){
        List<Passageiro> lista = (List<Passageiro>) crud.findAll();
        return ResponseEntity.status(200).body(lista);
    }

    public ResponseEntity<Passageiro> criarPassageiro(@RequestBody Passageiro user){
        Passageiro novoPassageiro = crud.save(user);
        return ResponseEntity.status(201).body(novoPassageiro);
    }

    public ResponseEntity<Passageiro> editarPassageiro(@RequestBody Passageiro user){
        Passageiro novoPassageiro = crud.save(user);
        return ResponseEntity.status(201).body(novoPassageiro);
    }

    public ResponseEntity<?> excluirPassageiro(@PathVariable Integer id){
        crud.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
