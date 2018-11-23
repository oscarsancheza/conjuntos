package com.mcc;

public class Main {

  public static void main(String[] args) {

    Conjunto<Integer> c1 = new ConjuntoImpl<>(1, 2, 3, 4);
    Conjunto<Integer> c2 = new ConjuntoImpl<>(2, 3, 4, 5);
    Conjunto<String> c3 = new ConjuntoImpl<>("A", "B", "C");
    Conjunto<String> c4 = new ConjuntoImpl<>("A", "B", "C");

    Conjunto<Par<String, Integer>> c5 = c3.productoCartesiano(c2);
    Conjunto<Par<String, Integer>> c6 = c3.productoCartesiano(c2);

    System.out.println("c1 union c2:" + c1.union(c2));
    System.out.println("c1 interseccion c2:" + c1.interseccion(c2));
    System.out.println("c1 potencia:" + c1.potencia());
    System.out.println("c3 producto cartesiano:" + c3.productoCartesiano(c2));
    System.out.println("c3 equal c4:" + c3.equals(c4));
    System.out.println("c5 equal c6:" + c5.equals(c6));

    c2 = (Conjunto<Integer>) ((ConjuntoImpl<Integer>) c1).clone();

    System.out.println("\n----------------------------------------------------");

    System.out.println("clonacion:" + c2.toString());

    c1 = c1.union(c2);
    System.out.println("union" + c1);

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

    System.out.println("Potencia" + alumnos.potencia().toString());

    /*Conjunto<Par<Integer, String>> deepClone =
        ((ConjuntoImpl<Par<Integer, String>>) pc).deepClone();
    System.out.println("\n" + deepClone.toString());

    System.out.println(c1.equals(c2));*/

    Conjunto<Par<Integer, String>> conjuntoC = c1.productoCartesiano(alumnos);
    Conjunto<Par<Integer, String>> conjuntoC2 = c1.productoCartesiano(alumnos);
    System.out.println("Aqui deberia:" + conjuntoC.equals(conjuntoC2));

    Conjunto<Par<Integer, String>> pc =
        new ConjuntoImpl<>(1, 2, 3).productoCartesiano(new ConjuntoImpl<>("oscar", "omar"));

    Conjunto<Par<Integer, String>> pc2 =
        new ConjuntoImpl<>(1, 2, 3).productoCartesiano(new ConjuntoImpl<>("oscar", "omar"));

    System.out.println("aqui:" + pc.equals(pc2));
  }
}
