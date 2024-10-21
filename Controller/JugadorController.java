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
import javax.swing.ImageIcon;

/**
 *
 * @author 9567
 */
public class JugadorController extends Thread {

//    private JugadorList list;  
//    private IView<JugadorList> view;  
//    private Jugador jugadorActual;
    private TragaMoneda tragamoneda;  
    private boolean ejecucion = true;
    private int tiempo = 100; 

    
//    public JugadorController(JugadorList list, IView<JugadorList> view, TragaMoneda tragamoneda) {
//        this.list = list;
//        this.view = view;
//        this.tragamoneda = tragamoneda;
//    }

   
//    public void insertJugador(String nombre) {
//        Jugador jugador = new Jugador(nombre);
//        boolean jug = list.add(jugador);
//        if (jug) {
//            jugadorActual = jugador;  
//            view.showMessage("Jugador " + nombre + " añadido.");
//        } else {
//            view.showErrorMessage("Error: no se pudo añadir al jugador.");
//        }
//    }

    
        public void detener() {
            ejecucion = false;
            Thread.currentThread().interrupt();
        }

    
    @Override
    public void run() {
        // Array con los nombres de las imágenes
        String[] nombresImagenes = {"Fresa.png", "Piña.png", "Sandia.png", "Uva.png"};        
        while (ejecucion) {
            int numero1 = (int) (Math.random() * 4); 
            int numero2 = (int) (Math.random() * 4); 
            int numero3 = (int) (Math.random() * 4);             
            String ruta1 = "src/IMG/" + nombresImagenes[numero1];
            String ruta2 = "src/IMG/" + nombresImagenes[numero2];
            String ruta3 = "src/IMG/" + nombresImagenes[numero3];            
            ImageIcon imagenIcon1 = new ImageIcon(ruta1);
            ImageIcon imagenIcon2 = new ImageIcon(ruta2);
            ImageIcon imagenIcon3 = new ImageIcon(ruta3);            
            View.TragaMoneda.B1.setIcon(imagenIcon1);
            View.TragaMoneda.B2.setIcon(imagenIcon2);
            View.TragaMoneda.B3.setIcon(imagenIcon3);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Error en el hilo: " + ex.getMessage());
            }
        }
    }
}
