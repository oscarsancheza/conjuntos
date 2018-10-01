package com.mcc;

public class Main {

  public static void main(String[] args) {
    Conjunto<Integer> c1 = new Conjunto<>(1, 2, 3, 4, 5, 6);
    Conjunto<Integer> c2 = new Conjunto<>(1, 2, 3,7);
    c1 = c1.union(c2);

    System.out.println(c1.toString());
  }
}
