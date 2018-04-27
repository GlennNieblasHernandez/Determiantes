/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Glenn Nieblas H
 */
public class Controlador {
    
    private int[][] matriz;
    private int size;
    
    public Controlador() {
        
    }
    public Controlador(int size) {
        this.size = size;
        this.matriz = new int[this.size][this.size];
    }
    
    public void setValor(int posX, int posY, int valor) {
        this.matriz[posX][posY] = valor;
    }
    
    private int[][] getSubmatriz(int[][] original, int posX, int posY) {
        int size = original.length - 1;
        int[][] resultado = new int[size][size];
        int x = 0, y = 0;
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original.length; j++) {
                if (i != posX) {
                    if (j != posY) {
                        resultado[y][x] = original[i][j];                        
                        x++;
                    }
                    if (x == size) {
                        x = 0;
                        y++;
                    }
                }
            }
        }
        return resultado;
    }
    
    public int calcularDeterminante() {
        return this.calcularDeterminante(this.matriz);
    }
    
    private int calcularDeterminante(int[][] original) {
        boolean signo = true;
        int resultado = 0;
        if(original.length == 1){
            return original[0][0];
        } else {
            for (int i = 0; i < original.length; i++) {
                if(signo) {
                    resultado += original[0][i] * this.calcularDeterminante(this.getSubmatriz(original, 0, i));
                } else {
                    resultado -= original[0][i] * this.calcularDeterminante(this.getSubmatriz(original, 0, i));
                }
                signo = !signo;
            }
            return resultado;
        }
    }

    public void setSize(int size) {
        this.size = size;
        this.matriz = null;
        this.matriz = new int[this.size][this.size];
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
}

