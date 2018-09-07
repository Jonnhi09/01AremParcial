package edu.escuelaing.arem.app;

import java.util.List;

/**
 *
 * @author Jonathan Prieto.
 */
public class App {

    private static float max, min, sumatoria, multiplicatoria;
    private static String numbersList;

    /**
     * Calculate calcula el maximo, minimo, sumatoria y multiplicatoria de un
     * conjunto de numeros, ademas pasa a formato JSON el conjunto de numeros
     * dado.
     *
     * @param numbers
     * @throws NumberFormatException
     */
    public static void calculate(String numbers) throws NumberFormatException {
        String[] setNumbers = numbers.split(",");
        max = Float.parseFloat(setNumbers[0]);
        min = Float.parseFloat(setNumbers[0]);
        sumatoria = 0f;
        multiplicatoria = 1f;
        numbersList = " \"Lista de numeros\" : \" ";
        for (String n : setNumbers) {
            float number = Float.parseFloat(n);
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
            sumatoria += number;
            multiplicatoria *= number;
            numbersList = numbersList + n + " ";
        }
        numbersList = numbersList + "\" ";
    }

    public static float getMax() {
        return max;
    }

    public static float getMin() {
        return min;
    }

    public static float getSumatoria() {
        return sumatoria;
    }

    public static float getMultiplicatoria() {
        return multiplicatoria;
    }

    public static String getNumbersList() {
        return numbersList;
    }

}
