package com.octodev.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.octodev.app.VetorObject;

import org.junit.jupiter.api.Test;

public class VetorObjectTest {

  @Test
  void deveCriarUmVetorCom5Posicoes() {
    VetorObject vetor = new VetorObject(5);

    assertEquals(5, vetor.length());
  }

  @Test
  void deveAdicionar3ElementosAUmVetor() {
    VetorObject vetor = new VetorObject(5);

    try {
      vetor.add(1);
      vetor.add(0.023);
      vetor.add("Chun-li");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    assertEquals(vetor.length(), 5);
    assertEquals(vetor.size(), 3);
  }

  @Test
  void deveLancarUmaExcecaoAoTentarExcederACapacidadeDoVetor() {
    VetorObject vetor = new VetorObject(2);

    try {
      vetor.add("Ryu");
      vetor.add("Ken");
      vetor.add("Chun-li");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      assertEquals(e.getMessage(), "Você tentou exceder a capacidade do vetor");
    }

  }

  @Test
  void deveRetornarTrueSeOElementoForEncontrado() {
    VetorObject vetor = new VetorObject(6);

    try {
      vetor.add("Ryu");
      vetor.add("Ken");
      vetor.add("Chun-li");
      vetor.add(10);
      vetor.add("Laura");
      vetor.add("Cammy");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      assertEquals(e.getMessage(), "Você tentou exceder a capacidade do vetor");
    }

    boolean result = vetor.exists(10);
    boolean result2 = vetor.exists("Laura");

    assertTrue(result);
    assertTrue(result2);

  }

  @Test
  void deveAdicionarUmElementoAUmaDeterminadaPosicaoDoVetor() {
    VetorObject vetor = new VetorObject(10);

    try {
      vetor.add("Ryu");
      vetor.add("Ken");
      vetor.add("Chun-li");
      vetor.add("Akuma");
      vetor.add("Laura");

      vetor.add("Cammy", 2);
      vetor.add("Bison", 4);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      assertEquals(e.getMessage(), "Você tentou exceder a capacidade do vetor");
    }
    assertEquals("Ryu", vetor.get(0));
    assertEquals("Cammy", vetor.get(2));
    assertEquals("Bison", vetor.get(4));
    assertEquals("Laura", vetor.get(6));

  }

  @Test
  void deveLancarUmaExcecaoSeONovoTamanhoForMenorOuIgualAoAntigo() {
    VetorObject vetor = new VetorObject(3);

    try {
      vetor.add("Ryu");
      vetor.add("Ken");
      vetor.add("Chun-li");

      vetor.growTo(2);

      vetor.add("Akuma");
      vetor.add("Laura");
      vetor.add("Cammy");

    } catch (Exception e) {
      System.out.println(e.getMessage());
      
      assertEquals("O tamanho informado deve ser igual ou maior ao atual", e.getMessage());
    }

  }

  @Test
  void deveAumentarACapacidadeDoVetor() {
    VetorObject vetor = new VetorObject(3);

    try {
      vetor.add("Ryu");
      vetor.add("Ken");
      vetor.add("Chun-li");

      vetor.growTo(6);

      vetor.add("Akuma");
      vetor.add("Laura");
      vetor.add("Cammy");

    } catch (Exception e) {
      System.out.println(e.getMessage());
      assertEquals("Você tentou exceder a capacidade do vetor", e.getMessage());
    }

    assertEquals(6, vetor.size());
  }

  @Test
  void deveRemoverUmElementoDeUmaPosicaoDoVetor() {
    VetorObject vetor = new VetorObject(6);

    try {
      vetor.add("Ryu");
      vetor.add("Ken");
      vetor.add("Chun-li");
      vetor.add("Akuma");
      vetor.add("Laura");
      vetor.add("Sakura");

      vetor.del(3);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      assertEquals(e.getMessage(), "Você tentou exceder a capacidade do vetor");
    }

    assertEquals(5, vetor.size());
    assertEquals("Laura", vetor.get(3));
  }

  @Test
  void deveLancarUmaIllegalArgExcpSeAPosicaoPassadaForMaiorTamanho() {
    VetorObject vetor = new VetorObject(3);

    try {
      vetor.add("Ryu");
      vetor.add("Ken");
      vetor.add("Chun-li");

      vetor.del(4);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      assertEquals(e.getMessage(), "Posição inválida");
    }
  }

  @Test
  void deveLancarUmaIllegalArgExcpSeAPosicaoPassadaForMenorQueTamanho() {
    VetorObject vetor = new VetorObject(3);

    try {
      vetor.add("Ryu");
      vetor.add("Ken");
      vetor.add("Chun-li");

      vetor.del(-1);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      assertEquals(e.getMessage(), "Posição inválida");
    }
  }
}
