package com.octodev.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.octodev.app.Vetor;

import org.junit.jupiter.api.Test;

public class VetorTest {

  @Test
  void deveCriarUmVetorCom5Posicoes() {
    Vetor vetor = new Vetor(5);

    assertEquals(5, vetor.length());
  }

  @Test
  void deveAdicionar3ElementosAUmVetor() {
    Vetor vetor = new Vetor(5);

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
    Vetor vetor = new Vetor(2);

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
    Vetor vetor = new Vetor(6);

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
    Vetor vetor = new Vetor(6);

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
    Vetor vetor = new Vetor(6);

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
    Vetor vetor = new Vetor(10);

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

}
