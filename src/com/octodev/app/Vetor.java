package com.octodev.app;

import java.util.Arrays;

public class Vetor {

  private String[] elementos;
  private int size = 0;

  public Vetor(int qtd) {
    this.elementos = new String[qtd];
  }

  public void add(String elemento) throws Exception {
    if (size < elementos.length) {
      elementos[size] = elemento;
      size++;
    } else {
      throw new Exception("Você tentou exceder a capacidade do vetor");
    }
  }

  /**
   * Retorna o numero de elementos adicionados no array
   * @return int
   */
  public int size() {
    return size;
  }

  /**
   * Retorna o tamanho do array
   * @return int
   */
  public int length() {
    return elementos.length;
  }

  public String[] find(String text) throws IllegalArgumentException {
    
    String[] result = new String[size];
    int founded = 0;

    for (int i = 0; i < size; i++) {
      if(elementos[i].contains(text)) {
        result[founded] = elementos[i];
        founded++;
      }
    }
    if (founded <= 0)
      throw new IllegalArgumentException("Nenhum elemento foi encontrado");

    return Arrays.copyOf(result, founded);
  
  }

  public boolean exists(String text) {
    for (int i = 0; i < size; i++) {
      if(elementos[i].equals(text)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    if (size > 0) {

      sb.append("[");

      for (int i = 0; i < size - 1; i++) {
        sb.append(elementos[i]);
        sb.append(", ");
      }
      sb.append(elementos[size - 1]);
      sb.append("]");
      return sb.toString();
    } else {
      return "Array vazio";
    }


  }
}