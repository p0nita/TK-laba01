package com.suai;


public class Matrix {
    protected int row;
    protected int column;
    protected int[][] element;

    public Matrix(int r, int c)
    {
        element = new int[r][c];
        row = r;
        column = c;
    }

    public void setElement(int r, int c, int value)
    {
        element[r][c] = value;
    }

    public int getElement(int r, int c)
    {
        return element[r][c];
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }


    public final boolean equals(Object m)
    {
        Matrix x = (Matrix) m;
        if ((row != x.row) | (column != x.column)) return false;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++)
                if (this.getElement(i, j) != x.getElement(i, j)) return false;
        return true;
    }

    public int minDistance(){
        int mind = Integer.MAX_VALUE;
        int curd = 0;
        for (int i = 1; i < row; i++){
            curd = 0;
            for (int j = 0; j < column; j++){
                curd += element[i][j];
            }
            if (curd < mind) mind = curd;
        }
        return mind;
    }

    public Matrix getVocabulary(){
        Matrix res = new Matrix((int)Math.pow(2, row), column);
        int tmp = 0;
        int num = 0;
        for (int i = 0; i < (int)Math.pow(2, row); i++){
            for (int j = 0; j < column; j++){
                tmp = 0;
                num = i;
                for (int k = 0; k < row; k++){
                    tmp += (num % 2) * element[k][j];
                    num /= 2;
                }
                res.setElement(i, j, tmp);
            }
        }
        res.mod2();
        return res;
    }

    public static Matrix getG(int n, int k){
        Matrix res = new Matrix(k, n);
        for (int i = 0; i < k; i++)
            res.setElement(i, i, 1);
        for (int i = k; i < n; i++){
            for (int j = 0; j < k; j++){
                res.setElement(j, i, (int)Math.round(Math.random()));
            }
        }
        return res;
    }


    public void mod2(){
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++)
                element[i][j] %= 2;
    }

    public static long factorial(int n){
        if(n <= 1 ) return 1;
        else
        return n * factorial( n - 1 );
    }

    private static long c(int a, int b){
        return factorial(b)/(factorial(a)*(factorial(b-a)));
    }

    public static double hamming (int n, int t){
        long tmp = 0;
        for (int i = 0; i <= t; i++)
            tmp += c(i, n);
        return Math.pow(2, n)/tmp;
    }

    public static double hilbert (int n, int d){
        long tmp = 0;
        for (int i = 0; i <= d-1; i++)
            tmp += c(i, n);
        return Math.pow(2, n)/tmp;
    }

    public static double singleton (int n, int d){
        return (n-d+1);
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                result.append(getElement(i, j)).append(' ');
            }
            result.append('\n');
        }
        return result.toString();
    }
}
