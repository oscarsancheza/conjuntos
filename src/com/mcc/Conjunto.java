package com.mcc;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Conjunto<T> implements IConjunto<T> {

  private Set<T> elementos;

  public Conjunto() {
    elementos = new HashSet<>();
  }

  public Conjunto(Collection<T> elementos) {
    if (elementos == null) {
      throw new NullPointerException("La colección no debe ser nula");
    }

    this.elementos = new HashSet<>();
    for (T item : elementos) {
      this.elementos.add(item);
    }
  }

  public Conjunto(T... elementos) {
    if (elementos == null) {
      throw new NullPointerException("La colección no debe ser nula");
    }

    this.elementos = new HashSet<>();
    for (T item : elementos) {
      this.elementos.add(item);
    }
  }

  public int size() {
    return 0;
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public String toString() {
    return elementos.toString();
  }

  public Set<T> getElementos() {
    return elementos;
  }

  public void setElementos(Set<T> elementos) {
    this.elementos = elementos;
  }

  @Override
  public Conjunto<T> union(Conjunto<T> conjunto) {
    Set<T> unionConjuntos = new HashSet<>();
    if (conjunto != null) {
      unionConjuntos.addAll(conjunto.getElementos());
    }
    unionConjuntos.addAll(this.elementos);

    return new Conjunto<>(unionConjuntos);
  }

  @Override
  public Conjunto<T> interseccion(Conjunto<T> conjunto) {
    return null;
  }
}
