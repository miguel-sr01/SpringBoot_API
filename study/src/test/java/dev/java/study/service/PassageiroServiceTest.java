package dev.java.study.service;

import dev.java.study.model.Passageiro;
import dev.java.study.repository.IPassageiro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;


import java.util.Collections;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class PassageiroServiceTest {


    @Mock
    private IPassageiro crud;


    @InjectMocks
    private PassageiroService passageiroService;

    @Test
    @DisplayName("Deve retornar uma lista e retornar o numero de cadastros")
    void deveRetornarListaPassageiros() {
        //Arrange (Preparar / Montar o cenário)
        Passageiro passageiro = new Passageiro("Miguel", "Franca", "Uberlandia");
        Mockito.when(crud.findAll()).thenReturn(Collections.singletonList(passageiro));

        //Act (Agir / Executar)
        List <Passageiro> lista = passageiroService.getPassageiros().getBody();

        //Assert (Verificar / Afirmar)
        Assertions.assertNotNull(lista);
        Assertions.assertEquals(1, lista.size());

    }

    @Test
    @DisplayName("Deve criar um passageiro e verificar seus dados")
    void deveCriarPassageiro() {
        //Arrange (Preparar / Montar o cenário)
        Passageiro passageiro = new Passageiro("Miguel", "Franca", "Uberlandia");
        Mockito.when(crud.save(passageiro)).thenReturn(passageiro);

        //Act (Agir / Executar)
        Passageiro novoPassageiro = passageiroService.criarPassageiro(passageiro).getBody();

        //Assert (Verificar / Afirmar)
        Assertions.assertNotNull(novoPassageiro);
        Assertions.assertEquals("Miguel", novoPassageiro.getNome());
        Assertions.assertEquals("Franca", novoPassageiro.getOrigem());
        Assertions.assertEquals("Uberlandia", novoPassageiro.getDestino());

    }

    @Test
    void editarPassageiro() {
        //Arrange (Preparar / Montar o cenário)
        Passageiro passageiro = new Passageiro("Joao", "Franca", "SP");
        Mockito.when(crud.save(passageiro)).thenReturn(passageiro);

        //Act (Agir / Executar)
        Passageiro novoPassageiro = passageiroService.editarPassageiro(passageiro).getBody();

        //Assert (Verificar / Afirmar)
        Assertions.assertNotNull(novoPassageiro);
        Assertions.assertEquals("Joao", novoPassageiro.getNome());
        Assertions.assertEquals("Franca", novoPassageiro.getOrigem());
        Assertions.assertEquals("SP", novoPassageiro.getDestino());
    }

    @Test
    @DisplayName("Deve excluir o passageiro pelo id e mostrar o status http 204")
    void excluirPassageiro() {
        Integer id = 1;

        //Arrange (Preparar / Montar o cenário)
        // Como deleteById é void, usamos doNothing() para mockar
        Mockito.doNothing().when(crud).deleteById(id);

        //Act (Agir / Executar)
        HttpStatusCode status = passageiroService.excluirPassageiro(id).getStatusCode();

        // Assert
        Assertions.assertEquals(HttpStatus.NO_CONTENT, status);

        System.out.println(status);




    }








}