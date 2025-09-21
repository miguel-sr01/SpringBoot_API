package dev.java.study.repository;


import dev.java.study.model.Passageiro;
import org.springframework.data.repository.CrudRepository;

public interface IPassageiro extends CrudRepository<Passageiro, Integer> {
    
}