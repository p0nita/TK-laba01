package com.suai;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n = 5;
        Matrix test = Matrix.getG(n, 3);
        Matrix vocab = test.getVocabulary();
        Matrix h = test.getH();
        Matrix ht = h.transpon();
        Matrix word = new Matrix(1, n);
        Matrix check;
        int d = vocab.minD();
        System.out.println("G = \n" + test);
        System.out.println("Vocabulary = \n" + vocab);
        System.out.println("d = " + d);
        int t = (d - 1) / 2;
        System.out.println("t = " + t);
        System.out.println("\nH = \n" + h);
        System.out.println("Ht = \n" + ht);
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < n; j++){
                word.setElement(0, j, (int)Math.round(Math.random()));
            }
            check = word.product(ht);
            System.out.println("WORD = \n" + word + (check.isNull() ? "in vocabulary" : "doesn't exist") + "\n");
        }
        //     Scanner scanner = new Scanner(System.in);
        //     word = new Matrix(scanner.nextLine());
        //     check = word.product(ht);
        //     System.out.println("WORD = \n" + word + (check.isNull() ? "in vocabulary" : "doesn't exist") + "\n");

        System.out.println(Matrix.hamming(n, t));
        System.out.println(Matrix.hilbert(n, d));
        System.out.println(Matrix.singletone(n, d));
    }
}