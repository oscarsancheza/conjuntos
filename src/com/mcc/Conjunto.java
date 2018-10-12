package com.mcc;

import java.util.Set;

public interface Conjunto<T> {

  Conjunto<T> union(Conjunto<T> conjunto);

  Conjunto<T> interseccion(Conjunto<T> conjunto);

  Conjunto<T> diferencia(Conjunto<T> conjunto);

  boolean subConjunto(Conjunto<T> conjunto);

  boolean subConjuntoPropio(Conjunto<T> conjunto);

  Conjunto<T> complemento(Conjunto<T> conjunto);

  boolean contains(T elemento);

  int size();

  boolean isEmpty();

  Set<T> getElementos();

  void setElementos(Set<T> elementos);

  <E> Conjunto<Par<T,E>> productoCartesiano(Conjunto<E> conjunto);

  Conjunto<Set<T>> potencia();
}
