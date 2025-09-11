package dev.java.study.service;

import dev.java.study.model.Usuario;
import dev.java.study.repository.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private IUsuario crud;

    public ResponseEntity<List<Usuario>> getUsuarios(){
        List<Usuario> lista = (List<Usuario>) crud.findAll();
        return ResponseEntity.status(200).body(lista);
    }

    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario user){
        Usuario novoUsuario = crud.save(user);
        return ResponseEntity.status(201).body(novoUsuario);
    }

    public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario user){
        Usuario novoUsuario = crud.save(user);
        return ResponseEntity.status(201).body(novoUsuario);
    }

    public ResponseEntity<?> excluirUsuario(@PathVariable Integer id){
        crud.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
