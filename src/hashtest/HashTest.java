package hashtest;

import hashtest.Prueba2.Corrector;
import hashtest.Prueba2.Lector;
import java.sql.SQLException;

/**
 *
 * @author jeisonOS
 */
public class HashTest {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        /*
        Cuant_Palabras cuantificador=new Cuant_Palabras();
        cuantificador.asignacion_valor(palabras);
         */
        
        /*Corrector leng = new Corrector();
        leng.comparar("ecsplique",5,true); 
        System.out.println("");
        leng.comparar(" ecstrañaba",5,true); 
        System.out.println("");
        leng.comparar("ber",-1,true); 
        System.out.println("");
        leng.comparar("ezho",-1,true); 
        System.out.println("");
        leng.comparar("ecsplique",-1,true); 
        System.out.println("");
        leng.comparar("ecsplique",-1,true); 
        System.out.println("");*/
        
        //Lector x = new Lector();
        //x.leer("/home/jeisonOS/Downloads/sql_punto2_lab2.sql");
        
        Corrector leng = new Corrector();
        leng.comparar("enpleado",-1,true); 
        
        
    }

}
