/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtest;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Cuantificador de palabras.
 *
 * @author jeisonOS
 */
public class Cuant_Palabras {

    private Hashtable<String, Integer> valor_letra;
    private Hashtable<String, Integer> valor_palabra;
    public Cuant_Palabras() {
        this.valor_letra = new Hashtable<String, Integer>();
        this.valor_palabra = new Hashtable<String, Integer>();
        valor_letra.put("a", 1);
        valor_letra.put("b", 10);
        valor_letra.put("v", 11);
        valor_letra.put("c", 22);
        valor_letra.put("s", 23);
        valor_letra.put("z", 24);
        valor_letra.put("d", 34);
        valor_letra.put("e", 44);
        valor_letra.put("f", 54);
        valor_letra.put("g", 64);
        valor_letra.put("j", 65);
        valor_letra.put("h", 75);
        valor_letra.put("i", 85);
        valor_letra.put("y", 86);
        valor_letra.put("l", 96);
        valor_letra.put("m", 106);
        valor_letra.put("n", 107);
        valor_letra.put("o", 117);
        valor_letra.put("p", 127);
        valor_letra.put("q", 137);
        valor_letra.put("k", 138);
        valor_letra.put("r", 148);
        valor_letra.put("t", 158);
        valor_letra.put("u", 168);
        valor_letra.put("w", 178);
        valor_letra.put("x", 188);
        valor_letra.put("z", 198);
        valor_letra.put("r", 208);

    }

    public double asignacion_valor(ArrayList <String> palabra) {
        double valor = 0;
        double multiplicando=0.1;
        for(int e=0;e<palabra.size();e++)
        {
        for (int i = 0; i < palabra.get(e).length(); i++) {
        valor+=valor_letra.get(String.valueOf(palabra.get(e).toCharArray()[i]))*multiplicando;
        multiplicando += 0.01;
        }
        }
        multiplicando=0.1;
        return valor;
    }

}
