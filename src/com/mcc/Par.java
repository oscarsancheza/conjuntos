package com.mcc;

public class Par<K, E> {

  private K elementoUno;
  private E elementoDos;

  public Par(K elementoUno, E elementoDos) {
    this.elementoUno = elementoUno;
    this.elementoDos = elementoDos;
  }

  @Override
  public String toString() {
    return "(" + elementoUno + "," + elementoDos + ")";
  }
}
