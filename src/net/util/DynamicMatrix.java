package net.util;

public class DynamicMatrix {

    private Object matrix[][];
    private int sizeRow;
    private int sizeColumn;

    public DynamicMatrix() {
        matrix = new Object[1][1];
        sizeRow = 1;
        sizeColumn = 1;
    }

    public void addElement(int row, int col, Object object) {
        while (row >= sizeRow) {
            doubleRow(row);
        }
        while (col >= sizeColumn) {
            doubleColumn(col);
        }

        if (matrix[row][col] == null) {
            matrix[row][col] = object;
        }

    }

    private void doubleRow(int row) {
        Object temporalMatrix[][] = null;
        temporalMatrix = new Object[sizeRow * 2][sizeColumn];

        for (int i = 0; i < sizeRow; i++) {
            for (int j = 0; j < sizeColumn; j++) {
                temporalMatrix[i][j] = matrix[i][j];
            }
        }

        matrix = temporalMatrix;
        sizeRow *= 2;
    }

    private void doubleColumn(int col) {
        Object temporalMatrix[][] = null;
        temporalMatrix = new Object[sizeRow][sizeColumn * 2];

        for (int i = 0; i < sizeRow; i++) {
            for (int j = 0; j < sizeColumn; j++) {
                temporalMatrix[i][j] = matrix[i][j];
            }
        }

        matrix = temporalMatrix;
        sizeColumn *= 2;
    }
}
