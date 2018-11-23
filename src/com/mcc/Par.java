package com.mcc;

import java.util.Objects;

public class Par<K, E> implements Cloneable {

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

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj instanceof Par) {
      Par<?, ?> e = (Par<?, ?>) obj;
      return Objects.equals(elementoUno, e.getElementoUno())
          && Objects.equals(elementoDos, e.getElementoDos());
    }
    return false;
  }

  @Override
  public Object clone() {
    Par<K, E> result;
    try {
      result = (Par<K, E>) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new InternalError(e);
    }
    return result;
  }

  public K getElementoUno() {
    return elementoUno;
  }

  public E getElementoDos() {
    return elementoDos;
  }
}
