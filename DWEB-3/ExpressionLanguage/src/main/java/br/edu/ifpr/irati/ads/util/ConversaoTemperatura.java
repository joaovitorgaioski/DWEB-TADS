package br.edu.ifpr.irati.ads.util;

public class ConversaoTemperatura {

    public static double celsiusParaFahrenheit(double c) {
        return (c * 1.8) + 32;
    }

    public static double celsiusParaKelvin(double c) {
        return c + 273.15;
    }
}
