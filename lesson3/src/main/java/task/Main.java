package task;

import task.exceptions.MyArrayDataException;
import task.exceptions.MyArraySizeException;

public class Main {
    int columnConstraint = 5;

    public static void main(String[] args) {
        int result = 0;
        try {
            result = new Main().calcSum(
                    new String[][] { { "-1", "0", "0", "0", "0" },
                            { "1", "1", "0", "0", "0" },
                            { "0", "2", "O", "0", "0" },
                            { "1", "10", "0", "0", "0" } });
        } catch (MyArraySizeException exc) {
            System.out.println(exc.getMessage());
        }
        System.out.println(result);
    }

    int calcSum(String[][] matrix) {
        verifyMatrixSize(matrix);
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                String currentValue = matrix[row][column];
                try {
                    sum += Integer.parseInt(currentValue);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            makeExceptionMessage(currentValue, row, column));
                }
            }
        }
        return sum;
    }

    private String makeExceptionMessage(Object value, int i, int j) {
        return String.format("Illegal data. Expected int, but got: {%s: "
                        + "\"%s\"} at [%d][%d]", value.getClass().getSimpleName(),
                value, i, j);
    }

    void verifyMatrixSize(String[][] matrix) throws MyArraySizeException {
        verifyNumberOfRows(matrix);
        verifyNumberOfColumns(matrix);
    }

    private void verifyNumberOfRows(String[][] matrix)
            throws MyArraySizeException {
        int rowConstraint = 4;
        if (matrix.length != rowConstraint) {
            throw new MyArraySizeException(
                    "Row quantity isn't correct. " + "Expected: "
                            + rowConstraint + " Actual: " + matrix.length);
        }
    }

    private void verifyNumberOfColumns(String[][] matrix)
            throws MyArraySizeException {
        for (int i = 0; i < matrix.length; i++) {
            String[] columns = matrix[i];
            if (columns.length != columnConstraint) {
                throw new MyArraySizeException(
                        "Column quantity isn't correct." + " " + "Expected: "
                                + columnConstraint + " Actual: "
                                + columns.length + " at the row #" + i);
            }
        }
    }
}
