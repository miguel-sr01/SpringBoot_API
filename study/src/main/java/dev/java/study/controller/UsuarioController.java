package dev.java.study.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import dev.java.study.dao.IUsuario;
import dev.java.study.model.Usuario;


@RestController
public class UsuarioController {

    @Autowired
    private IUsuario crud;


    @GetMapping("/listarUsuarios")
    public List<Usuario> getUsuarios(){
        return (List<Usuario>) crud.findAll();
    }

    @PostMapping("/novoUsuario")
    public Usuario criarUsuario(@RequestBody Usuario user){
        Usuario novo_usuario = crud.save(user);
        return novo_usuario;
    }

    @PutMapping("/editarUsuario")
    public Usuario editarUsuario(@RequestBody Usuario user){
        Usuario novo_usuario = crud.save(user);
        return novo_usuario;
    }

    @DeleteMapping("/{id}")
    public Optional<Usuario> excluirUsuario(@PathVariable Integer id){
        Optional<Usuario> usuario = crud.findById(id);
        crud.deleteById(id);
        return usuario;
    }

}
