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
   * 
   * @return int
   */
  public int size() {
    return size;
  }

  /**
   * Retorna o tamanho do array
   * 
   * @return int
   */
  public int length() {
    return elementos.length;
  }

  public String[] find(String text) throws IllegalArgumentException {

    String[] result = new String[size];
    int founded = 0;

    for (int i = 0; i < size; i++) {
      if (elementos[i].contains(text)) {
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
      if (elementos[i].equals(text)) {
        return true;
      }
    }
    return false;
  }

  public String get(int position) {
    return elementos[position];
  }

  public void add(String elemento, int position) {
    if (position < 0 || position > elementos.length)
      throw new IllegalArgumentException("A posição requerida está fora dos limites do vetor");

    for (int i = size; i > position; i--) {
      elementos[i] = elementos[i - 1];
    }
    elementos[position] = elemento;
    size++;
  }

  public void growTo(int newSize) {
    if (newSize < size)
      throw new IllegalArgumentException("O tamanho informado deve ser igual ou maior ao atual");
    
    String[] newVetor = new String[newSize];
    newVetor = copyVetor(elementos, newVetor);
    elementos = newVetor;
    size = newSize;
    
  }

  private String[] copyVetor(String[] elementos, String[] newVetor) {
    for (int i = 0; i < size; i++) {
      newVetor[i] = elementos[i];
    }
    return newVetor;
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