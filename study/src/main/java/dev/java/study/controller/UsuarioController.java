package dev.java.study.controller;

import java.util.List;

import dev.java.study.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.java.study.model.Usuario;


@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;


    @GetMapping("/listarUsuarios")
    public ResponseEntity <List<Usuario>> getUsuarios(){
        return service.getUsuarios();
    }

    @PostMapping("/novoUsuario")
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario user){
        return service.criarUsuario(user);
    }

    @PutMapping("/editarUsuario")
    public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario user){
        return service.editarUsuario(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirUsuario(@PathVariable Integer id){
        return service.excluirUsuario(id);
    }

}
