/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Jugador;
import Model.JugadorList;
import View.IView;
import View.TragaMoneda;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 9567
 */
public class JugadorController extends Thread {

    private JugadorList list;  
    private IView<JugadorList> view;  
    private TragaMoneda tragamoneda;  
    private boolean ejecucion = true;  // Para controlar el ciclo de juego
    private Jugador jugadorActual;  

    
    public JugadorController(JugadorList list, IView<JugadorList> view, TragaMoneda tragamoneda) {
        this.list = list;
        this.view = view;
        this.tragamoneda = tragamoneda;
    }

   
    public void insertJugador(String nombre) {
        Jugador jugador = new Jugador(nombre);
        boolean jug = list.add(jugador);
        if (jug) {
            jugadorActual = jugador;  
            view.showMessage("Jugador " + nombre + " añadido.");
        } else {
            view.showErrorMessage("Error: no se pudo añadir al jugador.");
        }
    }

    
        public void detener() {
            ejecucion = false;
            tragamoneda.detener();  // Detener también el juego del tragamoneda
        }

    
    @Override
    public void run() {
        if (jugadorActual == null) {
            view.showErrorMessage("No hay un jugador actual,  Agrega un jugador antes de jugar.");
            return;
        }
        view.showMessage("¡El jugador " + jugadorActual.getName() + " está jugando!");
        
        while (ejecucion) {
            int[] resultado = new int[3];

            
            for (int i = 0; i < 3; i++) {
                resultado[i] = (int) (Math.random() * 10);
            }

            // Mostrar los resultados en la vista del tragamoneda que serian boton1, 2 y 3
            tragamoneda.display(resultado[0], resultado[1], resultado[2]);

            
            try {
                Thread.sleep(100);  
            } catch (InterruptedException ex) {
                view.showErrorMessage("Hubo un error al ejecutar el juego.");
            }
        }

        
        tragamoneda.displayMessage("¡El tragamoneda ha parado!");
    }
}
