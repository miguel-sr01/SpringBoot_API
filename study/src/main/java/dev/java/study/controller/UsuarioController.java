package dev.java.study.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.java.study.dao.IUsuario;
import dev.java.study.model.Usuario;


@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuario crud;


    @GetMapping("/listarUsuarios")
    public ResponseEntity <List<Usuario>> getUsuarios(){
        List<Usuario> lista = (List<Usuario>) crud.findAll();
        return ResponseEntity.status(200).body(lista);
    }

    @PostMapping("/novoUsuario")
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario user){
        Usuario novoUsuario = crud.save(user);
        return ResponseEntity.status(201).body(novoUsuario);
    }

    @PutMapping("/editarUsuario")
    public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario user){
        Usuario novoUsuario = crud.save(user);
        return ResponseEntity.status(201).body(novoUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirUsuario(@PathVariable Integer id){
        crud.deleteById(id);
        return ResponseEntity.status(204).build();
    }

}
