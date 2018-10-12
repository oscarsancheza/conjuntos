package com.mcc;

public class Main {

  public static void main(String[] args) {

    Conjunto<Integer> c1 = new ConjuntoImpl<>(1, 2, 3, 4, 5, 6);
    Conjunto<Integer> c2 = new ConjuntoImpl<>(1, 2, 3, 7, 10);

    Conjunto<Integer> c3 = ((ConjuntoImpl<Integer>) c1).clone();

    System.out.println("clonacion:" + c3.toString());

    c1 = c1.union(c2);
    System.out.println("union" + c1.toString());

    Conjunto<String> alumnos = new ConjuntoImpl<>("oscar", "omar", "minerva");
    ConjuntoImpl<String> maestros = new ConjuntoImpl<>("oscar", "jose", "minerva", "pedro");

    Conjunto<String> interseccion = alumnos.interseccion(maestros);
    System.out.println("interseccion:" + interseccion);

    System.out.println("diferencia:" + alumnos.diferencia(maestros).toString());
    System.out.println("complemento:" + alumnos.complemento(maestros).toString());

    Conjunto<Integer> cDiff = new ConjuntoImpl<>(1, 2, 3, 4);
    Conjunto<Integer> cDiffDos = new ConjuntoImpl<>(1, 2, 3, 4, 5);

    System.out.println(
        "Subconjunto" + cDiff.toString() + " de " + cDiffDos + ": " + cDiffDos.subConjunto(cDiff));

    System.out.println(
        "Subconjunto Propio"
            + cDiff.toString()
            + " de "
            + cDiffDos
            + ": "
            + cDiffDos.subConjuntoPropio(cDiff));

    Conjunto<Par<Integer, String>> algo = new ConjuntoImpl<>(1,2,3).productoCartesiano(new ConjuntoImpl<>("oscar","omar"));
    System.out.print(algo.toString());

    alumnos.potencia();

  }
}
