/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtest.Prueba2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author jeisonOS
 */
public class Lector {
    
    public void leer (String ruta){
    
        
        ArrayList <String> lineasArchivo = new ArrayList<>();
        
        File rutaArchivo = new File(ruta);
        FileReader lectorArchivo = null;
        BufferedReader br = null;
        
        try {
            
            lectorArchivo = new FileReader(rutaArchivo);
            br = new BufferedReader(lectorArchivo);
            String linea = "";
            while ((linea = br.readLine())!= null) {
                if (!linea.equals("")){
                    lineasArchivo.add(linea);
                }
                
            }
            ArrayList <String> palabras = new ArrayList<>();
            palabras = extractorPalabras(lineasArchivo);
            for (int i = 0; i < palabras.size(); i++) {
                System.out.println(palabras.get(i));
                
            }
            
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } 
        
        
    }
    
    private ArrayList <String> extractorPalabras(ArrayList <String> lineasArchivo){
        ArrayList <String> lineasLimpias = new ArrayList<>();
        ArrayList <Character> caracteresPermitidos = new ArrayList<>();
        caracteresPermitidos.add('A');
        caracteresPermitidos.add('a');
        caracteresPermitidos.add('B');
        caracteresPermitidos.add('b');
        caracteresPermitidos.add('C');
        caracteresPermitidos.add('c');
        caracteresPermitidos.add('D');
        caracteresPermitidos.add('d');
        caracteresPermitidos.add('E');
        caracteresPermitidos.add('e');
        caracteresPermitidos.add('F');
        caracteresPermitidos.add('f');
        caracteresPermitidos.add('G');
        caracteresPermitidos.add('g');
        caracteresPermitidos.add('H');
        caracteresPermitidos.add('h');
        caracteresPermitidos.add('I');
        caracteresPermitidos.add('i');
        caracteresPermitidos.add('J');
        caracteresPermitidos.add('j');
        caracteresPermitidos.add('K');
        caracteresPermitidos.add('k');
        caracteresPermitidos.add('L');
        caracteresPermitidos.add('l');
        caracteresPermitidos.add('M');
        caracteresPermitidos.add('m');
        caracteresPermitidos.add('N');
        caracteresPermitidos.add('n');
        caracteresPermitidos.add('Ñ');
        caracteresPermitidos.add('ñ');
        caracteresPermitidos.add('O');
        caracteresPermitidos.add('o');
        caracteresPermitidos.add('P');
        caracteresPermitidos.add('p');
        caracteresPermitidos.add('Q');
        caracteresPermitidos.add('q');
        caracteresPermitidos.add('R');
        caracteresPermitidos.add('r');
        caracteresPermitidos.add('S');
        caracteresPermitidos.add('s');
        caracteresPermitidos.add('T');
        caracteresPermitidos.add('t');
        caracteresPermitidos.add('U');
        caracteresPermitidos.add('u');
        caracteresPermitidos.add('V');
        caracteresPermitidos.add('v');
        caracteresPermitidos.add('W');
        caracteresPermitidos.add('w');
        caracteresPermitidos.add('X');
        caracteresPermitidos.add('x');
        caracteresPermitidos.add('Y');
        caracteresPermitidos.add('y');
        caracteresPermitidos.add('Z');
        caracteresPermitidos.add('z');
        String tmp = "";
        for (int i = 0; i < lineasArchivo.size(); i++) {
            tmp = lineasArchivo.get(i);
            for (int j = 0; j < tmp.length(); j++) {
                boolean flagReemplazar = true;
                for (int k = 0; k < caracteresPermitidos.size(); k++) {
                    if (tmp.toCharArray()[j] == caracteresPermitidos.get(k)){
                        flagReemplazar = false;
                    }
                }
                if (flagReemplazar){
                    tmp = tmp.replace(tmp.toCharArray()[j], ',');
                }
                
            }
            lineasLimpias.add(tmp);
            
        }
        
        return lineasLimpias;
    }
    
}
