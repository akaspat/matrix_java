package com.matrix.java;

public class Matrix {
    private int[][] matrix;
    private int rows;
    private int cols;

    private int maxSize;
    private int minSize;

    Matrix(){
        minSize = 3; maxSize = 10;
        matrix = new int[minSize][minSize];
    }

    Matrix(int _rows, int _cols) throws SizeMatrixException {
        if (checkSize(_rows) && checkSize(_cols)) {
            matrix = new int[_rows][_cols];
            rows = _rows;
            cols = _cols;
        } else throw new SizeMatrixException("size matrix error: type number between [3, 10]");
    }

    public void initMatrixWithRandomValue(int minValue, int maxValue){
        int randValue;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                randValue = (int) ((Math.random() * ((maxValue - minValue) + 1)) + minValue);
                matrix[r][c] = randValue;
            }
        }
    }

    public void printMatrix(){
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++)
                System.out.print(matrix[r][c] + "\t");
            System.out.println();
        }
    }

    public int getElementByIndex(int i, int j) {
        if ( i > 0 && j > 0 && i < matrix.length && j < matrix[i].length )
            return matrix[i][j];
        else return -1;
    }

    public void setElementByIndex(int i, int j, int val) throws SizeMatrixException{
        if ( i > 0 && j > 0 && i < matrix.length && j < matrix[i].length )
            matrix[i][j] = val;
        else throw new SizeMatrixException("size matrix error: out of index");
    }
    

    private boolean checkSize(int _size){
        return !((_size >= minSize) && (_size <= maxSize));
    }

    public class SizeMatrixException extends Exception{
        private String info;
        private int code;

        SizeMatrixException(String message){
            info = message;
            code = 1;
        }

        public String getInfo(){ return info; }
        public int getCode(){ return code; }
    }
}
