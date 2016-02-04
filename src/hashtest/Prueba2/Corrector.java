/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtest.Prueba2;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jeisonOS
 */
public class Corrector {

    ArrayList<String> patrones;

    public ArrayList <String> comparar(String palabra, int precision, boolean print) throws ClassNotFoundException, SQLException {

        int tamano_palabra = palabra.length();
        int numero_combinaciones = tamano_palabra - 1;
        ArrayList<String> combinaciones = new ArrayList<>();
        for (int i = 0; i < numero_combinaciones; i++) {
            combinaciones.add(
                    String.valueOf(palabra.toCharArray()[i])
                    + String.valueOf(palabra.toCharArray()[i + 1])
            );
        }
        DB_Controller tool = new DB_Controller();
        ArrayList<ArrayList<String>> resultados_combinaciones = new ArrayList<>();
        for (int i = 0; i < numero_combinaciones; i++) {
            resultados_combinaciones.add(tool.getConsultaPalabras("SELECT palabra FROM Diccionario WHERE palabra LIKE '%" + combinaciones.get(i) + "%'"));
        }

        ArrayList<String> patrones_Izquierda_a_Derecha = new ArrayList<>();
        String patron = "";
        int maximoPatron = 0;
        int inicioPatron = -1;
        int finalPatron = -1;
        for (int h = 0; h < palabra.length(); h++) {

            for (int i = h; i < palabra.length(); i++) {

                patron += String.valueOf(palabra.toCharArray()[i]);
                //System.out.println(patron);
                for (int j = 0; j < resultados_combinaciones.size(); j++) {

                    for (int k = 0; k < resultados_combinaciones.get(j).size(); k++) {

                        boolean tmp = resultados_combinaciones.get(j).get(k).contains(patron);
                        
                        if (tmp) {
                            if (maximoPatron < patron.length()) {
                                maximoPatron = patron.length();
                                inicioPatron = h;
                                finalPatron = i;
                            }
                        }
                    }

                }

            }
            
            patron = "";
        }

        //patron = "";
        for (int i = inicioPatron; i < finalPatron+1; i++) {
            patron += String.valueOf(palabra.toCharArray()[i]);
            
        }
        
        for (int j = 0; j < resultados_combinaciones.size(); j++) {

            for (int k = 0; k < resultados_combinaciones.get(j).size(); k++) {

                boolean tmp = resultados_combinaciones.get(j).get(k).contains(patron);
                if (tmp) {
                    
                    patrones_Izquierda_a_Derecha.add(resultados_combinaciones.get(j).get(k));
                }
            }

        }
        
        //Filtro de tolerancia
        ArrayList <String> aproximaciones = new ArrayList <>();
        int tolerancia = precision;
        if (tolerancia == -1) {
            tolerancia = 1;
        }


        if (precision == -1) {

            while (aproximaciones.isEmpty()) {

                for (int i = 0; i < patrones_Izquierda_a_Derecha.size(); i++) {

                    if (patrones_Izquierda_a_Derecha.get(i).length() <= patron.length() + tolerancia) {
                        aproximaciones.add(patrones_Izquierda_a_Derecha.get(i));
                    }

                }
                tolerancia++;

            }

        } else {

            for (int i = 0; i < patrones_Izquierda_a_Derecha.size(); i++) {

                if (patrones_Izquierda_a_Derecha.get(i).length() <= patron.length() + tolerancia) {
                    aproximaciones.add(patrones_Izquierda_a_Derecha.get(i));
                }

            }

        }
        
        if ((print)&&(precision == -1)){
            System.out.println("Patron maximo:" + maximoPatron + " " + patron + " :: I " + inicioPatron + " F " + finalPatron + " :: Nivel de precision " + (tolerancia-1));
        } 
        
        if ((print)&&(precision != -1)){
            System.out.println("Patron maximo:" + maximoPatron + " " + patron + " :: I " + inicioPatron + " F " + finalPatron + " :: Nivel de precision " + tolerancia);
        } 

        ArrayList<String> aproximaciones_sin_repetir = new ArrayList<>();
        //System.out.println(aproximaciones);

        if (!aproximaciones.isEmpty()) {
            aproximaciones_sin_repetir.add(aproximaciones.get(0));
        }
        
        
        for (int i = 0; i < aproximaciones.size(); i++) {
            
            if (!aproximaciones_sin_repetir.contains(aproximaciones.get(i))){
                aproximaciones_sin_repetir.add(aproximaciones.get(i));
            }
            
        }
        
        ArrayList <String> aproximaciones_mayor_a_menor = new ArrayList<>();
        ArrayList<Integer> calificacion_aproximaciones = new ArrayList<>();

        for (int i = 0; i < aproximaciones_sin_repetir.size(); i++) {
            int calificacion = 0;
            for (int j = 0; j < aproximaciones.size(); j++) {
                if (aproximaciones.get(j).equals(aproximaciones_sin_repetir.get(i))) {
                    calificacion++;
                }
            }
            calificacion_aproximaciones.add(calificacion);
        }
        int tmpMax;
        for (int h = 0; h < aproximaciones_sin_repetir.size(); h++) {
            tmpMax = -1;
            for (int i = 0; i < calificacion_aproximaciones.size(); i++) {
                if (tmpMax < calificacion_aproximaciones.get(i)) {
                    tmpMax = i;
                }
            }
            calificacion_aproximaciones.set(tmpMax, -1);
            aproximaciones_mayor_a_menor.add(aproximaciones_sin_repetir.get(tmpMax));
        }
        if(print){
            System.out.println(aproximaciones_mayor_a_menor);
        }
        
        return aproximaciones_mayor_a_menor;
    }

}
