/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.GridLayout;
import java.text.NumberFormat;
import javax.swing.*;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Glenn Nieblas H
 */
public class MatrizPanel extends JPanel {

    private GridLayout layoutMatriz;
    private JFormattedTextField[][] txtCeldas;
    private int size;

    public MatrizPanel(int size) {
        super();
        this.size = size;
        this.layoutMatriz = new GridLayout(this.size, this.size);
        this.setLayout(layoutMatriz);
        this.txtCeldas = new JFormattedTextField[size][size];
        NumberFormat formato = NumberFormat.getInstance();
        formato.setGroupingUsed(false);
        NumberFormatter formatter = new NumberFormatter(formato);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(Integer.MIN_VALUE);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        for (int i = 0; i < txtCeldas.length; i++) {
            for (int j = 0; j < txtCeldas.length; j++) {
                this.txtCeldas[i][j] = new JFormattedTextField(formatter);
                this.txtCeldas[i][j].setColumns(4);
                super.add(txtCeldas[i][j]);
            }
        }
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[][] getValores() {
        int [][] resultado = new int[txtCeldas.length] [txtCeldas.length];
        for (int i = 0; i < txtCeldas.length; i++) {
            for (int j = 0; j < txtCeldas.length; j++) {
                resultado[i][j] = Integer.valueOf(txtCeldas[i][j].getText());
            }
        }
        return resultado;
    }
}
