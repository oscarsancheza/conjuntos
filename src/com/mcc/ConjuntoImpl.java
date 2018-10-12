package com.mcc;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ConjuntoImpl<T> implements Conjunto<T>, Cloneable {

  private Set<T> elementos;

  public ConjuntoImpl() {
    elementos = new HashSet<>();
  }

  public ConjuntoImpl(Collection<T> elementos) {
    if (elementos == null) {
      throw new NullPointerException("La colección no debe ser nula");
    }

    this.elementos = new HashSet<>();
    for (T item : elementos) {
      this.elementos.add(item);
    }
  }

  public ConjuntoImpl(T... elementos) {
    if (elementos == null) {
      throw new NullPointerException("La colección no debe ser nula");
    }

    this.elementos = new HashSet<>();
    for (T item : elementos) {
      this.elementos.add(item);
    }
  }

  @Override
  public boolean contains(T elemento) {
    return this.elementos.contains(elemento);
  }

  @Override
  public int size() {
    return this.elementos.size();
  }

  @Override
  public boolean isEmpty() {
    return this.elementos.isEmpty();
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public String toString() {
    String elementos = this.elementos.toString().replaceAll("\\[", "{");
    elementos = elementos.replaceAll("]", "}");
    return elementos;
  }

  @Override
  public Conjunto<T> union(Conjunto<T> conjunto) {
    Set<T> unionConjuntos = new HashSet<>();
    if (conjunto != null) {
      unionConjuntos.addAll(conjunto.getElementos());
    }
    unionConjuntos.addAll(this.elementos);

    return new ConjuntoImpl<>(unionConjuntos);
  }

  @Override
  public Conjunto<T> interseccion(Conjunto<T> conjunto) {
    Set<T> interseccionConjuntos = new HashSet<>();

    for (T item : conjunto.getElementos()) {
      if (this.elementos.contains(item)) {
        interseccionConjuntos.add(item);
      }
    }

    return new ConjuntoImpl<>(interseccionConjuntos);
  }

  @Override
  public Conjunto<T> diferencia(Conjunto<T> conjunto) {
    Set<T> diferenciaConjuntos = new HashSet<>(this.elementos);

    diferenciaConjuntos.removeAll(conjunto.getElementos());

    return new ConjuntoImpl<>(diferenciaConjuntos);
  }

  @Override
  public boolean subConjunto(Conjunto<T> conjunto) {
    return conjunto.getElementos().containsAll(this.elementos);
  }

  @Override
  public boolean subConjuntoPropio(Conjunto<T> conjunto) {
    return (conjunto.size() < this.size() && subConjunto(conjunto));
  }

  @Override
  public Conjunto<T> complemento(Conjunto<T> conjunto) {
    return conjunto.diferencia(this);
  }

  @SuppressWarnings("unchecked")
  @Override
  public ConjuntoImpl<T> clone() {
    ConjuntoImpl<T> conjunto;
    try {
      conjunto = (ConjuntoImpl<T>) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException("Clone not supported");
    }
    return conjunto;
  }

  public Set<T> getElementos() {
    return elementos;
  }

  public void setElementos(Set<T> elementos) {
    this.elementos = elementos;
  }

  @Override
  public <E> Conjunto<Par<T, E>> productoCartesiano(Conjunto<E> conjunto) {

    Set<Par<T, E>> elementos = new HashSet<>();
    Par<T, E> par;

    for (T key : this.elementos) {
      for (E valor : conjunto.getElementos()) {
        par = new Par<>(key, valor);
        elementos.add(par);
      }
    }

    return new ConjuntoImpl<>(elementos);
  }

  @Override
  public Conjunto<Set<T>> potencia() {
    Set<Set<T>> resultado = new HashSet<>();
    resultado.add(new HashSet<>());
    Set<T> subconjunto;
    Set<Set<T>> previousSets;

    for (T item : this.elementos) {
      previousSets = new HashSet<>(resultado);
      for (Set<T> subSet : previousSets) {
        subconjunto = new HashSet<>(subSet);
        subconjunto.add(item);
        resultado.add(subconjunto);
      }
    }
    return new ConjuntoImpl<>(resultado);
  }
}