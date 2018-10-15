/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elahorcado;

import java.util.Scanner;

/**
 *
 * @author rafa
 */
public class Elahorcado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int VIDAS = 6;
        int intentos = 0;
        char letra;
        boolean esta = true;
        int ganar[] = new int[1];
        boolean haGanado = false;
        int longitud = 0;
        char repetir = 'y';

        Scanner sc = new Scanner(System.in);

        
        /**
         * Mientas repetir sea igual a 'y' las partidas se seguiran repitiendo
         */
        while (repetir == 'y') {
            VIDAS = 6;
            intentos = 0;
            haGanado = false;
            longitud = 0;

            Tablero t = new Tablero();

            t.generarPalabra();
            t.igualarPalabras();
            t.ocultarPalabras();
            longitud = t.length();

            t.mostrarPalabraoculta();

            ganar[0] = 0;

            /**
             * Mientras intentos sea menor a VIDAS y haGanado sea false
             */
            while (intentos < VIDAS && !haGanado) {
                esta = true;

                System.out.println("Escriba una letra");
                letra = sc.next().charAt(0);
                esta = t.comprobarLetra(letra, ganar);

                /**
                 * Sí esta es false la letra, no "esta", se incrementan intentos
                 */
                if (!esta) {
                    intentos++;
                }
                
                /**
                 * Si ganar[0] es igual a la longitud de la palabra, haGanado es true
                 */
                if (ganar[0] == longitud) {
                    haGanado = true;
                }

                t.mostrarPalabraoculta();

            }
            
            /**
             * Lo que mostrará sí ha ganado la partida
             */
            if (haGanado) {
                System.out.println("Has ganado la partida si desea volver a jugar pulse 'y', sí desea salir pulse cualquier tecla");
                repetir = sc.next().charAt(0);
            }

            /**
             * Lo que mostrará sí has perdido
             */
            if (intentos >= VIDAS) {
                System.out.println("Has perdido la palabra era: ");
                t.mostrartablero();
                System.out.println("Para jugar de nuevo pulse 'y', sí desea salir pulse cualquier tecla");
                repetir = sc.next().charAt(0);
            }
        }
    }

}
