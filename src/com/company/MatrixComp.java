package com.company;

import java.math.BigDecimal;
import java.util.Arrays;

public class MatrixComp {
    private CompNum[][] arr;

    public MatrixComp(CompNum[][] arr) {
        this.arr = new CompNum[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++){
                this.arr[i][j] = arr[i][j].copy();
            }
        }
    }

    public MatrixComp(MatrixComp arr) {
        this.arr = new CompNum[arr.arr.length][arr.arr[0].length];
        for (int i = 0; i < arr.arr.length; i++) {
            for (int j = 0; j < arr.arr[0].length; j++){
                this.arr[i][j] = arr.arr[i][j].copy();
            }
        }
    }

    public MatrixComp(int strings_num, int columns_num) {
        this.arr = new CompNum[strings_num][columns_num];
        for (int i = 0; i < strings_num; i++) {
            for (int j = 0; j < columns_num; j++) {
                this.arr[i][j] = new CompNum(0, 0);
            }
        }
    }

    public int getN() {
        return this.arr.length;
    }

    public int getM() {
        return this.arr[0].length;
    }

    public CompNum getElem(int i, int j) {
        return this.arr[i][j];
    }

    public void setElem(int i, int j, CompNum num) {
        this.arr[i][j] = num.copy();
    }

    public MatrixComp plus(MatrixComp matrixComp) {
        if (this.arr.length != matrixComp.arr.length ||
                this.arr[0].length != matrixComp.arr[0].length){
            throw new ArithmeticException("Matrixs have not equal size");
        }
        CompNum[][] arr = new CompNum[this.arr.length][this.arr[0].length];
        for (int i = 0; i < this.arr.length; i++){
            for (int j = 0; j < this.arr[0].length; j++){
                arr[i][j] = this.arr[i][j].plus(matrixComp.arr[i][j]);
            }
        }
        return new MatrixComp(arr);
    }

    public MatrixComp minus(MatrixComp matrixComp) {
        if (this.arr.length != matrixComp.arr.length ||
                this.arr[0].length != matrixComp.arr[0].length){
            throw new ArithmeticException("Matrixs have not equal size");
        }
        CompNum[][] arr = new CompNum[this.arr.length][this.arr[0].length];
        for (int i = 0; i < this.arr.length; i++){
            for (int j = 0; j < this.arr[0].length; j++){
                arr[i][j] = this.arr[i][j].minus(matrixComp.arr[i][j]);
            }
        }
        return new MatrixComp(arr);
    }

    public MatrixComp multiply(MatrixComp matrixComp) {
        if (this.arr[0].length != matrixComp.arr.length){
            throw new ArithmeticException("First Matrix Columns Number" +
                    "must be equal Second Matrix Strings Number");
        }
        CompNum[][] arr = new CompNum[this.arr.length][this.arr[0].length];
        for (int i = 0; i < this.arr.length; i++) {
            for (int j = 0; j < this.arr[0].length; j++) {
                arr[i][j] = new CompNum(0.0, 0.0);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                for (int k = 0; k < this.arr[0].length; k++) {
                    arr[i][j] = arr[i][j].plus(this.arr[i][k].multiply(matrixComp.arr[k][j]));
                }
            }
        }
        return new MatrixComp(arr);
    }

    public MatrixComp transpose() {
        MatrixComp matrixComp = new MatrixComp(this);
        for (int i = 0; i < this.arr.length; i++) {
            for (int j = 0; j < this.arr[0].length; j++) {
                matrixComp.arr[i][j] = this.arr[j][i].copy();
            }
        }
        return matrixComp;
    }

    public CompNum findDeterminant() {
        if (this.arr.length != this.arr[0].length) {
            throw new ArithmeticException("Matrix must be square");
        } else {
            if (this.arr.length == 2){
                return this.arr[0][0].multiply(this.arr[1][1])
                        .minus(
                       this.arr[0][1].multiply(this.arr[1][0]));
            }
            else{
                CompNum sum = new CompNum(0.0, 0.0);
                for (int i = 0; i < this.arr.length; i++){
                    MatrixComp matrixNew = new MatrixComp(this.arr.length-1, this.arr.length-1);
                    int tmp_i = 0;
                    int tmp_j = 0;
                    for (int k = 1; k < this.arr.length; k++){
                        for (int l = 0; l < this.arr.length; l++){
                            if (l != i) {
                                matrixNew.arr[tmp_i][tmp_j] = this.arr[k][l].copy();
                                tmp_j += 1;
                                if (tmp_j == this.arr.length-1){
                                    tmp_i +=1;
                                    tmp_j = 0;
                                }
                            }
                        }
                    }
                    if (i % 2 == 0) {
                        sum = sum.plus(
                                this.arr[0][i].multiply(matrixNew.findDeterminant())
                        );
                    }
                    else {
                        sum = sum.minus(
                                this.arr[0][i].multiply(matrixNew.findDeterminant())
                        );
                    }
                }
                return sum;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (CompNum[] comps : this.arr) {
            result.append("[");
            for (CompNum x: comps) {
                result.append(x.toString()).append(", ");
            }
            result.replace(0, result.length(),
                    result.substring(0, result.length()-2));
            result.append("], ");
        }
        return result.substring(0, result.length()-2) + "]";
    }

    public String toText() {
        StringBuilder result = new StringBuilder("");
        for (CompNum[] comps: this.arr) {
            for (CompNum x: comps) {
                result.append(x.toString()).append(" | ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}