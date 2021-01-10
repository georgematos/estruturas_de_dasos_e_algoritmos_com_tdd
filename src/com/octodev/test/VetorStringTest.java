package com.octodev.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.octodev.app.VetorString;

import org.junit.jupiter.api.Test;

public class VetorStringTest {

  @Test
  void deveCriarUmVetorCom5Posicoes() {
    VetorString vetor = new VetorString(5);

    assertEquals(5, vetor.length());
  }

  @Test
  void deveAdicionar3ElementosAUmVetor() {
    VetorString vetor = new VetorString(5);

    try {
      vetor.add("Ryu");
      vetor.add("Ken");
      vetor.add("Chun-li");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    assertEquals(vetor.length(), 5);
    assertEquals(vetor.size(), 3);
  }

  @Test
  void deveLancarUmaExcecaoAoTentarExcederACapacidadeDoVetor() {
    VetorString vetor = new VetorString(2);

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
  void deveRetornarUmNovoVetorComOsElementosQueCorrespondamABusca() {
    VetorString vetor = new VetorString(6);

    try {
      vetor.add("Ryu");
      vetor.add("Ken");
      vetor.add("Chun-li");
      vetor.add("Akuma");
      vetor.add("Laura");
      vetor.add("Cammy");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      assertEquals(e.getMessage(), "Você tentou exceder a capacidade do vetor");
    }

    String[] result = vetor.find("a");

    assertEquals(3, result.length);
    assertEquals("Akuma", result[0]);
    assertEquals("Laura", result[1]);
    assertEquals("Cammy", result[2]);

  }

  @Test
  void deveRetornarUmaExceptionSeNenhumElementoForEncontrado() {
    VetorString vetor = new VetorString(6);

    try {
      vetor.add("Ryu");
      vetor.add("Ken");
      vetor.add("Chun-li");
      vetor.add("Akuma");
      vetor.add("Laura");
      vetor.add("Cammy");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      assertEquals(e.getMessage(), "Você tentou exceder a capacidade do vetor");
    }

    try {
      vetor.find("f");
    } catch (IllegalArgumentException e) {
      assertEquals("Nenhum elemento foi encontrado", e.getMessage());
    }

  }

  @Test
  void deveRetornarTrueSeOElementoForEncontrado() {
    VetorString vetor = new VetorString(6);

    try {
      vetor.add("Ryu");
      vetor.add("Ken");
      vetor.add("Chun-li");
      vetor.add("Akuma");
      vetor.add("Laura");
      vetor.add("Cammy");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      assertEquals(e.getMessage(), "Você tentou exceder a capacidade do vetor");
    }

    boolean result = vetor.exists("Akuma");

    assertTrue(result);

  }

  @Test
  void deveAdicionarUmElementoAUmaDeterminadaPosicaoDoVetor() {
    VetorString vetor = new VetorString(10);

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
    VetorString vetor = new VetorString(3);

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
    VetorString vetor = new VetorString(3);

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
    VetorString vetor = new VetorString(6);

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
    VetorString vetor = new VetorString(3);

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
    VetorString vetor = new VetorString(3);

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
