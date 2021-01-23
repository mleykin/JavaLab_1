package com.company;

import java.math.BigDecimal;
import java.util.Arrays;

public class MatrixNum {
    private double[][] arr;

    public MatrixNum(double[][] arr) {
        this.arr = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            this.arr[i] = Arrays.copyOf(arr[i], arr[i].length);
        }
    }

    public MatrixNum(MatrixNum arr) {
        this.arr = Arrays.copyOf(arr.arr, arr.arr.length);
        for (int i = 0; i < arr.arr.length; i++) {
            this.arr[i] = Arrays.copyOf(arr.arr[i], arr.arr[i].length);
        }
    }

    public MatrixNum(int strings_num, int columns_num) {
        this.arr = new double[strings_num][columns_num];
    }

    public int getN() {
        return this.arr.length;
    }

    public int getM() {
        return this.arr[0].length;
    }
    
    public double getElem(int i, int j) {
        return this.arr[i][j];
    }
    
    public void setElem(int i, int j, double num) {
        this.arr[i][j] = num;
    }

    public MatrixNum plus(MatrixNum matrixNum) {
        if (this.arr.length != matrixNum.arr.length ||
                this.arr[0].length != matrixNum.arr[0].length){
            throw new ArithmeticException("Matrixs have not equal size");
        }
        double[][] arr = new double[this.arr.length][this.arr[0].length];
        for (int i = 0; i < this.arr.length; i++){
            for (int j = 0; j < this.arr[0].length; j++){
                arr[i][j] = this.arr[i][j] + matrixNum.arr[i][j];
            }
        }
        return new MatrixNum(arr);
    }

    public MatrixNum minus(MatrixNum matrixNum) {
        if (this.arr.length != matrixNum.arr.length ||
                this.arr[0].length != matrixNum.arr[0].length){
            throw new ArithmeticException("Matrixs have not equal size");
        }
        double[][] arr = new double[this.arr.length][this.arr[0].length];
        for (int i = 0; i < this.arr.length; i++){
            for (int j = 0; j < this.arr[0].length; j++){
                arr[i][j] = this.arr[i][j] - matrixNum.arr[i][j];
            }
        }
        return new MatrixNum(arr);
    }

    public MatrixNum multiply(MatrixNum matrixNum) {
        if (this.arr[0].length != matrixNum.arr.length){
            throw new ArithmeticException("First Matrix Columns Number" +
                    "must be equal Second Matrix Strings Number");
        }
        double[][] arr = new double[this.arr.length][this.arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                for (int k = 0; k < this.arr[0].length; k++) {
                    arr[i][j] += this.arr[i][k] * matrixNum.arr[k][j];
                }
            }
        }
        return new MatrixNum(arr);
    }

    public MatrixNum transpose() {
        MatrixNum matrixNum = new MatrixNum(this);
        for (int i = 0; i < this.arr.length; i++) {
            for (int j = 0; j < this.arr[0].length; j++) {
                matrixNum.arr[i][j] = this.arr[j][i];
            }
        }
        return matrixNum;
    }

    public double findDeterminant() {
        if (this.arr.length != this.arr[0].length) {
            throw new ArithmeticException("Matrix must be square");
        } else {
            if (this.arr.length == 2){
                return this.arr[0][0]*this.arr[1][1] - this.arr[0][1]*this.arr[1][0];
            }
            else{
                int sum = 0;
                for (int i = 0; i < this.arr.length; i++){
                    MatrixNum matrixNew = new MatrixNum(this.arr.length-1, this.arr.length-1);
                    int tmp_i = 0;
                    int tmp_j = 0;
                    for (int k = 1; k < this.arr.length; k++){
                        for (int l = 0; l < this.arr.length; l++){
                            if (l != i) {
                                matrixNew.arr[tmp_i][tmp_j] = this.arr[k][l];
                                tmp_j += 1;
                                if (tmp_j == this.arr.length-1){
                                    tmp_i +=1;
                                    tmp_j = 0;
                                }
                            }
                        }
                    }
                    if (i % 2 == 0) {
                        sum += this.arr[0][i] * matrixNew.findDeterminant();
                    }
                    else {
                        sum -= this.arr[0][i] * matrixNew.findDeterminant();
                    }
                }
                return sum;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (double[] ints : this.arr) {
            result.append("[");
            for (double x: ints) {
                result.append(x).append(", ");
            }
            result.replace(0, result.length(),
                    result.substring(0, result.length()-2));
            result.append("], ");
        }
        return result.substring(0, result.length()-2) + "]";
    }

    public String toText() {
        StringBuilder result = new StringBuilder("");
        for (double[] ints: this.arr) {
            for (double x: ints) {
                result.append(x).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
