/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtest;

/**
 *
 * @author jeisonOS
 */
public class ValorLetra {
    private String letra;
    private int valor;

    
    public ValorLetra(){

       }
    public ValorLetra(String letra,int valor)
    {
        this.letra=letra;
        this.valor=valor;
    }
    /**
     * @return the palabra
     */
    public String getLetra() {
        return letra;
    }

    /**
     * @param palabra the palabra to set
     */
    public void setLetra(String palabra) {
        this.letra = palabra;
    }

    /**
     * @return the valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
}
