package net.camionesdonerik.util;

import net.camionesdonerik.model.Pasajero;

public class PasajerosListWithArray {

    private Pasajero matrix[][];
    private int sizeRow;
    private int sizeColumn;

    public PasajerosListWithArray() {
        matrix = new Pasajero[1][1];
        sizeRow = 1;
        sizeColumn = 1;
    }
    
    public Pasajero[][] getMatrix(){
        return matrix;
    }

    public void addElement(int row, int col, Pasajero pasajero) {
        while (row >= sizeRow) {
            doubleRow(row);
        }
        while (col >= sizeColumn) {
            doubleColumn(col);
        }

        if (matrix[row][col] == null) {
            matrix[row][col] = pasajero;
        }

    }

    private void doubleRow(int row) {
        Pasajero temporalMatrix[][] = null;
        temporalMatrix = new Pasajero[sizeRow * 2][sizeColumn];

        for (int i = 0; i < sizeRow; i++) {
            for (int j = 0; j < sizeColumn; j++) {
                temporalMatrix[i][j] = matrix[i][j];
            }
        }

        matrix = temporalMatrix;
        sizeRow *= 2;
    }

    private void doubleColumn(int col) {
        Pasajero temporalMatrix[][] = null;
        temporalMatrix = new Pasajero[sizeRow][sizeColumn * 2];

        for (int i = 0; i < sizeRow; i++) {
            for (int j = 0; j < sizeColumn; j++) {
                temporalMatrix[i][j] = matrix[i][j];
            }
        }

        matrix = temporalMatrix;
        sizeColumn *= 2;
    }
    
    
}
