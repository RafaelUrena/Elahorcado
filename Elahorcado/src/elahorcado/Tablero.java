/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elahorcado;

/**
 *
 * @author the_d
 */
public class Tablero {
//---------------------Atributos clase tablero----------------------------//
    private String palabra;
    private char palabrav[];
    private char palabraoculta[];
//************************Constructor*************************************//
    public Tablero() {
        this.palabra = generarPalabra();
        this.palabrav = new char[palabra.length()];
        this.palabraoculta = new char[palabra.length()];
    }
    
    /**
     * Iguala un vector de char 'palabrav[]' a una String elegida al azar. 
     */
    public void igualarPalabras(){
        
        for (int i = 0; i < palabra.length(); i++) {
            this.palabrav[i] = palabra.charAt(i);
        }
    }
    
    /**
     * Muestra guiones en vez de la palabra normal
     */
    public void ocultarPalabras(){
        
        for (int i = 0; i < palabra.length(); i++) {
            this.palabraoculta[i] = '_';
        }
    }
    
/**
 * Genera una palabra aleatoria, se pueden agregar más
 * @return String pala aleatoria
 */
    public String generarPalabra() {
        String pala = "";

        int alea = (int) (Math.random() * 5);

        switch (alea) {
            case 0:
                pala = "mesa";
                break;
            case 1:
                pala = "autobus";
                break;
            case 2:
                pala = "industria";
                break;
            case 3:
                pala = "murcielago";
                break;
            case 4:
                pala = "caleidoscopio";
                break;
        }

        return pala;
    }
    
    
    /**
     * Muestra la palabra
     */
    public void mostrartablero(){
        
        for (int i = 0; i < palabra.length(); i++) {
            System.out.print(palabra.charAt(i) + " ");
        }
        System.out.println("");
    }

    /**
     * Método para comprobar si la letra que introduce el usuario está,
     * también va sumando las letras acertadas,
     * por último contador va comprobando en el vector si la letra está y cuantas veces.
     * 
     * @param a letra que introduce el usuario
     * @param g vector para contar las letras que ha acertado
     * @return esta si contador es mayor o igual a 1 true, si es 0 devolvera false.
     */
    public boolean comprobarLetra(char a, int g[]){
        boolean esta = true;
        int cont = 0;
        
        
        for (int i = 0; i < this.palabrav.length; i++) {
            
            if(this.palabrav[i] == a){
                this.palabraoculta[i] = a;
                g[0] = g[0] +1;
                cont++;
                
            }          
        }
        
        if(cont >= 1){
                esta = true;
            } else{
                esta = false;
            }
        
        return esta;
            
    } 
    
    /**
     * Va mostrando la palabra oculta
     */
    public void mostrarPalabraoculta(){
        
        for (int i = 0; i < this.palabraoculta.length; i++) {
            System.out.print(this.palabraoculta[i] + " ");
        }
        System.out.println("");
    }
  
    /**
     * Método para devolver la longitud de la palabra
     * @return palabra.length()
     */
    public int length(){
        return palabra.length();
    }
}
