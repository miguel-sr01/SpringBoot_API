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
    private IPassageiro jpa;

    public List<Passageiro> getPassageiros() {
        return jpa.findAll();
    }

    public Passageiro criarPassageiro(Passageiro user){
        return jpa.save(user);
    }

    public Passageiro editarPassageiro(Passageiro user){
        return jpa.save(user);
    }

    public void excluirPassageiro(Integer id) throws Exception {
        if (!jpa.existsById(id)){
            throw new Exception("Passageiro não encontrado!");
        }
        jpa.deleteById(id);
    }
}
