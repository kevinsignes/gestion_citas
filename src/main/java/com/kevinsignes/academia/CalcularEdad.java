package com.kevinsignes.academia;

import java.time.LocalDate;
import java.time.Period;
public class CalcularEdad {
    public static int calcularEdad(String fechaNacimiento) {
        String[] partesFecha = fechaNacimiento.split("/");
        int dia = Integer.parseInt(partesFecha[0]);
        int mes = Integer.parseInt(partesFecha[1]);
        int anio = Integer.parseInt(partesFecha[2]);

        LocalDate fechaNac = LocalDate.of(anio, mes, dia);
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNac, fechaActual);

        return periodo.getYears();
    }
}
