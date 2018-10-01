package com.mcc;

public interface IConjunto<T> {
  Conjunto<T> union(Conjunto<T> conjunto);

  Conjunto<T> interseccion(Conjunto<T> conjunto);
}
