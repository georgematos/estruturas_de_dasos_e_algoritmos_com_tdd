package com.octodev.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.octodev.app.VetorGeneric;

import org.junit.jupiter.api.Test;

public class VetorGenericTest {

  @Test
  void deveCriarUmVetorCom5Posicoes() {
    VetorGeneric<String> vetor = new VetorGeneric<String>(5);

    assertEquals(5, vetor.length());
  }

  @Test
  void deveAdicionar3ElementosAUmVetor() {
    VetorGeneric<String> vetor = new VetorGeneric<String>(5);

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
    VetorGeneric<String> vetor = new VetorGeneric<String>(2);

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
    VetorGeneric<String> vetor = new VetorGeneric<String>(6);

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
    boolean result2 = vetor.exists("Laura");

    assertTrue(result);
    assertTrue(result2);

  }

  @Test
  void deveAdicionarUmElementoAUmaDeterminadaPosicaoDoVetor() {
    VetorGeneric<String> vetor = new VetorGeneric<String>(10);

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
    VetorGeneric<String> vetor = new VetorGeneric<String>(3);

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
    VetorGeneric<String> vetor = new VetorGeneric<String>(3);

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
    VetorGeneric<String> vetor = new VetorGeneric<String>(6);

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
    VetorGeneric<String> vetor = new VetorGeneric<String>(3);

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
    VetorGeneric<String> vetor = new VetorGeneric<String>(3);

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
