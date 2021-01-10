package com.octodev.app;

public class VetorObject {

  private Object[] elementos;
  private int size = 0;

  public VetorObject(int qtd) {
    this.elementos = new Object[qtd];
  }

  public void add(Object elemento) throws Exception {
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

  public boolean exists(Object object) {
    for (int i = 0; i < size; i++) {
      if (elementos[i].equals(object)) {
        return true;
      }
    }
    return false;
  }

  public Object get(int position) {
    return elementos[position];
  }

  public void add(Object elemento, int position) {
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

    Object[] newVetor = new Object[newSize];
    newVetor = copyVetor(elementos, newVetor);
    elementos = newVetor;
    size = newSize;
  }

  public void del(int position) {
    if (position < 0 || position > size)
      throw new IllegalArgumentException("Posição inválida");
    for (int i = position; i < size - 1; i++) {
      elementos[position] = elementos[position + 1];
      elementos[position + 1] = null;
      position++;
    }
    elementos = copyVetor(elementos, new Object[5]);
    size = elementos.length;
  }

  private Object[] copyVetor(Object[] elementos, Object[] newVetor) {
    for (int i = 0; i < size; i++) {
      if (elementos[i] != null)
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
