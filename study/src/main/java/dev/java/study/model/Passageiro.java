package dev.java.study.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "passageiro")
public class Passageiro {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length=200, nullable=true)
    private String nome;

    @Column(name = "origem", length=100, nullable=true)
    private String origem;

    @Column(name = "destino", length=50, nullable=true)
    private String destino;

    @Column(name = "horario", columnDefinition="TEXT", nullable=true)
    private String horario;

    @Column(name = "plataforma", length=15, nullable=true)
    private String plataforma;

    public Passageiro(String nome, String origem, String destino) {
        this.nome = nome;
        this.origem = origem;
        this.destino = destino;
    }

    public Passageiro(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
}