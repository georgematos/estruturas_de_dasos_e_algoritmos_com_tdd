package com.octodev.app;

@SuppressWarnings("all")
public class VetorGeneric<T> {
  
  private T[] elementos;
  private int size = 0;
  
  public VetorGeneric(int qtd) {
    this.elementos = (T[]) new Object[qtd];
  }

  public void add(T elemento) throws Exception {
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

  public boolean exists(T T) {
    for (int i = 0; i < size; i++) {
      if (elementos[i].equals(T)) {
        return true;
      }
    }
    return false;
  }

  public T get(int position) {
    return elementos[position];
  }

  public void add(T elemento, int position) {
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

    T[] newVetor = (T[]) new Object[newSize];
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
    elementos = copyVetor(elementos, (T[]) new Object[position]);
    size = elementos.length;
  }

  private T[] copyVetor(T[] elementos, T[] newVetor) {
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
