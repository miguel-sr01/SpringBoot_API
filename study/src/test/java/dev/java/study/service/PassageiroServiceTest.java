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
    private IPassageiro jpa;


    @InjectMocks
    private PassageiroService passageiroService;

    @Test
    @DisplayName("Deve retornar uma lista e retornar o numero de cadastros")
    void deveRetornarListaPassageiros() {
        //Arrange (Preparar / Montar o cenário)
        Passageiro passageiro = new Passageiro("Miguel", "Franca", "Uberlandia");
        Mockito.when(jpa.findAll()).thenReturn(Collections.singletonList(passageiro));

        //Act (Agir / Executar)
        List <Passageiro> lista = passageiroService.getPassageiros();

        //Assert (Verificar / Afirmar)
        Assertions.assertNotNull(lista);
        Assertions.assertEquals(1, lista.size());

    }

    @Test
    @DisplayName("Deve criar um passageiro e verificar seus dados")
    void deveCriarPassageiro() {
        //Arrange (Preparar / Montar o cenário)
        Passageiro passageiro = new Passageiro("Miguel", "Franca", "Uberlandia");
        Mockito.when(jpa.save(passageiro)).thenReturn(passageiro);

        //Act (Agir / Executar)
        Passageiro novoPassageiro = passageiroService.criarPassageiro(passageiro);

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
        Mockito.when(jpa.save(passageiro)).thenReturn(passageiro);

        //Act (Agir / Executar)
        Passageiro novoPassageiro = passageiroService.editarPassageiro(passageiro);

        //Assert (Verificar / Afirmar)
        Assertions.assertNotNull(novoPassageiro);
        Assertions.assertEquals("Joao", novoPassageiro.getNome());
        Assertions.assertEquals("Franca", novoPassageiro.getOrigem());
        Assertions.assertEquals("SP", novoPassageiro.getDestino());
    }

    @Test
    @DisplayName("Deve excluir o passageiro pelo id quando ele existir")
    void deveExcluirPassageiro() throws Exception {
        Integer id = 1;

        // Arrange
        Mockito.when(jpa.existsById(id)).thenReturn(true); // Simula que o passageiro existe
        Mockito.doNothing().when(jpa).deleteById(id);

        // Act
        passageiroService.excluirPassageiro(id);

        // Assert
        // Verifica se o deleteById foi realmente chamado uma vez
        Mockito.verify(jpa, Mockito.times(1)).deleteById(id);
    }


}