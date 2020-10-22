package com.matrix.java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Input rows: ");
            int row = in.nextInt();
            System.out.println("Input cols: ");
            int col = in.nextInt();
            matrix = new Matrix(row, col);
        }
        catch (InputMismatchException ex){
            System.out.println("Incorrect input: an integer is required");
        }
        catch (Matrix.SizeMatrixException ex){
            System.out.println(ex.getInfo());
        }
        matrix.initMatrixWithRandomValue(-5, 15);
        matrix.printMatrix();
    }
}
